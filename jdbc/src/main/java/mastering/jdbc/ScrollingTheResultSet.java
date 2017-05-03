package mastering.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ScrollingTheResultSet {
	private final static Logger LOG = Logger.getLogger(Jdbc2SelectTest.class.getSimpleName());

	public static void main(String[] ar) {

		Connection connection = null;
		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "1234");

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from books");

			boolean succeeded = false;
			succeeded = resultSet.next();
			succeeded = resultSet.previous();
			
			resultSet.beforeFirst();
			succeeded = resultSet.first();			
			succeeded = resultSet.last();
			resultSet.afterLast();
			succeeded = resultSet.absolute(1); // go to row 1
			succeeded = resultSet.absolute(-1); // go to last row
			
			succeeded = resultSet.relative(1); // go to next row
			succeeded = resultSet.relative(-1); // go to previous row
			

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
