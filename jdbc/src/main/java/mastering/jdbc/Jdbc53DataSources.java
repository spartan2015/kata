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

public class Jdbc53DataSources {

	private final static Logger LOG = Logger.getLogger(Jdbc53DataSources.class.getSimpleName());

	public static void main(String[] args) {

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "1234");
				PreparedStatement statement = connection.prepareStatement("select * from books");
				ResultSet resultSet = statement.executeQuery()) {

			List<Book> bookList = new ArrayList<>();
			while (resultSet.next()) {

				Book book = new Book();
				book.setId(resultSet.getLong(1));
				book.setTitle(resultSet.getString(2));

				bookList.add(book);
			}

			System.out.println(bookList);

		} catch (SQLException ex) {			
			LOG.severe("SQLException" + ex);
		}
	}

}
