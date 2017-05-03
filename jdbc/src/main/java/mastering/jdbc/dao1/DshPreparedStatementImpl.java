package mastering.jdbc.dao1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Dynamic Proxy for DshPreparedStatement
 * 
 */
public class DshPreparedStatementImpl implements InvocationHandler
{
    private static final List<Class< ? >> STRING_TYPE_CLASSES           = Arrays.asList(new Class< ? >[] {String.class, Character.class,
            Timestamp.class, Date.class, Time.class                     });
    private static final String           PARAMETER_NULL_DISPLAY_STRING = "NULL";

    private PreparedStatement             preparedStatement;
    private String                        sqlStatement;
    private Map<Object, String>           parametersAsStrings           = new HashMap<Object, String>();

    private boolean                       bufferBatches                 = true;
    private StringBuffer                  batchBuffer;

    public static boolean isTimeprofilingSql()
    {
        return true;
    }

    public static DshPreparedStatement create(Connection connection, String sqlStatement) throws SQLException
    {
        return generateProxy(new DshPreparedStatementImpl(connection, sqlStatement));
    }

    public static DshPreparedStatement create(Connection connection, String sqlStatement, boolean traceBatches) throws SQLException
    {
        return generateProxy(new DshPreparedStatementImpl(connection, sqlStatement, traceBatches));
    }

    public static DshPreparedStatement create(Connection connection, String sqlStatement, int resultSetType) throws SQLException
    {
        return generateProxy(new DshPreparedStatementImpl(connection, sqlStatement, resultSetType));
    }

    public static DshPreparedStatement create(Connection connection, String sqlStatement, int resultSetType, int resultSetConcurrency)
            throws SQLException
    {
        return generateProxy(new DshPreparedStatementImpl(connection, sqlStatement, resultSetType, resultSetConcurrency));
    }

    private static DshPreparedStatement generateProxy(DshPreparedStatementImpl dshPreparedStatementImpl) throws SQLException
    {
        ClassLoader loader = dshPreparedStatementImpl.getClass().getClassLoader();
        return (DshPreparedStatement) Proxy.newProxyInstance(loader, new Class[] {DshPreparedStatement.class}, dshPreparedStatementImpl);
    }

    private DshPreparedStatementImpl(Connection connection, String sqlStatement) throws SQLException
    {
        this.sqlStatement = sqlStatement;
        preparedStatement = connection.prepareStatement(sqlStatement);
    }

    private DshPreparedStatementImpl(Connection connection, String sqlStatement, boolean bufferBatches) throws SQLException
    {
        this.sqlStatement = sqlStatement;
        this.preparedStatement = connection.prepareStatement(sqlStatement);
        this.bufferBatches = bufferBatches;
    }

    private DshPreparedStatementImpl(Connection connection, String sqlStatement, int resultSetType, int resultSetConcurrency)
            throws SQLException
    {
        this.sqlStatement = sqlStatement;
        this.preparedStatement = connection.prepareStatement(sqlStatement, resultSetType, resultSetConcurrency);
    }

    private DshPreparedStatementImpl(Connection connection, String sqlStatement, int resultSetType) throws SQLException
    {
        this.sqlStatement = sqlStatement;
        this.preparedStatement = connection.prepareStatement(sqlStatement, resultSetType);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        Object result = null;
        try
        {
            if ("toString".equals(method.getName()))
            {
                result = getBatchOrSqlStatementWithFilledParameters();
            }
            else
            {
                handleParameterMethods(method, args);
                handleBatchMethods(method, args);

                boolean timeprofilingEnabled = isTimeprofilingSql() && method.getName().startsWith("execute");
                long start = 0;
                if (timeprofilingEnabled)
                {
                	start = System.currentTimeMillis();
                }
                result = method.invoke(preparedStatement, args);
                if (timeprofilingEnabled)
                {
                    System.out.println(System.currentTimeMillis() - start + preparedStatement.toString());
                }
            }
        }
        catch (InvocationTargetException ex)
        {
            throw ex.getCause();
        }
        return result;
    }

    private void handleParameterMethods(Method method, Object[] args)
    {
        final Class< ? >[] parameterTypes = method.getParameterTypes();

        if ("clearParameters".equals(method.getName()))
        {
            parametersAsStrings.clear();
        }
        else if ("setNull".equals(method.getName()) && parameterTypes.length >= 1 && parameterTypes[0] == int.class)
        {
            parametersAsStrings.put(args[0], PARAMETER_NULL_DISPLAY_STRING);
        }
        else if ("setObject".equals(method.getName()) && parameterTypes.length >= 3 && parameterTypes[0] == int.class
                && parameterTypes[2] == int.class)
        {
            parametersAsStrings.put(args[0],
                    parameterValue2string(args[1], setObjectParameterTypes2class(parameterTypes[1], (Integer) args[2])));
        }
        else if (method.getName().startsWith("set") && parameterTypes.length >= 2 && parameterTypes[0] == int.class)
        {
            parametersAsStrings.put(args[0], parameterValue2string(args[1], parameterTypes[1]));
        }
    }

    private Class< ? > setObjectParameterTypes2class(Class< ? > parameterClass, Integer sqlType)
    {
        switch (sqlType)
        {
            case Types.CHAR :
            case Types.VARCHAR :
                return String.class;
            default :
                return parameterClass;
        }
    }

    private String parameterValue2string(Object parameterValue, Class< ? > clazz)
    {
        if (parameterValue == null)
        {
            return PARAMETER_NULL_DISPLAY_STRING;
        }

        if (STRING_TYPE_CLASSES.contains(clazz))
        {
            return "'" + parameterValue.toString() + "'";
        }
        return parameterValue.toString();
    }

    private void handleBatchMethods(Method method, Object[] args)
    {
        if ("clearBatch".equals(method.getName()))
        {
            batchBuffer = null;
        }
        else if ("addBatch".equals(method.getName()))
        {
            if (bufferBatches)
            {
                String currText = getSqlStatementWithFilledParameters();
                if (batchBuffer == null)
                {
                    batchBuffer = new StringBuffer(currText.length() + 10);
                }
                batchBuffer.append(currText);
                batchBuffer.append(" - ");
            }
        }
    }

    private String getBatchOrSqlStatementWithFilledParameters()
    {
        String result = null;

        if (batchBuffer != null)
        {
            result = batchBuffer.toString();
        }
        else
        {
            result = getSqlStatementWithFilledParameters();
            if (!bufferBatches)
            {
                result = "Batch SQL-Tracing disabled, only last SQL is displayed in Batch Mode: " + result;
            }
        }

        return result;
    }

    private String getSqlStatementWithFilledParameters()
    {
        if (sqlStatement == null)
        {
            return null;
        }

        StringBuffer result = new StringBuffer();
        int parameterIndex = 1;
        for (int i = 0; i < sqlStatement.length(); i++)
        {
            char charAtI = sqlStatement.charAt(i);
            if (charAtI == '?')
            {
                result.append(getParameterAsString(parameterIndex));
                parameterIndex++;
            }
            else
            {
                result.append(charAtI);
            }
        }
        return result.toString();
    }

    private String getParameterAsString(int parameterIndex)
    {
        String result = parametersAsStrings.get(parameterIndex);
        if (result == null)
        {
            result = "NOT_SET";
        }
        return result;
    }
}

