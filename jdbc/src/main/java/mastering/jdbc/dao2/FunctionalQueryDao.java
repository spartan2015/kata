package mastering.jdbc.dao2;

/*
public class FunctionalQueryDao {
	private static final Logger log = Logger.getLogger(FunctionalQueryDao.class.getName());
	
	
	*/
/**
 * @param tableName
 * @param columnsAndValues
 * @param statementTask
 * @param rowMapper
 * @param logStatement
 * @return
 * @param statementTask
 * @param resultSetExtractor
 * @param logStatement
 * @return
 * @param tableName
 * @param columnsAndValues
 * @param silent
 * @param tableName
 * @param updateColumnsAndValues
 * @param whereColumnsAndValues
 * @param tableName
 * @param updateColumnsAndValues
 * @param whereColumnsAndValues
 * @param silent
 * <p>
 * <p>
 * <p>
 * <p>
 * values passed here must be a constant defined in java.sql.Types
 * @param javaSqlType
 * @return
 * @param value
 * @param type
 * @return
 * @param values
 * @param pstmt
 * @param index
 * @return
 * @throws SQLException
 * <p>
 * <p>
 * <p>
 * The user is responsible for creating and executing the statement This method just provides the connection and the logging,
 * transaction and exception handling infrastructure
 * @param task
 * <p>
 * Use this to execute an insert/update statement The user is reponsible to create the prepared statement in the StatementTask The
 * statement will be executed here by calling executeUpdate() on it
 * <p>
 * The task verifies exactly 1 row was affected else throws exception
 * @param task
 * @param silent
 * <p>
 * executes an update/delete statement that can affect multiple rows or none
 * @param task
 * @param silent
 * @param task
 * @param silent
 * <p>
 * The task verifies exactly 1 row was affected else throws exception
 * @param task
 * @param checkSingleUpdate
 * @param silent
 * @param sqlUpdate
 * @param sqlUpdate
 * @param silent
 * <p>
 * task verifies that exactly one row was updated else throws exception
 * <p>
 * This method will execute the prepared statement created based on the sql parameter and possible configured with parameters through
 * the PreparedStatementTask No need to call executeUpdate on the PreparedStatment. This will happen here.
 * @param sqlUpdate
 * @param task
 * @param sqlUpdate
 * @param task
 * @param silent
 * <p>
 * This method will execute the prepared statement created based on the sql parameter and possible configured with parameters through
 * the PreparedStatementTask No need to call executeUpdate on the PreparedStatment. This will happen here.
 * <p>
 * executes an update/delete statement that can affect multiple rows or none
 * @param sqlUpdate
 * @param task
 * <p>
 * This method will execute the prepared statement created based on the sql parameter and possible configured with parameters through
 * the PreparedStatementTask No need to call executeUpdate on the PreparedStatment. This will happen here.
 * <p>
 * executes an update/delete statement that can affect multiple rows or none
 * @param sqlUpdate
 * @param params
 * @param sqlUpdate
 * @param task
 * @param silent
 * @param <R>
 * @param connection
 * @return
 * @throws SQLException
 * @param <R>
 * @param preparedStatement
 * @return
 * @throws SQLException
 * @param <R>
 * @param connectionJob
 * @return
 * @param preparedStatementJob
 * @param query
 * @return
 * @param preparedStatementJob
 * @param query
 * @param params
 * @return
 * @param preparedStatementJob
 * @param query
 * @param params
 * @return if checkOneRowAffected is true then the return type must be of Type long
 * since we'll try to return the generated key prefer using the safe
 * doInsertUpdateSingle in this case
 * @param preparedStatementJob
 * @param query
 * @param params
 * @param isSilent
 * @param checkOneRowAffected
 * @return Query
 * @param preparedStatementJob
 * - use to setup params manually - DO NOT EXECUTE
 * @param job
 * - if you do not plan to use a rowMapper will try to execute this
 * @param query
 * @param params
 * @param rowMapper
 * - if this is here the ResultSetJob param is ignored
 * @param isSilent
 * @param batchSize
 * - if you need to retrieve a large resultset in batches so you don't overflow the memory use this param with a value above
 * 0
 * @return Query database and retrieve result as a stream of elements
 * @param query
 * @param params
 * @param rowMapper
 * @return You can retrieve batched sized stream from the resultSet with better memory management
 * @param preparedStatementJob
 * @param query
 * @param params
 * @param rowMapper
 * @param isSilent
 * @param batchSize
 * @return For memory manageable resultSet you can use this method to get there
 * entire resultSet as a list
 * @param preparedStatementJob
 * @param query
 * @param params
 * @param rowMapper
 * @param isSilent
 * @return
 * @param query
 * @param params
 * @param rowMapper
 * @return
 * @see DBStatementUtil.stream
 * @see DBStatementUtil.query
 * @see query method in this class
 * @see list and query method description
 *//*

   public static void insert(final String tableName, final Map<String, Object> columnsAndValues)
   {
       insert(tableName, columnsAndValues, false);
   }

   */
/**
 *
 * @param statementTask
 * @param rowMapper
 * @param logStatement
 * @return
 *//*

   public static <T> List<T> query(StatementTask statementTask, RowMapper<T> rowMapper, boolean logStatement)
   {
       return query(statementTask, new ResultSetRowMapper<T>(rowMapper), logStatement);
   }

   */
/**
 *
 * @param statementTask
 * @param resultSetExtractor
 * @param logStatement
 * @return
 *//*

   public static <T> T query(StatementTask statementTask, ResultSetExtractor<T> resultSetExtractor, boolean logStatement)
   {
       if (statementTask == null)
       {
           ErrorHandlingService.getInstance().throwRuntime("fm.internalError", "The StatementTask cannot be null.");
           return null;
       }
       if (resultSetExtractor == null)
       {
           ErrorHandlingService.getInstance().throwRuntime("fm.internalError", "The ResultSetExtractor cannot be null.");
           return null;
       }
       Connection con = null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;
       T result = null;
       try
       {
           con = DBUtils.getConnection();
           pstmt = statementTask.doStatement(con);
           rs = pstmt.executeQuery();
           if (logStatement && TracingService.isON())
           {
               TracingService.getInstance().message(CSUtils.getCurrentClassAndMethod(), pstmt.toString());
           }
           result = resultSetExtractor.extractData(rs);
       }
       catch (SQLException ex)
       {
           throw new DatabaseSQLException(ERROR_KEY_FM_DB_ERROR, "Unexpected SQLException in " + CSUtils.getCurrentClassAndMethod(), ex);
       }
       finally
       {
           DBUtils.closeResultSet(rs);
           DBUtils.closeStatement(pstmt);
           DBUtils.freeConnection(con);
       }

       return result;
   }

   */
/**
 *
 * @param tableName
 * @param columnsAndValues
 * @param silent
 *//*

   public static void insert(final String tableName, final Map<String, Object> columnsAndValues, boolean silent)
   {
       executeInsertUpdate(new StatementTask() {

           @Override
           public PreparedStatement doStatement(Connection con) throws SQLException
           {
               PreparedStatement pstmt = null;

               StringBuilder buf = new StringBuilder();
               StringBuilder valuesBuf = new StringBuilder();
               buf.append("INSERT INTO ");
               buf.append(DBUtils.qualifiedTableName(tableName));
               buf.append(" ( ");
               LinkedList<Object> values = new LinkedList<Object>();
               for (Entry<String, Object> entry : columnsAndValues.entrySet())
               {

                   buf.append(entry.getKey() + ",");
                   valuesBuf.append("?,");
                   values.add(entry.getValue());
               }
               buf.deleteCharAt(buf.length() - 1);
               buf.append(") VALUES ( ");
               buf.append(valuesBuf.deleteCharAt(valuesBuf.length() - 1).toString());
               buf.append(")");
               pstmt = DshPreparedStatementImpl.create(con, buf.toString());
               setValues(values, pstmt, 1);

               return pstmt;
           }
       }, silent);
   }

   */
/**
 *
 * @param tableName
 * @param updateColumnsAndValues
 * @param whereColumnsAndValues
 *//*

   public static void update(final String tableName, final Map<String, Object> updateColumnsAndValues,
           final Map<String, Object> whereColumnsAndValues)
   {
       update(tableName, updateColumnsAndValues, whereColumnsAndValues, false);
   }

   */
/**
 *
 * @param tableName
 * @param updateColumnsAndValues
 * @param whereColumnsAndValues
 * @param silent
 *//*

   public static void update(final String tableName, final Map<String, Object> updateColumnsAndValues,
           final Map<String, Object> whereColumnsAndValues, final boolean silent)
   {
       executeInsertUpdate(new StatementTask() {

           @Override
           public PreparedStatement doStatement(Connection con) throws SQLException
           {
               PreparedStatement pstmt = null;

               StringBuilder buf = new StringBuilder();
               buf.append("update ");
               buf.append(DBUtils.qualifiedTableName(tableName));
               buf.append(" set ");
               LinkedList<Object> columnValues = new LinkedList<Object>();
               for (Entry<String, Object> entry : updateColumnsAndValues.entrySet())
               {
                   buf.append(entry.getKey() + " = ?,");
                   columnValues.add(entry.getValue());
               }
               buf.deleteCharAt(buf.length() - 1);

               buf.append(" WHERE ");

               LinkedList<Object> whereValues = new LinkedList<Object>();
               for (Entry<String, Object> entry : whereColumnsAndValues.entrySet())
               {
                   buf.append(entry.getKey() + " = ? and ");
                   whereValues.add(entry.getValue());
               }
               buf.delete(buf.length() - 5, buf.length());

               pstmt = DshPreparedStatementImpl.create(con, buf.toString());

               setValues(whereValues, pstmt, setValues(columnValues, pstmt, 1));

               if (!silent && TracingService.isON())
               {
                   TracingService.getInstance().message("DbStatementUtil.update", pstmt.toString());
               }
               return pstmt;
           }
       }, silent);
   }

   */
/**
 *
 *
 *//*

   public static class NullSqlType
   {
       private int javaSqlType;

       */
/**
 * values passed here must be a constant defined in java.sql.Types
 *
 * @param javaSqlType
 * @return
 *//*

       public static NullSqlType create(int javaSqlType)
       {
           NullSqlType sqlType = new NullSqlType();
           sqlType.javaSqlType = javaSqlType;
           return sqlType;
       }
   }

   */
/**
 *
 * @param value
 * @param type
 * @return
 *//*

   public static Object valueOrNullSqlType(Object value, int type)
   {
       if (value == null)
       {
           return NullSqlType.create(type);
       }
       else
       {
           return value;
       }
   }

   */
/**
 *
 * @param values
 * @param pstmt
 * @param index
 * @return
 * @throws SQLException
 *//*

   public static int setValues(List<Object> values, PreparedStatement pstmt, int index) throws SQLException
   {

       for (Object value : values)
       {
           if (value instanceof NullSqlType)
           {
               pstmt.setNull(index++, ((NullSqlType) value).javaSqlType);
           }
           else if (value instanceof Timestamp)
           {
               pstmt.setTimestamp(index++, (Timestamp) value);
           }
           else if (value instanceof BigDecimal)
           {
               pstmt.setBigDecimal(index++, (BigDecimal) value);
           }
           else if (value instanceof String)
           {
               pstmt.setString(index++, (String) value);
           }
           else if (value instanceof Date)
           {
               pstmt.setTimestamp(index++, new Timestamp(((Date) value).getTime()));
           }
           else if (value instanceof Long)
           {
               pstmt.setLong(index++, (Long) value);
           }
           else
           {
               throw new RuntimeException("PreparedStatement type not yet implemented: " + value.getClass());
           }
       }

       return index;

   }

   */
/**
 *
 *
 * The user is responsible for creating and executing the statement This method just provides the connection and the logging,
 * transaction and exception handling infrastructure
 *
 * @param task
 *//*

   public static void executeStatement(StatementTask task)
   {
       Connection con = null;
       PreparedStatement pstmt = null;
       try
       {
           con = DBUtils.getConnection();

           pstmt = task.doStatement(con);

           DBUtils.commit(con);
       }
       catch (SQLException ex)
       {
           DBUtils.rollback(con);
           throw new DatabaseSQLException(ERROR_KEY_FM_DB_ERROR, "Unexpected SQLException in " + CSUtils.getCurrentClassAndMethod(), ex);
       }
       catch (DatabaseUpdateException ex)
       {
           DBUtils.rollback(con);
           throw ex;
       }
       finally
       {
           DBUtils.closeStatement(pstmt);
           DBUtils.freeConnection(con);
       }
   }

   */
/**
 * Use this to execute an insert/update statement The user is reponsible to create the prepared statement in the StatementTask The
 * statement will be executed here by calling executeUpdate() on it
 *
 * The task verifies exactly 1 row was affected else throws exception
 *
 * @param task
 * @param silent
 *//*

   public static void executeInsertUpdate(final StatementTask task)
   {
       executeInsertUpdate(task, false);
   }

   public static void executeInsertUpdate(final StatementTask task, boolean silent)
   {
       executeUpdateInternal(task, true, silent);
   }

   */
/**
 * executes an update/delete statement that can affect multiple rows or none
 *
 * @param task
 * @param silent
 *//*

   public static void executeUpdate(final StatementTask task)
   {
       executeUpdate(task, false);
   }

   */
/**
 *
 * @param task
 * @param silent
 *//*

   public static void executeUpdate(final StatementTask task, boolean silent)
   {
       executeUpdateInternal(task, false, silent);
   }

   */
/**
 * The task verifies exactly 1 row was affected else throws exception
 *
 * @param task
 * @param checkSingleUpdate
 * @param silent
 *//*

   private static void executeUpdateInternal(final StatementTask task, final boolean checkSingleUpdate, final boolean silent)
   {
       executeStatement(new StatementTask() {

           @Override
           public PreparedStatement doStatement(Connection con) throws SQLException
           {
               PreparedStatement pstmt = task.doStatement(con);

               if (pstmt == null)
               {
                   throw new RuntimeException("StatementTask must return a PreparedStatement !");
               }
               if (!silent && TracingService.isON())
               {
                   TracingService.getInstance().message(CSUtils.getCurrentClassAndMethod(), pstmt.toString());
               }

               int noOfUpdated = pstmt.executeUpdate();

               if (checkSingleUpdate && noOfUpdated != 1)
               {

                   String description = CSStringUtils.formatMessage("Failed to insert/update", new String[] {});
                   throw new DatabaseUpdateException(ERROR_KEY_FM_DB_ERROR, description);
               }

               return pstmt;
           }
       });

   }

   */
/**
 *
 * @param sqlUpdate
 *//*

   public static void executeInsertUpdateStatement(final String sqlUpdate)
   {
       executeInsertUpdateStatement(sqlUpdate, false);
   }

   */
/**
 *
 * @param sqlUpdate
 * @param silent
 *//*

   public static void executeInsertUpdateStatement(final String sqlUpdate, boolean silent)
   {
       executeInsertUpdate(new StatementTask() {

           @Override
           public PreparedStatement doStatement(Connection con) throws SQLException
           {
               PreparedStatement pstmt = DshPreparedStatementImpl.create(con, sqlUpdate);
               return pstmt;
           }

       }, silent);
   }

   */
/**
 * task verifies that exactly one row was updated else throws exception
 *
 * This method will execute the prepared statement created based on the sql parameter and possible configured with parameters through
 * the PreparedStatementTask No need to call executeUpdate on the PreparedStatment. This will happen here.
 *
 * @param sqlUpdate
 * @param task
 *//*

   public static void executeInsertUpdatePreparedStatement(final String sqlUpdate, final PreparedStatementTask task)
   {
       executeInsertUpdatePreparedStatement(sqlUpdate, task, false);
   }

   */
/**
 *
 * @param sqlUpdate
 * @param task
 * @param silent
 *//*

   public static void executeInsertUpdatePreparedStatement(final String sqlUpdate, final PreparedStatementTask task, boolean silent)
   {
       executeInsertUpdate(new StatementTask() {
           @Override
           public PreparedStatement doStatement(Connection con) throws SQLException
           {
               PreparedStatement pstmt = DshPreparedStatementImpl.create(con, sqlUpdate);
               if (task != null)
               {
                   task.doStatement(pstmt);
               }
               return pstmt;
           }
       }, silent);
   }

   */
/**
 * This method will execute the prepared statement created based on the sql parameter and possible configured with parameters through
 * the PreparedStatementTask No need to call executeUpdate on the PreparedStatment. This will happen here.
 *
 * executes an update/delete statement that can affect multiple rows or none
 *
 * @param sqlUpdate
 * @param task
 *//*

   public static void executeUpdatePreparedStatement(final String sqlUpdate, final PreparedStatementTask task)
   {
       executeUpdatePreparedStatement(sqlUpdate, task, false);
   }

   */
/**
 * This method will execute the prepared statement created based on the sql parameter and possible configured with parameters through
 * the PreparedStatementTask No need to call executeUpdate on the PreparedStatment. This will happen here.
 *
 * executes an update/delete statement that can affect multiple rows or none
 *
 * @param sqlUpdate
 * @param params
 *//*

   public static void executeUpdatePreparedStatement(final String sqlUpdate, final Object... params)
   {
       executeUpdatePreparedStatement(sqlUpdate, new PreparedStatementTask() {

           @Override
           public void doStatement(PreparedStatement preparedStatement) throws SQLException
           {
               int i = 1;
               for (Object obj : params)
               {
                   preparedStatement.setObject(i++, obj);
               }
           }

       }, false);
   }

   */
/**
 *
 * @param sqlUpdate
 * @param task
 * @param silent
 *//*

   public static void executeUpdatePreparedStatement(final String sqlUpdate, final PreparedStatementTask task, boolean silent)
   {
       executeUpdate(new StatementTask() {
           @Override
           public PreparedStatement doStatement(Connection con) throws SQLException
           {
               PreparedStatement pstmt = DshPreparedStatementImpl.create(con, sqlUpdate);
               if (task != null)
               {
                   task.doStatement(pstmt);
               }
               return pstmt;
           }
       }, silent);
   }
	*/
/**
 *
 *
 * @param <R>
 *//*

	public interface ConnectionJob<R> {
		*/
/**
 *
 * @param connection
 * @return
 * @throws SQLException
 *//*

		R onConnection(Connection connection) throws SQLException;
	}

	*/
/**
 *
 *
 * @param <R>
 *//*

	public interface PreparedStatementJob<R> {
		*/
/**
 *
 * @param preparedStatement
 * @return
 * @throws SQLException
 *//*

		R onPreparedStatement(PreparedStatement preparedStatement) throws SQLException;
	}

	*/
/**
 *
 *
 *
 * @param <R>
 *//*

	public interface ResultSetJob<R> {
		R onResultSet(ResultSet resultSet);
	}

	*/
/**
 *
 * @param connectionJob
 * @return
 *//*

	public static <R> R doWithConnection(ConnectionJob<R> connectionJob) {
		Connection con = null;
		R result = null;
		try {
			con = DBUtils.getConnection();

			result = connectionJob.onConnection(con);

			DBUtils.commit(con);
		} catch (SQLException ex) {
			DBUtils.rollback(con);
			throw new DatabaseSQLException(ERROR_KEY_FM_DB_ERROR,
					"Unexpected SQLException in " + CSUtils.getCurrentClassAndMethod(), ex);
		} catch (DatabaseUpdateException ex) {
			DBUtils.rollback(con);
			throw ex;
		} finally {
			DBUtils.freeConnection(con);
		}
		return result;
	}

	*/
/**
 *
 * @param preparedStatementJob
 * @param query
 * @return
 *//*

	public static <R> R doWithPreparedStatement(PreparedStatementJob<R> preparedStatementJob, String query) {
		return doWithPreparedStatement(preparedStatementJob, query, null, false, false);
	}

	*/
/**
 *
 * @param preparedStatementJob
 * @param query
 * @param params
 * @return
 *//*

	public static <R> R doWithPreparedStatement(PreparedStatementJob<R> preparedStatementJob, String query,
			List<Object> params) {
		return doWithPreparedStatement(preparedStatementJob, query, params, false, false);
	}

	*/
/**
 *
 * @param preparedStatementJob
 * @param query
 * @param params
 * @return
 *//*

	public static Long doInsertUpdateSingleRow(final PreparedStatementJob<Long> preparedStatementJob,
			final String query, final List<Object> params) {
		return doWithPreparedStatement(preparedStatementJob, query, params, false, true);
	}

	*/
/**
 * if checkOneRowAffected is true then the return type must be of Type long
 * since we'll try to return the generated key prefer using the safe
 * doInsertUpdateSingle in this case
 *
 * @param preparedStatementJob
 * @param query
 * @param params
 * @param isSilent
 * @param checkOneRowAffected
 * @return
 *//*

	public static <R> R doWithPreparedStatement(final PreparedStatementJob<R> preparedStatementJob, final String query,
			final List<Object> params, final boolean isSilent, final boolean checkOneRowAffected) {
		return doWithConnection(new ConnectionJob<R>() {
			@SuppressWarnings("unchecked")
			public R onConnection(Connection connection) throws SQLException {
				PreparedStatement preparedStatement = DshPreparedStatementImpl.create(connection, query,
						Statement.RETURN_GENERATED_KEYS);
				try {
					setupParameters(preparedStatement, params);
					DaoUtils.logPreparedStatement(isSilent, preparedStatement);
					R result = preparedStatementJob.onPreparedStatement(preparedStatement);
					int noOfUpdated = preparedStatement.getUpdateCount();
					if (checkOneRowAffected && noOfUpdated != 1) {
						String description = CSStringUtils.formatMessage("Failed to insert/update", new String[] {});
						throw new DatabaseUpdateException(ERROR_KEY_FM_DB_ERROR, description);
					} else {
						// fetch the generated key
						ResultSet rs = preparedStatement.getGeneratedKeys();
						if (rs.next()) {
							return (R) Long.valueOf(rs.getLong(0));
						}
					}
					return result;
				} finally {
					preparedStatement.close();
				}
			}

		});
	}

	*/
/**
 * Query
 *
 * @param preparedStatementJob
 *            - use to setup params manually - DO NOT EXECUTE
 * @param job
 *            - if you do not plan to use a rowMapper will try to execute this
 * @param query
 * @param params
 * @param rowMapper
 *            - if this is here the ResultSetJob param is ignored
 * @param isSilent
 * @param batchSize
 *            - if you need to retrieve a large resultset in batches so you don't overflow the memory use this param with a value above
 *            0
 * @return
 *//*

    public static <R> R query(final PreparedStatementJob<Object> preparedStatementJob, final ResultSetJob<R> job, final String query,
            final List<Object> params, final boolean isSilent, int batchSize)
    {
        return doWithPreparedStatement(new PreparedStatementJob<R>() {
            @Override
            public R onPreparedStatement(PreparedStatement preparedStatement) throws SQLException
            {
                ResultSet rs = null;
                R onResultSetResult = null;
                try
                {
                    if (preparedStatementJob != null)
                    {
                        preparedStatementJob.onPreparedStatement(preparedStatement);
                    }

                    if (batchSize > 0)
                    {
                        preparedStatement.setFetchSize(batchSize);
                    }
                    rs = preparedStatement.executeQuery();

                    onResultSetResult = job.onResultSet(rs);
                    return onResultSetResult;

                }
                finally
                {
                    if (rs != null && !(onResultSetResult instanceof Spliterator))
                    {
                        rs.close();
                    }
                }
            }
        }, query, params, isSilent, false);
    }

    */
/**
 * Query database and retrieve result as a stream of elements
 *
 * @see DBStatementUtil.stream
 * @see DBStatementUtil.query
 *
 * @param query
 * @param params
 * @param rowMapper
 * @return
 *//*

    public static <T> Stream<T> stream(final String query, final List<Object> params, final RowMapper<T> rowMapper)
    {
        return stream(null, query, params, rowMapper, false, -1);
    }

    */
/**
 * You can retrieve batched sized stream from the resultSet with better memory management
 *
 * @param preparedStatementJob
 * @param query
 * @param params
 * @param rowMapper
 * @param isSilent
 * @param batchSize
 * @return
 *//*

    public static <T> Stream<T> stream(final PreparedStatementJob<Object> preparedStatementJob, final String query,
            final List<Object> params, final RowMapper<T> rowMapper, final boolean isSilent, int batchSize)
    {
        return query(preparedStatementJob, new ResultSetJob<Stream<T>>() {

            @Override
            public Stream<T> onResultSet(final ResultSet resultSet)
            {
                return StreamSupport.stream(Spliterators.spliteratorUnknownSize(new Iterator<T>() {

                    private Connection connection  = DBUtils.getConnection(); // keeps connection alive
                    @Override
                    public boolean hasNext()
                    {

                        boolean hasNext = rethrowAsRuntime(() -> resultSet.next());
                        if (!hasNext)
                        {
                            rethrowAsRuntime(() -> {
                                DBUtils.closeResultSet(resultSet);
                                DBUtils.commit(connection);
                                return true;
                            });
                        }
                        return hasNext;
                    }

                    @Override
                    public T next()
                    {
                        return rethrowAsRuntime(() -> rowMapper.mapRow(resultSet));
                    }
                }, 0), false);
            }
        }, query, params, isSilent, batchSize);
    }
    
	*/
/**
 * For memory manageable resultSet you can use this method to get there
 * entire resultSet as a list
 *
 * @see query method in this class
 * @param preparedStatementJob
 * @param query
 * @param params
 * @param rowMapper
 * @param isSilent
 * @return
 *//*

	public static <T> List<T> list(final PreparedStatementJob<Object> preparedStatementJob, final String query,
			final List<Object> params, final RowMapper<T> rowMapper, final boolean isSilent) {
		return query(preparedStatementJob, new ResultSetJob<List<T>>() {

			@Override
			public List<T> onResultSet(final ResultSet resultSet) {
				List<T> list = new ArrayList<T>();
				while (rethrowAsRuntime(() -> resultSet.next())) {
					list.add(rethrowAsRuntime(() -> rowMapper.mapRow(resultSet)));
				}
				return list;
			}
		}, query, params, isSilent, -1);
	}

	*/
/**
 * @see list and query method description
 *
 * @param query
 * @param params
 * @param rowMapper
 * @return
 *//*

	public static <T> List<T> list(final String query, final List<Object> params, final RowMapper<T> rowMapper) {
		return list(null, query, params, rowMapper, false);
	}
	

	
	
	

    public static String addOptionalAlias(String columnName, String alias)
    {
        return alias == null ? columnName : columnName + " " + alias + "_" + columnName;
    }
}
*/
