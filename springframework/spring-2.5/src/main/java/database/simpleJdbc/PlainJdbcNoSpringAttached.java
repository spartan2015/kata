package database.simpleJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PlainJdbcNoSpringAttached {

	public static void main(String[] args) {
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";
		String dbName = "jdbcDemoDB";
		String connectionURL = "jdbc:derby:" + dbName + ";create=true";

		try {
			Class.forName(driver);
			System.out.println(driver + " loaded. ");
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
			System.out
					.println("\n    >>> Please check your CLASSPATH variable   ");
		}

		Connection conn = null;
		Statement statement;
		PreparedStatement ps;
		ResultSet resultset;

		try {
			conn = DriverManager.getConnection(connectionURL);
			System.out.println("AutoCommit: " + conn.getAutoCommit());

			// CREATE TABLE
			// statement = conn.createStatement();
			// statement.execute("create table phones(name varchar(30),phone varchar(15))");

			// INSERT DATA
			// for(int i = 0; i < 10; i++){
			// statement = conn.createStatement();
			// statement.executeUpdate("insert into phones(name,phone) values('name "
			// + i + "','phone " + i + "')");
			// }

//			ps = conn.prepareStatement("insert into PHONES(name,phone) values(?,?)");
//			for (int i = 0; i < 10; i++) {
//				ps.setString(1, "name " + i);
//				ps.setString(2, "phone " + i);
//				ps.executeUpdate();
//			}
//			ps.close();

			statement = conn.createStatement(ResultSet.FETCH_FORWARD,
					ResultSet.CONCUR_READ_ONLY);

			// count table rows
			statement.executeQuery("select count(*) from phones");
			resultset = statement.getResultSet();
			System.out.println(resultset.next() + " Count is " + resultset.getString(1));

			// show table contents
			statement.executeQuery("select * from phones");
			resultset = statement.getResultSet();

			while (resultset.next()) {
				System.out.println(resultset.getString(1) + ": "
						+ resultset.getString(2));
			}

			conn.close();

			// shutdown derby
			if (driver.equals("org.apache.derby.jdbc.EmbeddedDriver")) {
				boolean gotSQLExc = false;
				try {
					DriverManager.getConnection("jdbc:derby:;shutdown=true");
				} catch (SQLException se) {
					if (se.getSQLState().equals("XJ015")) {
						gotSQLExc = true;
					}
				}
				if (!gotSQLExc) {
					System.out.println("Database did not shut down normally");
				} else {
					System.out.println("Database shut down normally");
				}
			}

		} catch (Throwable ex) {
			ex.printStackTrace();
		}

	}

}
