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

import javax.activation.DataSource;

public class UsingStatement {

	private final static Logger LOG = Logger.getLogger(UsingStatement.class.getSimpleName());

	public static void main(String[] args) {

		Connection connection = null;
		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "1234");

			Statement stmt = connection.createStatement();
			int noOfRowsAffected = stmt
					.executeUpdate("insert into books values(1, 'Oracle Java 7 Certified Professional')");
			System.out.println(noOfRowsAffected); // l

			ResultSet rs = stmt.executeQuery("select * from books");

			boolean isResultSet = stmt.execute("select * from books");
			if (isResultSet) {
				ResultSet rs1 = stmt.getResultSet();
			} else {
				int updateCount = stmt.getUpdateCount();
			}

			noOfRowsAffected = stmt.executeUpdate(
					"update books set name = 'Oracle Java 8 Certified Professional' where name = 'None'");
			System.out.println(noOfRowsAffected); // 0

			noOfRowsAffected = stmt.executeUpdate("delete from books where id = l");
			System.out.println(noOfRowsAffected); // l

		} catch (SQLException ex) {
			LOG.severe("SQLException" + ex);
		}
	}

}
