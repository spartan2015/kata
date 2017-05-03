package mastering.jdbc.dao1;

public class DBUtils
{
    private static class ExtendedCommitInfo extends CommitInfo
    {
        private static final int OPERATION_INSERT = 1;
        private static final int OPERATION_UPDATE = 0;
        private static final int OPERATION_DELETE = -1;

        private int              operation;

        private ExtendedCommitInfo(int pOperation, CommitInfo pCommitInfo)
        {
            this(pOperation, pCommitInfo.needsInsert(), pCommitInfo.getRecordCreationTimestamp(), pCommitInfo.getRecordUpdateTimestamp(),
                    pCommitInfo.getLastUpdateUserID());

            this.operation = pOperation;
        }

        private ExtendedCommitInfo(int pOperation, boolean pNeedsInsert, Timestamp pCreationTimestamp, Timestamp pUpdateTimestamp,
                String pUpdateUserID)
        {
            super(pNeedsInsert, pCreationTimestamp, pUpdateTimestamp, pUpdateUserID);

            this.operation = pOperation;
        }

        private boolean isInsert()
        {
            return this.operation == OPERATION_INSERT;
        }

        private boolean isUpdate()
        {
            return this.operation == OPERATION_UPDATE;
        }

        private boolean isDelete()
        {
            return this.operation == OPERATION_DELETE;
        }
    }

    private static class PoolInfo
    {
        private static Map<String, PoolInfo> pools;

        private String                       driverClassName;
        private String                       url;
        private String                       userName;
        private String                       password;
        private String                       schemaName;
        private boolean                      encryptedDBPassword;
        private boolean                      autoCommit;
        private String                       connectionTestTableName;
        private String                       serialValueTableName;
        private int                          maxConn;
        private int                          maxKeep;
        private String                       dbLocale;
        private int                          blockingReadConnectionTimeout;

        private PoolInfo()
        {
            super();
        }

        private static PoolInfo getPoolInfo(String poolName)
        {
            if (pools == null)
            {
                setupPools();
            }

            return pools.get(poolName);
        }

        private static synchronized void setupPools()
        {
            if (pools == null)
            {
                pools = new HashMap<String, PoolInfo>();
                RepositoryServiceIfc rs = RepositoryService.getInstance();
                boolean passwordEncrypted = rs.get("security.encryptedDBPassword", false);
                Hashtable<String, Object> poolTable = rs.get("database.pools", new Hashtable<String, Object>());

                for (String poolName : poolTable.keySet())
                {
                    PoolInfo poolInfo = new PoolInfo();
                    poolInfo.encryptedDBPassword = rs.get("database.pools." + poolName + ".encryptedDBPassword", passwordEncrypted);
                    poolInfo.autoCommit = rs.get("database.pools." + poolName + ".autoCommit", false);
                    poolInfo.driverClassName = rs.get("database.pools." + poolName + ".driverClassName", "");
                    poolInfo.userName = rs.get("database.pools." + poolName + ".userName", "");
                    poolInfo.password = rs.get("database.pools." + poolName + ".password", "");
                    poolInfo.url = rs.get("database.pools." + poolName + ".url", "");
                    poolInfo.maxConn = rs.get("database.pools." + poolName + ".maxConn", 0);
                    poolInfo.maxKeep = rs.get("database.pools." + poolName + ".maxKeep", 0);
                    poolInfo.schemaName = rs.get("database.pools." + poolName + ".schemaName", (String) null);
                    poolInfo.connectionTestTableName = rs.get(false, "database.pools." + poolName + ".connectionTestTableName",
                            "SYSIBM.SYSDUMMY1");
                    poolInfo.serialValueTableName = rs.get(false, "database.pools." + poolName + ".serialValueTableName", (String) null);
                    poolInfo.dbLocale = rs.get("database.pools." + poolName + ".dbLocale", "");
                    poolInfo.blockingReadConnectionTimeout = rs.get("database.pools." + poolName + ".blockingReadConnectionTimeout", -1);
                    if (poolInfo.blockingReadConnectionTimeout == -1)
                    {
                        poolInfo.blockingReadConnectionTimeout = rs.get("database.blockingReadConnectionTimeout", 0);
                    }
                    pools.put(poolName, poolInfo);
                }
            }
        }

        private String getDriverClassName()
        {
            return driverClassName;
        }

        private String getUrl()
        {
            return url;
        }

        private String getUserName()
        {
            return userName;
        }

        private String getPassword()
        {
            return password;
        }

        private String getSchemaName()
        {
            return schemaName;
        }

        private boolean isEncryptedDBPassword()
        {
            return encryptedDBPassword;
        }

        private boolean isAutoCommit()
        {
            return autoCommit;
        }

        private String getConnectionTestTableName()
        {
            return connectionTestTableName;
        }

        private String getSerialValueTableName()
        {
            return serialValueTableName;
        }

        private String getDbLocale()
        {
            return dbLocale;
        }

        private int getMaxConn()
        {
            return maxConn;
        }

        private int getMaxKeep()
        {
            return maxKeep;
        }

        private String qulifiedTableName(String tableName)
        {
            return new StringBuffer(CSStringUtils.convertNullToEmptyString(schemaName)).append('.').append(tableName).toString();
        }

        public int getBlockingReadConnectionTimeout()
        {
            return blockingReadConnectionTimeout;
        }
    }

    private static class DBBusinessObjects
    {
        private Map<CommitInfoSupport, ExtendedCommitInfo>        initialOperation  = new HashMap<CommitInfoSupport, ExtendedCommitInfo>();
        private Map<CommitInfoSupport, Stack<ExtendedCommitInfo>> ongoingOperations = new HashMap<CommitInfoSupport, Stack<ExtendedCommitInfo>>();
        private Set<TransactionCallBackSupport>                   callBackObjects   = new HashSet<TransactionCallBackSupport>();

        private DBBusinessObjects()
        {
            super();
        }

        private Map<CommitInfoSupport, CommitInfo> getInsertedObjects()
        {
            Map<CommitInfoSupport, CommitInfo> inserted = new HashMap<CommitInfoSupport, CommitInfo>();

            for (CommitInfoSupport object : ongoingOperations.keySet())
            {
                Stack<ExtendedCommitInfo> objectOperations = ongoingOperations.get(object);

                for (ExtendedCommitInfo extendedCommitInfo : objectOperations)
                {
                    if (extendedCommitInfo.isInsert())
                    {
                        inserted.put(object, extendedCommitInfo);
                    }
                }
            }
            return inserted;
        }

        private Map<CommitInfoSupport, CommitInfo> getUpdatedObjects()
        {
            Map<CommitInfoSupport, CommitInfo> updated = new HashMap<CommitInfoSupport, CommitInfo>();

            for (CommitInfoSupport object : ongoingOperations.keySet())
            {
                Stack<ExtendedCommitInfo> objectOperations = ongoingOperations.get(object);

                for (ExtendedCommitInfo extendedCommitInfo : objectOperations)
                {
                    if (extendedCommitInfo.isUpdate())
                    {
                        updated.put(object, extendedCommitInfo);
                    }
                }
            }
            return updated;
        }

        private Map<CommitInfoSupport, CommitInfo> getDeletedObjects()
        {
            Map<CommitInfoSupport, CommitInfo> deleted = new HashMap<CommitInfoSupport, CommitInfo>();

            for (CommitInfoSupport object : ongoingOperations.keySet())
            {
                Stack<ExtendedCommitInfo> objectOperations = ongoingOperations.get(object);

                for (ExtendedCommitInfo extendedCommitInfo : objectOperations)
                {
                    if (extendedCommitInfo.isDelete())
                    {
                        deleted.put(object, extendedCommitInfo);
                    }
                }
            }
            return deleted;
        }

        private Set<TransactionCallBackSupport> getCallBackObjects()
        {
            return callBackObjects;
        }

        private void addToObjectOperations(CommitInfoSupport pObject, ExtendedCommitInfo pExtendedCommitInfo)
        {
            if (initialOperation.get(pObject) == null)
            {
                initialOperation.put(pObject, pExtendedCommitInfo);
            }

            Stack<ExtendedCommitInfo> objectOperations = ongoingOperations.get(pObject);

            if (objectOperations == null)
            {
                objectOperations = new Stack<ExtendedCommitInfo>();
                ongoingOperations.put(pObject, objectOperations);
            }
            objectOperations.push(pExtendedCommitInfo);
        }

        private void addToInsertedObjects(CommitInfoSupport pObject)
        {
            ExtendedCommitInfo extendedCommitInfo = new ExtendedCommitInfo(ExtendedCommitInfo.OPERATION_INSERT, pObject.getCommitInfo());

            addToObjectOperations(pObject, extendedCommitInfo);
        }

        private void addToUpdatedObjects(CommitInfoSupport pObject)
        {
            ExtendedCommitInfo extendedCommitInfo = new ExtendedCommitInfo(ExtendedCommitInfo.OPERATION_UPDATE, pObject.getCommitInfo());

            addToObjectOperations(pObject, extendedCommitInfo);
        }

        private void addToDeletedObjects(CommitInfoSupport pObject)
        {
            ExtendedCommitInfo extendedCommitInfo = new ExtendedCommitInfo(ExtendedCommitInfo.OPERATION_DELETE, pObject.getCommitInfo());

            addToObjectOperations(pObject, extendedCommitInfo);
        }

        private void addToCallBackObjects(TransactionCallBackSupport pObject)
        {
            callBackObjects.add(pObject);
        }

        private void performTemporaryCommit()
        {
            for (CommitInfoSupport object : ongoingOperations.keySet())
            {
                Stack<ExtendedCommitInfo> operations = ongoingOperations.get(object);

                if (operations != null)
                {
                    if (!operations.isEmpty())
                    {
                        ExtendedCommitInfo commitInfo = operations.pop();

                        if (commitInfo.isInsert())
                        {
                            object.markInserted();
                        }
                        else if (commitInfo.isUpdate())
                        {
                            object.markUpdated();
                        }
                        else if (commitInfo.isDelete())
                        {
                            object.markDeleted();
                        }
                    }
                }
            }
        }

        private void performTemporaryRollback()
        {
            for (CommitInfoSupport object : ongoingOperations.keySet())
            {
                Stack<ExtendedCommitInfo> operations = ongoingOperations.get(object);

                if (operations != null)
                {
                    if (!operations.isEmpty())
                    {
                        ExtendedCommitInfo commitInfo = operations.pop();
                        object.updateFromCommitInfo(commitInfo);
                    }
                }
            }
        }

        private void transactionDidCommit()
        {
            performTemporaryCommit();
            transactionDidFinish(false, "");
        }

        private void transactionDidRollback(String reason)
        {
            performTemporaryRollback();
            transactionDidFinish(true, reason);
        }

        private void transactionDidFinish(boolean isRollback, String reason)
        {
            Set<TransactionCallBackSupport> objectsToCall = new HashSet<TransactionCallBackSupport>();

            for (CommitInfoSupport object : initialOperation.keySet())
            {
                if (isRollback)
                {
                    object.updateFromCommitInfo(initialOperation.get(object));
                }
                objectsToCall.add(object);
            }

            objectsToCall.addAll(callBackObjects);

            resetLists();

            callObjectsBack(objectsToCall, isRollback, reason);
        }

        private void callObjectsBack(Set<TransactionCallBackSupport> objectsToCall, boolean isRollback, String rollbackReason)
        {
            if (objectsToCall != null)
            {
                for (TransactionCallBackSupport o : objectsToCall)
                {
                    try
                    {
                        if (isRollback)
                        {
                            o.transactionDidRollback(rollbackReason);
                        }
                        else
                        {
                            o.transactionDidCommit();
                        }
                    }
                    catch (Exception e)
                    {
                        LoggingService.getInstance().error("Error during callBack of objects: ", e);
                    }
                }
            }
        }

        private void resetLists()
        {
            initialOperation = new HashMap<CommitInfoSupport, ExtendedCommitInfo>();
            ongoingOperations = new HashMap<CommitInfoSupport, Stack<ExtendedCommitInfo>>();
            callBackObjects = new HashSet<TransactionCallBackSupport>();
        }
    }

    private static class ThreadInfo
    {
        /*
         * In dieser Map werden sämtliche Datenbank relevanten Information gespeichert. Der Zugriff erfolgt nur über die Methoden
         * getThreadInformation() und getThreadInformation(Thread aThread)
         */
        private static Map<Integer, ThreadInfo> threads                   = Collections.synchronizedMap(new HashMap<Integer, ThreadInfo>());

        private static final boolean            validateAllDb2Connections = RepositoryService.getInstance().get(
                                                                                  "validateAllDb2Connections.active", false);

        private DBBusinessObjects               dbBusinessObjects         = new DBBusinessObjects();
        private Map<String, List<Connection>>   connections               = new HashMap<String, List<Connection>>();

        private int                             transactionNestingLevel;

        /*
         * Liefert das ThreadInformation Objekt für den currentThread. Existiert kein ThreadInfo Objekt, dann wird eines erzeugt.
         */
        private static ThreadInfo getThreadInfo()
        {
            return getThreadInfo(Thread.currentThread());
        }

        /*
         * Liefert das ThreadInformation Objekt für aThread. Existiert kein ThreadInfo Objekt, dann wird eines erzeugt.
         */
        private static ThreadInfo getThreadInfo(Thread aThread)
        {
            ErrorHandlingService.assertNotNull(aThread, "Parameter aThread darf nicht null sein");

            ThreadInfo threadInfo = null;
            Integer threadHash = Integer.valueOf(aThread.hashCode());

            threadInfo = threads.get(threadHash);

            if (threadInfo == null)
            {
                threadInfo = new ThreadInfo();
                threads.put(threadHash, threadInfo);
            }
            return threadInfo;
        }

        private static void resetThreadInfo()
        {
            resetThreadInfo(Thread.currentThread());
        }

        private static void resetThreadInfo(Thread aThread)
        {
            threads.remove(Integer.valueOf(aThread.hashCode()));
        }

        private DBBusinessObjects getDbBusinessObjects()
        {
            return dbBusinessObjects;
        }

        private boolean hasOpenTransaction()
        {
            return transactionNestingLevel > 0;
        }

        private int getTransactionNestingLevel()
        {
            return transactionNestingLevel;
        }

        private int openTransaction()
        {
            return ++transactionNestingLevel;
        }

        private int commitTransaction()
        {
            return --transactionNestingLevel;
        }

        private int rollbackTransaction()
        {
            return --transactionNestingLevel;
        }

        private Connection getExistingConnection(String poolName)
        {
            Connection con = null;
            List<Connection> cons = connections.get(poolName);

            if (cons != null && cons.size() > 0)
            {
                con = cons.get(0);
            }
            return con;
        }

        private void registerConnection(String poolName, Connection con)
        {
            List<Connection> cons = connections.get(poolName);
            if (cons == null)
            {
                cons = new ArrayList<Connection>();
                connections.put(poolName, cons);
            }
            if (!cons.contains(con))
            {
                cons.add(con);
            }
        }

        private boolean validateAllConnections() throws SQLException
        {
            if (validateAllDb2Connections)
            {
                ConPoolsManager manager = ConPoolsManager.getInstance();
                for (String poolName : connections.keySet())
                {
                    List<Connection> cons = connections.get(poolName);
                    ConnectionsPool pool = manager.getPool(poolName);

                    if (cons != null && cons.size() > 0)
                    {
                        for (Connection connection : cons)
                        {
                            if (!pool.validateConnection(connection))
                            {
                                if (TracingService.isON())
                                {
                                    TracingService.getInstance().error(this,
                                            "VALIDATE ALL CONNECTIONS - CONNECTION ERROR IN POOL " + poolName);
                                }
                                return false;
                            }
                        }
                    }
                }
                if (TracingService.isON())
                {
                    TracingService.getInstance().message(this, "VALIDATE ALL CONNECTIONS - OK");
                }
            }
            return true;
        }

        private void commitAllConnections() throws SQLException
        {
            for (String poolName : connections.keySet())
            {
                List<Connection> cons = connections.get(poolName);

                if (cons != null && cons.size() > 0)
                {
                    for (Connection connection : cons)
                    {
                        connection.commit();

                        DBConnectionTracer.get(Integer.valueOf(connection.hashCode())).processEvent(
                                Integer.valueOf(Thread.currentThread().hashCode()), DBConnectionEvent.COMMIT);
                    }
                }
            }
        }

        public void rollbackAllConnections() throws SQLException
        {
            for (String poolName : connections.keySet())
            {
                List<Connection> cons = connections.get(poolName);

                if (cons != null && cons.size() > 0)
                {
                    for (Connection connection : cons)
                    {
                        connection.rollback();

                        DBConnectionTracer.get(Integer.valueOf(connection.hashCode())).processEvent(
                                Integer.valueOf(Thread.currentThread().hashCode()), DBConnectionEvent.ROLLBACK);
                    }
                }
            }
        }

        public void freeAllConnections()
        {
            freeAllConnections(false);
        }

        public void freeAllConnections(boolean hasErrors)
        {
            for (String poolName : connections.keySet())
            {
                List<Connection> cons = connections.get(poolName);

                if (cons != null && cons.size() > 0)
                {
                    for (Connection connection : cons)
                    {
                        DBUtils.reallyFreeConnection(connection, poolName, hasErrors);
                    }
                }
            }
            connections.clear();
        }

        public boolean hasRegisteredConnections()
        {
            boolean result = false;

            for (String poolName : connections.keySet())
            {
                List<Connection> cons = connections.get(poolName);

                if (cons != null && cons.size() > 0)
                {
                    result = true;
                }
            }
            return result;
        }
    }

    public static final String           DEFAULT_POOL_NAME                     = RepositoryService.getInstance().get(
                                                                                       "database.defaultPoolName", "IUCCA_Pool");

    private static final boolean         isUseConfidentialLoggingService       = RepositoryService.getInstance().get(
                                                                                       "confidentialLoggingService.active", false);

    private static final long            VALID_TIME_IN_MILLIES                 = 60000;
    private static final long            WAIT_TIME_BEFORE_RECONNECT_IN_MILLIES = 1000;
    private static final int             NUMBER_OF_RECONNECT_RETRIES           = 3;

    private static Map<Connection, Long> lastValidConnectionTimestamps         = Collections
                                                                                       .synchronizedMap(new HashMap<Connection, Long>());

    private DBUtils()
    {
        super();
    }

    /**
     * Returns the name of the Default ConnectionPool. If "database.defaultPoolName" is not defined in the Repository, this method returns
     * the String "IUCCA_Pool". It is also possible to access the defaultPoolName through DBUtilsNew.DEFAULT_POOL_NAME.
     *
     * @return java.lang.String
     */
    public static String getDefaultPoolName()
    {
        return DEFAULT_POOL_NAME;
    }

    public static String getSchemaName()
    {
        return getSchemaName(DEFAULT_POOL_NAME);
    }

    public static String getSchemaName(String poolName)
    {
        return PoolInfo.getPoolInfo(poolName).getSchemaName();
    }

    public static String qualifiedTableName(String tableName)
    {
        return qualifiedTableName(tableName, DEFAULT_POOL_NAME);
    }

    public static String qualifiedTableName(String tableName, String poolName)
    {
        return PoolInfo.getPoolInfo(poolName).qulifiedTableName(tableName);
    }

    public static long nextSerialValue(String type)
    {
        return nextSerialValue(type, DEFAULT_POOL_NAME);
    }

    public static long nextSerialValues(String type, int numberOfSerialValues)
    {
        return nextSerialValue(type, DEFAULT_POOL_NAME, Long.MIN_VALUE, numberOfSerialValues);
    }

    public static long nextSerialValue(String type, long startValue)
    {
        return nextSerialValue(type, DEFAULT_POOL_NAME, startValue, 1);
    }

    public static long nextSerialValue(String type, String poolName)
    {
        return nextSerialValue(type, poolName, Long.MIN_VALUE, 1);
    }

    public static String nextSerialValueAsString(String type)
    {
        return nextSerialValueAsString(type, DEFAULT_POOL_NAME);
    }

    public static String nextSerialValueAsString(String type, String poolName)
    {
        long nextSerial = nextSerialValue(type, poolName);

        return nextSerial + "";
    }

    public static synchronized long nextSerialValue(String type, String poolName, long startValue, int numberOfSerialValues)
    {
        String serialTableName = PoolInfo.getPoolInfo(poolName).getSerialValueTableName();
        long result = 0;

        if (serialTableName == null)
        {
            if (TracingService.isON())
            {
                TracingService.getInstance().message(null,
                        "No serialValueTableName defined for Pool " + poolName + ", using timestamp to create next serial value");
            }
            return Calendar.getInstance().getTime().getTime();
        }

        StringBuffer buf = null;
        Connection con = null;
        DshPreparedStatement pstmt = null;
        DshPreparedStatement pstmt2 = null;
        ResultSet rs = null;

        try
        {
            // always get a new connection to avoid deadlock in transactions
            con = getNewConnection(poolName);

            buf = new StringBuffer();
            buf.append("SELECT ");
            buf.append("foid_object_id ");
            buf.append("FROM ");
            buf.append(qualifiedTableName(serialTableName, poolName) + " ");
            buf.append("WHERE ");
            buf.append("foid_object_type = ? ");
            buf.append("FOR UPDATE OF foid_object_id ");

            pstmt = DshPreparedStatementImpl.create(con, buf.toString());
            pstmt.clearParameters();
            pstmt.setString(1, type);

            if (TracingService.isON())
            {
                TracingService.getInstance().message(null, pstmt.toString());
            }

            rs = pstmt.executeQuery();

            if (rs.next())
            {
                result = rs.getLong("foid_object_id");
                result++;

                buf = new StringBuffer();
                buf.append("UPDATE ");
                buf.append(qualifiedTableName(serialTableName, poolName) + " ");
                buf.append("SET ");
                buf.append("foid_object_id = ?, ");
                buf.append("FOID_REC_UPD_TS = ? ");
                buf.append("WHERE ");
                buf.append("foid_object_type = ? ");

                pstmt2 = DshPreparedStatementImpl.create(con, buf.toString());
                pstmt2.clearParameters();
                pstmt2.setLong(1, result + numberOfSerialValues - 1);
                pstmt2.setTimestamp(2, new Timestamp(new Date().getTime()));
                pstmt2.setString(3, type);

                if (TracingService.isON())
                {
                    TracingService.getInstance().message(null, pstmt2.toString());
                }

                pstmt2.executeUpdate();
            }
            else
            {
                if (startValue == Long.MIN_VALUE)
                {
                    result = RepositoryService.getInstance().get("database.pools." + poolName + ".sequenceNumberOffset." + type, 1L);
                }
                else
                {
                    result = startValue;
                }

                buf = new StringBuffer();
                buf.append("INSERT ");
                buf.append("INTO ");
                buf.append(qualifiedTableName(serialTableName, poolName) + " ");
                buf.append("( foid_object_type, foid_object_id, FOID_REC_UPD_TS, FOID_REC_CREATE_TS ) ");
                buf.append("VALUES ( ?, ?, ?, ? ) ");

                pstmt2 = DshPreparedStatementImpl.create(con, buf.toString());
                pstmt2.clearParameters();
                pstmt2.setString(1, type);
                pstmt2.setLong(2, result + numberOfSerialValues - 1);
                pstmt2.setTimestamp(3, new Timestamp(new Date().getTime()));
                pstmt2.setTimestamp(4, new Timestamp(new Date().getTime()));

                if (TracingService.isON())
                {
                    TracingService.getInstance().message(null, pstmt2.toString());
                }

                pstmt2.executeUpdate();
            }

            con.commit();

        }
        catch (SQLException ex)
        {
            try
            {
                if (con != null)
                {
                    con.rollback();
                }
            }
            catch (SQLException e)
            {
                throw new DatabaseSQLException("db.databaseError", "Database error during rollback " + ex.getLocalizedMessage(), ex);
            }

            if (TracingService.isON())
            {
                TracingService.getInstance().error(null, "Database error during next serial Value creation " + ex.getLocalizedMessage());
            }

            throw new DatabaseSQLException("db.databaseError", "Database error during next serial Value creation "
                    + ex.getLocalizedMessage(), ex);
        }
        finally
        {
            closeResultSet(rs);
            closeStatement(pstmt);
            closeStatement(pstmt2);
            reallyFreeConnection(con, poolName);
        }

        if (TracingService.isON())
        {
            TracingService.getInstance().message(null, "Returned >" + result + "< as next serial Value for type " + type);
        }
        return result;
    }

    public static Map<CommitInfoSupport, CommitInfo> getInsertedObjects()
    {
        return ThreadInfo.getThreadInfo().getDbBusinessObjects().getInsertedObjects();
    }

    public static Map<CommitInfoSupport, CommitInfo> getUpdatedObjects()
    {
        return ThreadInfo.getThreadInfo().getDbBusinessObjects().getUpdatedObjects();
    }

    public static Map<CommitInfoSupport, CommitInfo> getDeletedObjects()
    {
        return ThreadInfo.getThreadInfo().getDbBusinessObjects().getDeletedObjects();
    }

    public static Set<TransactionCallBackSupport> getCallbackObjects()
    {
        return ThreadInfo.getThreadInfo().getDbBusinessObjects().getCallBackObjects();
    }

    public static void addToInsertedObjects(CommitInfoSupport anObject)
    {
        ThreadInfo.getThreadInfo().getDbBusinessObjects().addToInsertedObjects(anObject);
    }

    public static void addToUpdatedObjects(CommitInfoSupport anObject)
    {
        ThreadInfo.getThreadInfo().getDbBusinessObjects().addToUpdatedObjects(anObject);
    }

    public static void addToDeletedObjects(CommitInfoSupport anObject)
    {
        ThreadInfo.getThreadInfo().getDbBusinessObjects().addToDeletedObjects(anObject);
    }

    public static void addToCallbackObjects(TransactionCallBackSupport anObject)
    {
        ThreadInfo.getThreadInfo().getDbBusinessObjects().addToCallBackObjects(anObject);
    }

    public static int getNumberOfCheckedOutConnections()
    {
        return getNumberOfCheckedOutConnections(DEFAULT_POOL_NAME);
    }

    public static int getNumberOfCheckedOutConnections(String poolName)
    {
        if (CSStringUtils.isNullOrEmptyString(poolName))
        {
            throw new DatabaseException("db.databaseError", "Pool name missing in " + CSUtils.getCurrentClassAndMethod());
        }

        ConnectionsPool pool = ConPoolsManager.getInstance().getPool(poolName);

        return pool.getNumberOfCheckedOutConnections();
    }

    public static int getNumberOfCachedConnections()
    {
        return getNumberOfCachedConnections(DEFAULT_POOL_NAME);
    }

    public static int getNumberOfCachedConnections(String poolName)
    {
        if (CSStringUtils.isNullOrEmptyString(poolName))
        {
            throw new DatabaseException("db.databaseError", "Pool name missing in " + CSUtils.getCurrentClassAndMethod());
        }

        ConnectionsPool pool = ConPoolsManager.getInstance().getPool(poolName);

        return pool.getNumberOfCachedConnections();
    }

    private static void updateNumberOfDBConnections(Timestamp timeStamp, String poolname, int connCount)
    {
        DBConnectionStatisticDispatcher dbConnect = DBConnectionStatisticDispatcher.getInstance();

        try
        {
            if (timeStamp != null && poolname != null && connCount > 0)
            {
                dbConnect.refreshConnectionCount(timeStamp, poolname, connCount);
            }
        }
        catch (ParseException e)
        {
            TracingService.getInstance().warning(CSUtils.getCurrentClassAndMethod(), e.getMessage());
        }
    }

    /**
     * closes a statement
     *
     * @param statement
     */
    public static void closeResultSet(ResultSet rs)
    {
        try
        {
            if (rs != null)
            {
                rs.close();
            }
        }
        catch (SQLException e)
        {
            TracingService.getInstance().error("Closing result set failed");
        }

    }

    /**
     * closes a statement
     *
     * @param statement
     */
    public static void closeStatement(Statement stmt)
    {
        try
        {
            if (stmt != null)
            {
                stmt.close();
            }
        }
        catch (SQLException e)
        {
            TracingService.getInstance().error("Closing statement failed");
        }
    }

    /**
     * This method returns an available connection from the default connection pool. This method calls getConnection(connection,
     * getDefaultPoolName()) to perform this operation.<br>
     * If there is a connection with an open transaction for the current thread, then this connection is returned.
     *
     * @return java.sql.Connection
     */
    public static Connection getConnection()
    {
        return getConnection(DEFAULT_POOL_NAME);
    }

    /**
     * This method returns an available connection from the named connection pool.<br>
     * If there is a connection with an open transaction for the current thread, then this connection is returned.
     *
     * @param poolName
     *            java.String the name of the Connection pool
     * @return java.sql.Connection
     */
    public static Connection getConnection(String poolName)
    {
        ThreadInfo info = ThreadInfo.getThreadInfo();
        Connection con = info.getExistingConnection(poolName);

        if (con == null)
        {
            con = getNewConnection(poolName);

            if (info.hasOpenTransaction())
            {
                info.registerConnection(poolName, con);
            }
        }

        return con;
    }

    /**
     * This method returns an available connection from the named connection pool.
     *
     * @param poolName
     *            java.String the name of the Connection pool
     * @return java.sql.Connection
     */
    private static Connection getNewConnection(String poolName)
    {
        if (CSStringUtils.isNullOrEmptyString(poolName))
        {
            throw new DatabaseException("db.databaseError", "Pool name '" + poolName + "' missing in " + CSUtils.getCurrentClassAndMethod());
        }

        ConPoolsManager manager = ConPoolsManager.getInstance();
        ConnectionsPool pool = manager.getPool(poolName);
        PoolInfo poolInfo = PoolInfo.getPoolInfo(poolName);
        Connection connection = null;
        PreparedStatement stmt = null;
        boolean connectionOK = false;
        RepositoryServiceIfc rs = RepositoryService.getInstance();
        long timeout = rs.get("database.waitMilliesBeforeReconnect", WAIT_TIME_BEFORE_RECONNECT_IN_MILLIES);
        int maxTries = rs.get("database.numberOfConnectRetries", NUMBER_OF_RECONNECT_RETRIES);
        int tries = 0;

        if (pool == null)
        {
            try
            {
                String password = poolInfo.getPassword();

                if (poolInfo.isEncryptedDBPassword())
                {
                    password = Decryptor.sharedInstance().decrypt(password);
                }

                pool = manager.createPool(poolInfo.getDriverClassName(), poolName, poolInfo.getUrl(), poolInfo.getUserName(), password,
                        poolInfo.getBlockingReadConnectionTimeout(), poolInfo.getMaxConn(), poolInfo.getMaxKeep());

                pool.setConnectionTestTable(poolInfo.getConnectionTestTableName());

            }
            catch (PoolCreationException ex)
            {
                throw new DatabaseException("db.databaseConnectionError", "Pool creation for '" + poolName + "' failed in "
                        + CSUtils.getCurrentClassAndMethod(), ex);
            }
        }

        while (!connectionOK && tries < maxTries)
        {
            connectionOK = true;
            tries++;

            try
            {
                connection = pool.getConnection(timeout);
            }
            catch (InvalidConnectionException ex)
            {
                connectionOK = false;
            }

            if (connectionOK)
            {
                Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
                updateNumberOfDBConnections(timeStamp, poolName, getNumberOfCheckedOutConnections(poolName));

                boolean shouldValidate = true;

                Long lastValid = lastValidConnectionTimestamps.get(connection);

                if (lastValid != null)
                {
                    if (new Date().getTime() - lastValid.longValue() <= VALID_TIME_IN_MILLIES)
                    {
                        shouldValidate = false;
                    }
                    lastValidConnectionTimestamps.remove(connection);
                }
                if (shouldValidate)
                {
                    try
                    {
                        boolean autoCommit = poolInfo.isAutoCommit();
                        if (connection.getAutoCommit() != poolInfo.isAutoCommit())
                        {
                            TracingService.getInstance().message(
                                    null,
                                    "DBConnection AutoCommitMode was " + (connection.getAutoCommit() ? "ON" : "OFF") + ". Switching to "
                                            + (autoCommit ? "ON" : "OFF") + ".");
                            connection.setAutoCommit(autoCommit);
                        }

                        String localeName = poolInfo.getDbLocale();
                        if (CSStringUtils.isNotNullOrEmptyString(localeName))
                        {
                            stmt = connection.prepareStatement("SET CURRENT LOCALE LC_CTYPE = ?");
                            stmt.setString(1, localeName);
                            stmt.execute();
                            closeStatement(stmt);
                        }
                    }
                    catch (SQLException ex)
                    {
                        connectionOK = false;
                        closeStatement(stmt);
                        pool.freeConnection(connection, true);
                    }
                }
            }
        }

        if (!connectionOK)
        {
            throw new DatabaseException("db.databaseConnectionError", "Unable to get a new connection with PoolName '" + poolName + "' in "
                    + CSUtils.getCurrentClassAndMethod());
        }

        return connection;
    }

    /**
     * This method returns a connection which is used to group several database operations within one transaction. If this method is called
     * more than once by one thread, the same connection is returned and the transaction nesting level is increased. If this happens, all
     * calls to <tt>commitTransaction()<tt> and <tt>rollbackTransaction()<tt> reduce just the
     * transaction nesting level. If there are no nested transactions (nesting level 1) these methods
     * perform a commit or rollback. Uses the default pool name.
     *
     * @return java.sql.Connection
     */
    public static Connection openTransaction()
    {
        return openTransaction(DEFAULT_POOL_NAME);
    }

    /**
     * This method returns a connection which is used to group several database operations within one transaction. If this method is called
     * more than once by one thread, the same connection is returned and the transaction nesting level is increased. If this happens, all
     * calls to <tt>commitTransaction()<tt> and <tt>rollbackTransaction()<tt> reduce just the
     * transaction nesting level. If there are no nested transactions (nesting level 1) these methods
     * perform a commit or rollback.
     * Uses poolName to determine, which database to use.
     *
     * @param poolName
     *            java.String the name of the Connection pool
     * @return java.sql.Connection
     */
    public static Connection openTransaction(String poolName)
    {
        if (TracingService.isON())
        {
            TracingService.getInstance().message("DBUtils.openTransaction", "OPEN TRANSACTION");
        }

        ThreadInfo info = ThreadInfo.getThreadInfo();
        Connection con = info.getExistingConnection(poolName);

        if (con == null)
        {

            con = getNewConnection(poolName);
            info.registerConnection(poolName, con);
        }

        info.openTransaction();

        if (TracingService.isON())
        {
            TracingService.getInstance().message("DBUtils.openTransaction",
                    "INCREASING TRANSACTION NESTING LEVEL TO " + info.getTransactionNestingLevel());
        }

        return con;
    }

    /**
     * This method adds connection back to the defaultPool, so it can be reused. This method calls freeConnection(connection,
     * getDefaultPoolName()) to perform this operation. The connection is only marked available, if it is not used by an open transaction.
     *
     * @param connection
     *            java.sql.Connection
     */
    public static void freeConnection(Connection connection)
    {
        freeConnection(connection, DEFAULT_POOL_NAME);
    }

    /**
     * This method adds connection back to the defaultPool, so it can be reused. The connection is only marked available, if it is not used
     * by an open transaction. Uses poolName to determine, which database to use.
     *
     * @param poolName
     *            java.String the name of the Connection pool
     * @param connection
     *            java.sql.Connection
     */
    public static void freeConnection(Connection connection, String poolName)
    {
        if (connection == null)
        {
            return;
        }

        ThreadInfo info = ThreadInfo.getThreadInfo();

        if (!info.hasOpenTransaction())
        {
            reallyFreeConnection(connection, poolName);
        }
        else
        {
            info.registerConnection(poolName, connection);
        }
    }

    /**
     * This method adds connection back to the named pool, so it can be reused.
     *
     * @param connection
     *            java.sql.Connection
     * @param poolName
     *            java.String the name of the Connection pool
     */
    private static void reallyFreeConnection(Connection connection, String poolName)
    {
        reallyFreeConnection(connection, poolName, false);
    }

    /**
     * This method adds connection back to the named pool, so it can be reused.
     *
     * @param connection
     *            java.sql.Connection
     * @param poolName
     *            java.String the name of the Connection pool
     */
    public static void reallyFreeConnection(Connection connection, String poolName, boolean connectionHadErrors)
    {
        if (CSStringUtils.isNullOrEmptyString(poolName))
        {
            throw new DatabaseException("db.databaseError", "Pool name missing in " + CSUtils.getCurrentClassAndMethod());
        }

        if (connection == null)
        {
            throw new DatabaseException("db.databaseError", "Missing connection in " + CSUtils.getCurrentClassAndMethod());
        }

        ConPoolsManager manager = ConPoolsManager.getInstance();
        ConnectionsPool pool = manager.getPool(poolName);

        if (pool != null)
        {
            if (!connectionHadErrors)
            {
                lastValidConnectionTimestamps.put(connection, Long.valueOf(new Date().getTime()));
            }

            pool.freeConnection(connection, connectionHadErrors);

            Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
            updateNumberOfDBConnections(timeStamp, poolName, getNumberOfCheckedOutConnections(poolName));
        }
        else
        {
            throw new DatabaseException("db.databaseError", "The pool named " + poolName
                    + " does not exist. Release the connection programmatically");
        }
    }

    public static void assureConnectionsAreRemovedFromThread()
    {
        ThreadInfo info = ThreadInfo.getThreadInfo();

        if (info.hasRegisteredConnections())
        {
            LoggingService.getInstance().warning("db.databaseWarning: Found pending DB connection for current thread, removing ... ");
            boolean rollbackCompleted = false;
            try
            {
                info.rollbackAllConnections();
                rollbackCompleted = true;
            }
            catch (SQLException ex)
            {
                LoggingService.getInstance().error(
                        "db.databaseError: Unexpected SQLException in assureConnectionAreRemovedAfterRequest: " + ex);
            }
            finally
            {
                info.getDbBusinessObjects().transactionDidRollback(null);
                info.freeAllConnections(!rollbackCompleted);
                ThreadInfo.resetThreadInfo();
            }
        }
    }

    /**
     * This method commits a connection, if there is no open transaction opened by the <tt>openTransaction</tt> method. Uses the default
     * pool name.
     *
     * @param connection
     *            java.sql.Connection
     */
    public static void commit(Connection connection) throws SQLException
    {
        commit(connection, DEFAULT_POOL_NAME);
    }

    /**
     * This method commits a connection, if there is no open transaction opened by the <tt>openTransaction</tt> method. Uses poolName to
     * determine, which database to use.
     *
     * @param poolName
     *            java.String the name of the Connection pool
     * @param connection
     *            java.sql.Connection
     */
    public static void commit(Connection connection, String poolName) throws SQLException
    {
        commitInternal(connection, poolName, false);
    }

    /**
     * This method commits a connection, if there is no open transaction opened by the <tt>openTransaction</tt> method. Uses poolName to
     * determine, which database to use.
     *
     * @param poolName
     *            java.String the name of the Connection pool
     * @param connection
     *            java.sql.Connection
     */
    public static void commitWithoutConfidentialLoggingService(Connection connection) throws SQLException
    {
        commitInternal(connection, DEFAULT_POOL_NAME, true);
    }

    private static void commitInternal(Connection connection, String poolName, boolean disableConfidentialLoggingService)
            throws SQLException
    {
        if (connection == null)
        {
            return;
        }

        ThreadInfo info = ThreadInfo.getThreadInfo();

        if (!info.hasOpenTransaction())
        {
            if (TracingService.isON())
            {
                TracingService.getInstance().message("COMMIT");
            }

            connection.commit();

            DBConnectionTracer.get(Integer.valueOf(connection.hashCode())).processEvent(Integer.valueOf(Thread.currentThread().hashCode()),
                    DBConnectionEvent.COMMIT);
            info.getDbBusinessObjects().transactionDidCommit();
        }
        else
        {
            info.registerConnection(poolName, connection);
            info.getDbBusinessObjects().performTemporaryCommit();
        }
    }

    /**
     * This method commits a transaction formerly opened by the <tt>openTransaction</tt> method if there are no nested transactions. If
     * there are nested transactions this method reduces the nesting level by 1, otherwise a commit is performed. When the commit was
     * successfull the connection is removed from the openTransactionConnection list and returned to the connectionPool. Uses the default
     * pool name.
     *
     * @param connection
     *            java.sql.Connection
     */
    public static void commitTransaction()
    {
        commitTransaction(DEFAULT_POOL_NAME);
    }

    /**
     * This method commits a transaction formerly opened by the <tt>openTransaction</tt> method if there are no nested transactions. If
     * there are nested transactions this method reduces the nesting level by 1, otherwise a commit is performed. When the commit was
     * successfull the connection is removed from the openTransactionConnection list and returned to the connectionPool. Uses poolName to
     * determine, which database to use.
     *
     * @param poolName
     *            java.String the name of the Connection pool
     */
    public static void commitTransaction(String poolName)
    {
        ThreadInfo info = ThreadInfo.getThreadInfo();

        if (info.commitTransaction() < 1)
        {
            boolean commitCompleted = false;
            boolean freeCompleted = false;

            try
            {
                if (TracingService.isON())
                {
                    TracingService.getInstance().message("DBUtils.commitTransaction", "COMMIT TRANSACTION");
                }

                if (info.validateAllConnections())
                {
                    info.commitAllConnections();
                    commitCompleted = true;
                    info.freeAllConnections();
                    freeCompleted = true;
                    info.getDbBusinessObjects().transactionDidCommit();
                }
                else
                {
                    info.rollbackAllConnections();
                    info.freeAllConnections();
                    freeCompleted = true;
                    info.getDbBusinessObjects().transactionDidRollback(null);
                }

            }
            catch (SQLException ex)
            {
                if (!freeCompleted)
                {
                    info.freeAllConnections(!commitCompleted);
                }
                throw new DatabaseSQLException("db.databaseError", "Unexpected SQLException in " + CSUtils.getCurrentClassAndMethod(), ex);
            }
            finally
            {
                ThreadInfo.resetThreadInfo();
            }
        }
        else
        {
            if (TracingService.isON())
            {
                TracingService.getInstance().message("DBUtils.commitTransaction",
                        "DECREASING TRANSACTION NESTING LEVEL TO " + info.getTransactionNestingLevel());
            }
        }
    }

    /**
     * This method rolls back a connection, if there is no open transaction opened by the <tt>openTransaction</tt> method. Uses the default
     * pool name.
     *
     * @param connection
     *            java.sql.Connection
     */
    public static void rollback(Connection connection)
    {
        rollback(connection, DEFAULT_POOL_NAME);
    }

    /**
     * This method rolls back a connection, if there is no open transaction opened by the <tt>openTransaction</tt> method. Uses poolName to
     * determine, which database to use.
     *
     * @param poolName
     *            java.String the name of the Connection pool
     * @param connection
     *            java.sql.Connection
     */
    public static void rollback(Connection connection, String poolName)
    {
        rollbackInternal(connection, poolName, false);
    }

    public static void rollbackWithoutConfidentialLoggingService(Connection connection)
    {
        rollbackInternal(connection, DEFAULT_POOL_NAME, true);
    }

    private static void rollbackInternal(Connection connection, String poolName, boolean disableConfidentialLoggingService)
    {
        if (connection == null)
        {
            return;
        }

        ThreadInfo info = ThreadInfo.getThreadInfo();

        if (!info.hasOpenTransaction())
        {
            try
            {
                if (TracingService.isON())
                {
                    TracingService.getInstance().message("ROLLBACK");
                }

                connection.rollback();

                DBConnectionTracer.get(Integer.valueOf(connection.hashCode())).processEvent(
                        Integer.valueOf(Thread.currentThread().hashCode()), DBConnectionEvent.ROLLBACK);
                info.getDbBusinessObjects().transactionDidRollback(null);
            }
            catch (SQLException ex)
            {
                throw new DatabaseSQLException("db.databaseError", "Unexpected SQLException in " + CSUtils.getCurrentClassAndMethod(), ex);
            }
        }
        else
        {
            info.registerConnection(poolName, connection);
            info.getDbBusinessObjects().performTemporaryRollback();
        }
    }

    /**
     * This method rolls back a transaction formerly opened by the <tt>openTransaction</tt> method if there are no nested transactions. If
     * there are nested transactions this method reduces the nesting level by 1, otherwise a rollback is performed. When the rollback was
     * successfull the connection is removed from the openTransactionConnection list and returned to the connectionPool. Uses the default
     * pool name.
     *
     * @param connection
     *            java.sql.Connection
     */
    public static void rollbackTransaction()
    {
        rollbackTransaction(DEFAULT_POOL_NAME);
    }

    /**
     * This method rolls back a transaction formerly opened by the <tt>openTransaction</tt> method if there are no nested transactions. If
     * there are nested transactions this method reduces the nesting level by 1, otherwise a rollback is performed. When the rollback was
     * successfull the connection is removed from the openTransactionConnection list and returned to the connectionPool. Uses poolName to
     * determine, which database to use.
     *
     * @param poolName
     *            java.String the name of the Connection pool
     */
    public static void rollbackTransaction(String poolName)
    {
        ThreadInfo info = ThreadInfo.getThreadInfo();

        if (info.rollbackTransaction() < 1)
        {
            boolean rollbackCompleted = false;
            boolean freeCompleted = false;

            try
            {
                if (TracingService.isON())
                {
                    TracingService.getInstance().message("ROLLBACK TRANSACTION");
                }
                info.rollbackAllConnections();
                rollbackCompleted = true;
                info.freeAllConnections();
                freeCompleted = true;
                info.getDbBusinessObjects().transactionDidRollback(null);
            }
            catch (SQLException ex)
            {
                if (!freeCompleted)
                {
                    info.freeAllConnections(!rollbackCompleted);
                }
                throw new DatabaseSQLException("db.databaseError", "Unexpected SQLException in " + CSUtils.getCurrentClassAndMethod(), ex);
            }
            finally
            {
                ThreadInfo.resetThreadInfo();
            }
        }
        else
        {
            if (TracingService.isON())
            {
                TracingService.getInstance().message("DBUtils.rollbackTransaction",
                        "DECREASING TRANSACTION NESTING LEVEL TO " + info.getTransactionNestingLevel());
            }
        }
    }

    /**
     * This method returns the current transaction nesting level. If no transaction was started by this thread in the specified pool, then 0
     * is returned, otherwise the nesting level of the transactions is returned. If openTransaction() was called just one, then 1 is
     * returned. Every call to openTransaction() increases the nesting level, every call to commitTransaction() or rollbackTransaction()
     * reduces the level.
     */
    public static int getTransactionNestingLevel()
    {
        return ThreadInfo.getThreadInfo().getTransactionNestingLevel();
    }

    /**
     * This method returns the current transaction nesting level. If no transaction was started by this thread in the specified pool, then 0
     * is returned, otherwise the nesting level of the transactions is returned. If openTransaction() was called just one, then 1 is
     * returned. Every call to openTransaction() increases the nesting level, every call to commitTransaction() or rollbackTransaction()
     * reduces the level.
     *
     * @param poolName
     *            java.String the name of the Connection pool
     */
    public static int getTransactionNestingLevel(String poolName)
    {
        return getTransactionNestingLevel();
    }

    public static void setPrepStmtParam(PreparedStatement pstmt, int index, final String value) throws SQLException
    {
        if (value == null)
        {
            pstmt.setNull(index, Types.CHAR);
        }
        else
        {
            pstmt.setString(index, value);
        }
    }

    public static void setPrepStmtParam(PreparedStatement pstmt, int index, final Date value) throws SQLException
    {
        if (value == null)
        {
            pstmt.setNull(index, Types.DATE);
        }
        else
        {
            pstmt.setDate(index, new java.sql.Date(value.getTime()));
        }
    }

    public static void setPrepStmtParamTimestamp(PreparedStatement pstmt, int index, final Date value) throws SQLException
    {
        if (value == null)
        {
            pstmt.setNull(index, Types.TIMESTAMP);
        }
        else
        {
            pstmt.setTimestamp(index, new java.sql.Timestamp(value.getTime()));
        }
    }

    public static void setPrepStmtParam(PreparedStatement pstmt, int index, final BigDecimal value) throws SQLException
    {
        if (value == null)
        {
            pstmt.setNull(index, Types.DECIMAL);
        }
        else
        {
            pstmt.setBigDecimal(index, value);
        }
    }

    public static void setPrepStmtParam(PreparedStatement pstmt, int index, final Timestamp value) throws SQLException
    {
        if (value == null)
        {
            pstmt.setNull(index, Types.TIMESTAMP);
        }
        else
        {
            pstmt.setTimestamp(index, value);
        }
    }

    public static void setPrepStmtParam(PreparedStatement pstmt, int index, final Boolean value) throws SQLException
    {
        if (value == null)
        {
            pstmt.setNull(index, Types.CHAR);
        }
        else
        {
            pstmt.setString(index, CSStringUtils.stringFromBoolean(value.booleanValue()));
        }
    }

    public static void setPrepStmtParam(PreparedStatement pstmt, int index, final Integer value) throws SQLException
    {
        if (value == null)
        {
            pstmt.setNull(index, Types.INTEGER);
        }
        else
        {
            pstmt.setInt(index, value.intValue());
        }
    }

    /**
     * Assembles a String of multiple questionmarks, separated by commas, for inclusion in a SQL PreparedStatement
     *
     * @param <T>
     * @param objectsToInsert
     *            A collection containing the objects to insert. The number of questionmarks inserted will be equals to the collection's
     *            size
     * @param leadingComma
     *            Set this to true, if a comma shall be inserted in front of the first questionmark
     * @return A String containing objectsToInsert.size() questionmarks, separated by commas or an empty String, if the collection is empty
     */
    public static <T> String getSQLQuestionmarkString(Collection<T> objectsToInsert, boolean leadingComma)
    {
        StringBuilder sqlStringBuilder = new StringBuilder();

        if (objectsToInsert != null)
        {
            for (int i = 0; i < objectsToInsert.size(); i++)
            {
                sqlStringBuilder.append(",? ");
            }
        }

        if (leadingComma || sqlStringBuilder.length() == 0)
        {
            return sqlStringBuilder.toString();
        }
        else
        {
            return sqlStringBuilder.substring(1);
        }
    }

    /**
     * Assembles a String of multiple questionmarks, separated by commas, for inclusion in a SQL PreparedStatement
     *
     * @param <T>
     * @param objectsToInsert
     *            An array containing the objects to insert. The number of questionmarks inserted will be equals to the array's length
     * @param leadingComma
     *            Set this to true, if a comma shall be inserted in front of the first questionmark
     * @return A String containing objectsToInsert.length questionmarks, separated by commas or an empty String, if the array is null
     */
    public static <T> String getSQLQuestionmarkString(T[] objectsToInsert, boolean leadingComma)
    {
        Collection<T> objectsToInsertCollection = null;
        if (objectsToInsert != null)
        {
            objectsToInsertCollection = Arrays.asList(objectsToInsert);
        }
        return getSQLQuestionmarkString(objectsToInsertCollection, leadingComma);
    }

    /**
     * Sets multiple Strings in a PreparedStatement at once
     *
     * @param pstmt
     *            The PreparedStatement to be used
     * @param startIndex
     *            The first parameter's index in the PreparedStatement
     * @param values
     *            A collection of Objects to be inserted as SQL VARCHAR value into the PreparedStatement, provided the Method toString() is
     *            implemented.
     *
     * @return The next parameter's index, after all Strings have been inserted
     * @throws SQLException
     */
    public static <T> int setPrepStmtParams(PreparedStatement pstmt, int startIndex, Collection<T> values) throws SQLException
    {
        int paramIndex = startIndex;

        if (values != null)
        {
            for (T value : values)
            {
                pstmt.setString(paramIndex++, value.toString());
            }
        }

        return paramIndex;
    }

    /**
     * Sets multiple Strings in a PreparedStatement at once
     *
     * @param pstmt
     *            The PreparedStatement to be used
     * @param startIndex
     *            The first parameter's index in the PreparedStatement
     * @param values
     *            An array of Objects to be inserted as SQL VARCHAR value into the PreparedStatement, provided the Method toString() is
     *            implemented.
     * @return The next parameter's index, after all Strings have been inserted
     * @throws SQLException
     */
    public static <T> int setPrepStmtParams(PreparedStatement pstmt, int startIndex, T[] values) throws SQLException
    {
        Collection<T> valuesCollection = null;
        if (values != null)
        {
            valuesCollection = Arrays.asList(values);
        }

        return setPrepStmtParams(pstmt, startIndex, valuesCollection);
    }
}

