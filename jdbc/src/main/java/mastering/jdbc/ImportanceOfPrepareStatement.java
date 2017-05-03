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

public class ImportanceOfPrepareStatement {

	private final static Logger LOG = Logger.getLogger(ImportanceOfPrepareStatement.class.getSimpleName());

	public static void main(String[] args) {

		Connection connection = null;
		try {
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "1234");
			Statement stmt = connection.createStatement();
			
			String userInput = "any' or 1=1";// SQL INJECTION ATTACK
			ResultSet rs = stmt.executeQuery("delete from books where title = '" + userInput +"'");
				
		} catch (SQLException ex) {			
			LOG.severe("SQLException" + ex);
		}
	}

}
