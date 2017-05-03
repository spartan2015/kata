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

public class Jdbc51TemplatePattern {

	private final static Logger LOG = Logger.getLogger(Jdbc51TemplatePattern.class.getSimpleName());

	public static void main(String[] args) {
		executeSelect(new UserStatement() {

			@Override
			public Object execute(Connection connection) throws SQLException {
				
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from books");

				List<Book> bookList = new ArrayList<>();
				while (resultSet.next()) {

					Book book = new Book();
					book.setId(resultSet.getLong(1));
					book.setTitle(resultSet.getString(2));

					bookList.add(book);
				}

				return bookList;

			}

		});
	}

	interface UserStatement {
		Object execute(Connection connection) throws SQLException;
	}

	public static Object executeSelect(UserStatement userStatement) {
		Connection connection = null;
		try {

			connection = DriverManager.getConnection("jdbc:mysql://loalhost/test", "root", "1234");
			connection.setAutoCommit(false);

			Object result = userStatement.execute(connection);

			connection.commit();

			return result;
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
		return null;
	}

}
