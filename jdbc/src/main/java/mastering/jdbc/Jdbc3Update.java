package mastering.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Jdbc3Update {

	private final static Logger LOG = Logger.getLogger(Jdbc3Update.class.getSimpleName());

	public static void main(String[] ar) {

		Connection connection = null;
		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "1234");

			PreparedStatement statement = connection.prepareStatement("update book set title=? where id = ?");
			statement.setString(1, "Mastering JDBC 3rd Edition");
			statement.setLong(2, 1);

			statement.execute();

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

	public void resultSetUpdate() {

		Connection connection = null;
		try {
			String user = "root";
			String password = "1234";
			String url = "jdbc:mysql://localhost:3306/test";
			connection = DriverManager.getConnection(url, user, password);
			connection.setAutoCommit(false);

			Statement statement = connection.createStatement(ResultSet.CONCUR_UPDATABLE, ResultSet.CONCUR_UPDATABLE);

			ResultSet resultSet = statement.executeQuery("select * from books");

			while (resultSet.next()) {
				if (resultSet.getLong(1) == 1) {

					resultSet.updateString("title", "Mastering JDBC 3rd Edition");

					resultSet.updateRow();
				}
			}

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
