package mastering.jdbc.dao1;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Spliterators;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.swing.tree.RowMapper;

public class SimpleQueryDao {
	private static final Logger log = Logger.getLogger(SimpleQueryDao.class.getName());

	/**
	 *
	 * @param tableName
	 * @param columnsAndValues
	 */
	public static void insert(final String tableName, final Map<String, Object> columnsAndValues) {
		insert(tableName, columnsAndValues, false);
	}

	/**
	 *
	 * @param statementTask
	 * @param rowMapper
	 * @param logStatement
	 * @return
	 */
	public static <T> List<T> query(StatementTask statementTask, RowMapper<T> rowMapper, boolean logStatement) {
		return query(statementTask, new ResultSetRowMapper<T>(rowMapper), logStatement);
	}

	/**
	 *
	 * @param statementTask
	 * @param resultSetExtractor
	 * @param logStatement
	 * @return
	 */
	public static <T> T query(StatementTask statementTask, ResultSetExtractor<T> resultSetExtractor,
			boolean logStatement) {
		if (statementTask == null) {
			ErrorHandlingService.getInstance().throwRuntime("fm.internalError", "The StatementTask cannot be null.");
			return null;
		}
		if (resultSetExtractor == null) {
			ErrorHandlingService.getInstance().throwRuntime("fm.internalError",
					"The ResultSetExtractor cannot be null.");
			return null;
		}
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		T result = null;
		try {
			con = DBUtils.getConnection();
			pstmt = statementTask.doStatement(con);
			rs = pstmt.executeQuery();
			if (logStatement && TracingService.isON()) {
				TracingService.getInstance().message(CSUtils.getCurrentClassAndMethod(), pstmt.toString());
			}
			result = resultSetExtractor.extractData(rs);
		} catch (SQLException ex) {
			throw new DatabaseSQLException(ERROR_KEY_FM_DB_ERROR,
					"Unexpected SQLException in " + CSUtils.getCurrentClassAndMethod(), ex);
		} finally {
			DBUtils.closeResultSet(rs);
			DBUtils.closeStatement(pstmt);
			DBUtils.freeConnection(con);
		}

		return result;
	}

	/**
	 *
	 * @param tableName
	 * @param columnsAndValues
	 * @param silent
	 */
	public static void insert(final String tableName, final Map<String, Object> columnsAndValues, boolean silent) {
		executeInsertUpdate(new StatementTask() {

			@Override
			public PreparedStatement doStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = null;

				StringBuilder buf = new StringBuilder();
				StringBuilder valuesBuf = new StringBuilder();
				buf.append("INSERT INTO ");
				buf.append(DBUtils.qualifiedTableName(tableName));
				buf.append(" ( ");
				LinkedList<Object> values = new LinkedList<Object>();
				for (Entry<String, Object> entry : columnsAndValues.entrySet()) {

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

	/**
	 *
	 * @param tableName
	 * @param updateColumnsAndValues
	 * @param whereColumnsAndValues
	 */
	public static void update(final String tableName, final Map<String, Object> updateColumnsAndValues,
			final Map<String, Object> whereColumnsAndValues) {
		update(tableName, updateColumnsAndValues, whereColumnsAndValues, false);
	}

	/**
	 *
	 * @param tableName
	 * @param updateColumnsAndValues
	 * @param whereColumnsAndValues
	 * @param silent
	 */
	public static void update(final String tableName, final Map<String, Object> updateColumnsAndValues,
			final Map<String, Object> whereColumnsAndValues, final boolean silent) {
		executeInsertUpdate(new StatementTask() {

			@Override
			public PreparedStatement doStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = null;

				StringBuilder buf = new StringBuilder();
				buf.append("update ");
				buf.append(DBUtils.qualifiedTableName(tableName));
				buf.append(" set ");
				LinkedList<Object> columnValues = new LinkedList<Object>();
				for (Entry<String, Object> entry : updateColumnsAndValues.entrySet()) {
					buf.append(entry.getKey() + " = ?,");
					columnValues.add(entry.getValue());
				}
				buf.deleteCharAt(buf.length() - 1);

				buf.append(" WHERE ");

				LinkedList<Object> whereValues = new LinkedList<Object>();
				for (Entry<String, Object> entry : whereColumnsAndValues.entrySet()) {
					buf.append(entry.getKey() + " = ? and ");
					whereValues.add(entry.getValue());
				}
				buf.delete(buf.length() - 5, buf.length());

				pstmt = DshPreparedStatementImpl.create(con, buf.toString());

				setValues(whereValues, pstmt, setValues(columnValues, pstmt, 1));

				if (!silent && TracingService.isON()) {
					TracingService.getInstance().message("DbStatementUtil.update", pstmt.toString());
				}
				return pstmt;
			}
		}, silent);
	}

	/**
	*
	*
	*/
	public static class NullSqlType {
		private int javaSqlType;

		/**
		 * values passed here must be a constant defined in java.sql.Types
		 *
		 * @param javaSqlType
		 * @return
		 */
		public static NullSqlType create(int javaSqlType) {
			NullSqlType sqlType = new NullSqlType();
			sqlType.javaSqlType = javaSqlType;
			return sqlType;
		}
	}

	/**
	 *
	 * @param value
	 * @param type
	 * @return
	 */
	public static Object valueOrNullSqlType(Object value, int type) {
		if (value == null) {
			return NullSqlType.create(type);
		} else {
			return value;
		}
	}

	/**
	 *
	 * @param values
	 * @param pstmt
	 * @param index
	 * @return
	 * @throws SQLException
	 */
	public static int setValues(List<Object> values, PreparedStatement pstmt, int index) throws SQLException {

		for (Object value : values) {
			if (value instanceof NullSqlType) {
				pstmt.setNull(index++, ((NullSqlType) value).javaSqlType);
			} else if (value instanceof Timestamp) {
				pstmt.setTimestamp(index++, (Timestamp) value);
			} else if (value instanceof BigDecimal) {
				pstmt.setBigDecimal(index++, (BigDecimal) value);
			} else if (value instanceof String) {
				pstmt.setString(index++, (String) value);
			} else if (value instanceof Date) {
				pstmt.setTimestamp(index++, new Timestamp(((Date) value).getTime()));
			} else if (value instanceof Long) {
				pstmt.setLong(index++, (Long) value);
			} else {
				throw new RuntimeException("PreparedStatement type not yet implemented: " + value.getClass());
			}
		}

		return index;

	}

	/**
	 *
	 *
	 * The user is responsible for creating and executing the statement This
	 * method just provides the connection and the logging, transaction and
	 * exception handling infrastructure
	 *
	 * @param task
	 */
	public static void executeStatement(StatementTask task) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtils.getConnection();

			pstmt = task.doStatement(con);

			DBUtils.commit(con);
		} catch (SQLException ex) {
			DBUtils.rollback(con);
			throw new DatabaseSQLException(ERROR_KEY_FM_DB_ERROR,
					"Unexpected SQLException in " + CSUtils.getCurrentClassAndMethod(), ex);
		} catch (DatabaseUpdateException ex) {
			DBUtils.rollback(con);
			throw ex;
		} finally {
			DBUtils.closeStatement(pstmt);
			DBUtils.freeConnection(con);
		}
	}

	/**
	 * Use this to execute an insert/update statement The user is reponsible to
	 * create the prepared statement in the StatementTask The statement will be
	 * executed here by calling executeUpdate() on it
	 *
	 * The task verifies exactly 1 row was affected else throws exception
	 *
	 * @param task
	 * @param silent
	 */
	public static void executeInsertUpdate(final StatementTask task) {
		executeInsertUpdate(task, false);
	}

	public static void executeInsertUpdate(final StatementTask task, boolean silent) {
		executeUpdateInternal(task, true, silent);
	}

	/**
	 * executes an update/delete statement that can affect multiple rows or none
	 *
	 * @param task
	 * @param silent
	 */
	public static void executeUpdate(final StatementTask task) {
		executeUpdate(task, false);
	}

	/**
	 *
	 * @param task
	 * @param silent
	 */
	public static void executeUpdate(final StatementTask task, boolean silent) {
		executeUpdateInternal(task, false, silent);
	}

	/**
	 * The task verifies exactly 1 row was affected else throws exception
	 *
	 * @param task
	 * @param checkSingleUpdate
	 * @param silent
	 */
	private static void executeUpdateInternal(final StatementTask task, final boolean checkSingleUpdate,
			final boolean silent) {
		executeStatement(new StatementTask() {

			@Override
			public PreparedStatement doStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = task.doStatement(con);

				if (pstmt == null) {
					throw new RuntimeException("StatementTask must return a PreparedStatement !");
				}
				if (!silent && TracingService.isON()) {
					TracingService.getInstance().message(CSUtils.getCurrentClassAndMethod(), pstmt.toString());
				}

				int noOfUpdated = pstmt.executeUpdate();

				if (checkSingleUpdate && noOfUpdated != 1) {

					String description = "Failed to insert/update";
					throw new RuntimeException(description);
				}

				return pstmt;
			}
		});

	}

	/**
	 *
	 * @param sqlUpdate
	 */
	public static void executeInsertUpdateStatement(final String sqlUpdate) {
		executeInsertUpdateStatement(sqlUpdate, false);
	}

	/**
	 *
	 * @param sqlUpdate
	 * @param silent
	 */
	public static void executeInsertUpdateStatement(final String sqlUpdate, boolean silent) {
		executeInsertUpdate(new StatementTask() {

			@Override
			public PreparedStatement doStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = DshPreparedStatementImpl.create(con, sqlUpdate);
				return pstmt;
			}

		}, silent);
	}

	/**
	 * task verifies that exactly one row was updated else throws exception
	 *
	 * This method will execute the prepared statement created based on the sql
	 * parameter and possible configured with parameters through the
	 * PreparedStatementTask No need to call executeUpdate on the
	 * PreparedStatment. This will happen here.
	 *
	 * @param sqlUpdate
	 * @param task
	 */
	public static void executeInsertUpdatePreparedStatement(final String sqlUpdate, final PreparedStatementTask task) {
		executeInsertUpdatePreparedStatement(sqlUpdate, task, false);
	}

	/**
	 *
	 * @param sqlUpdate
	 * @param task
	 * @param silent
	 */
	public static void executeInsertUpdatePreparedStatement(final String sqlUpdate, final PreparedStatementTask task,
			boolean silent) {
		executeInsertUpdate(new StatementTask() {
			@Override
			public PreparedStatement doStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = DshPreparedStatementImpl.create(con, sqlUpdate);
				if (task != null) {
					task.doStatement(pstmt);
				}
				return pstmt;
			}
		}, silent);
	}

	/**
	 * This method will execute the prepared statement created based on the sql
	 * parameter and possible configured with parameters through the
	 * PreparedStatementTask No need to call executeUpdate on the
	 * PreparedStatment. This will happen here.
	 *
	 * executes an update/delete statement that can affect multiple rows or none
	 *
	 * @param sqlUpdate
	 * @param task
	 */
	public static void executeUpdatePreparedStatement(final String sqlUpdate, final PreparedStatementTask task) {
		executeUpdatePreparedStatement(sqlUpdate, task, false);
	}

	/**
	 * This method will execute the prepared statement created based on the sql
	 * parameter and possible configured with parameters through the
	 * PreparedStatementTask No need to call executeUpdate on the
	 * PreparedStatment. This will happen here.
	 *
	 * executes an update/delete statement that can affect multiple rows or none
	 *
	 * @param sqlUpdate
	 * @param params
	 */
	public static void executeUpdatePreparedStatement(final String sqlUpdate, final Object... params) {
		executeUpdatePreparedStatement(sqlUpdate, new PreparedStatementTask() {

			@Override
			public void doStatement(PreparedStatement preparedStatement) throws SQLException {
				int i = 1;
				for (Object obj : params) {
					preparedStatement.setObject(i++, obj);
				}
			}

		}, false);
	}

	/**
	 *
	 * @param sqlUpdate
	 * @param task
	 * @param silent
	 */
	public static void executeUpdatePreparedStatement(final String sqlUpdate, final PreparedStatementTask task,
			boolean silent) {
		executeUpdate(new StatementTask() {
			@Override
			public PreparedStatement doStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = DshPreparedStatementImpl.create(con, sqlUpdate);
				if (task != null) {
					task.doStatement(pstmt);
				}
				return pstmt;
			}
		}, silent);
	}
}
