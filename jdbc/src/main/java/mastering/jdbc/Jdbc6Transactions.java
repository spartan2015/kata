package mastering.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Jdbc6Transactions {

	private final static Logger LOG = Logger.getLogger(Jdbc6Transactions.class.getSimpleName());

	public static void main(String[] ar) {

		Connection connection = null;
		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "1234");

			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			connection.setAutoCommit(false);
			/*
			 * <code>Connection.TRANSACTION_READ_UNCOMMITTED</code>,
			 * <code>Connection.TRANSACTION_READ_COMMITTED</code>,
			 * <code>Connection.TRANSACTION_REPEATABLE_READ</code>,
			 * <code>Connection.TRANSACTION_SERIALIZABLE</code>, or
			 * <code>Connection.TRANSACTION_NONE</code>.
			 */

			Statement statement = connection.createStatement();

			/* 1 */statement.executeQuery("select * from books where id = 1 for update");
			/* 2 */statement.executeUpdate("update books set title='Mastering JDBC 5rd Edition' where id = 1");

			connection.commit();

		} catch (SQLException ex) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e) {
					LOG.severe("failed to rollback the transaction: " + e);
				}
			}
			LOG.severe("SQLException" + ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					LOG.severe("failed to close connection: " + e);
				}
			}
		}
	}

}
