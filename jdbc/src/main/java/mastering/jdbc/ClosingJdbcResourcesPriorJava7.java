package mastering.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ClosingJdbcResourcesPriorJava7 {
	private final static Logger LOG = Logger.getLogger(ClosingJdbcResourcesPriorJava7.class.getSimpleName());

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "1234");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from books");

			List<Book> bookList = new ArrayList<>();
			while (resultSet.next()) {

			}
		} catch (SQLException sqlException) {
			
			sqlException.getMessage(); // ERROR: column "" does not exist Position: 8
			sqlException.getSQLState(); // 42703
			sqlException.getErrorCode(); // 0
			
			LOG.severe("SQLException" + sqlException);
		} finally {
			closeResultSet(resultSet);
			closeStatement(statement);
			closeConnection(connection);
		}
	}

	private static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				LOG.severe("SQLException" + e);
			}
		}

	}

	private static void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				LOG.severe("SQLException" + e);
			}
		}

	}

	private static void closeResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				LOG.severe("SQLException" + e);
			}
		}

	}

}
