package mastering.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class Jdbc1Insert {

	private final static Logger LOG = Logger.getLogger(Jdbc1Insert.class.getSimpleName());
	
	public static void main(String[] args){
		Connection connection = null;
	   	 try {
	   		
	   		 // the driver needs to be on the classpath
	   		 // pre Driver 3.0 you had to load the jdbc Driver with Class.forName();
	   		 //Class.forName("com.mysql.jdbc.Driver");
	   		 		
	   		 connection = DriverManager.getConnection("jdbc:mysql://loalhost/test", "root", "1234");
	   		 connection.setAutoCommit(false);

	   		 PreparedStatement statement = connection
	   				 .prepareStatement("INSERT INTO books(id, title) values(?, ?)");

	   		 statement.setLong(1, Long.valueOf(1));
	   		 statement.setString(2, "Mastering JDBC");
	   		 
	   		 statement.setDate(4, new java.sql.Date(1990, 2, 2));

	   		 statement.executeUpdate();

	   		 connection.commit();
	   	 }catch(SQLException ex){
	   		 if (connection != null){	   			 
	   			 try{
	   				 connection.rollback();
	   			 }catch(SQLException e){
	   				LOG.severe("failed to rollback the transaction: " + e);					
	   			 }
	   		 }
	   		 LOG.severe("SQLException" + ex);
	   	 }finally{
	   		 if (connection != null){
	   			 try {
					connection.close();
				} catch (SQLException e) {
					LOG.severe("failed to close connection: " + e);
				}
	   		 }
	   	 }
	}
	
	public void resultSetInsert() {

		Connection connection = null;
		try {
			String user = "root";
			String password = "1234";
			String url = "jdbc:mysql://localhost:3306/test";
			connection = DriverManager.getConnection(url, user, password);
			connection.setAutoCommit(false);

			Statement statement = connection.createStatement(ResultSet.CONCUR_UPDATABLE, ResultSet.CONCUR_UPDATABLE);

			ResultSet resultSet = statement.executeQuery("select * from books");

			
			resultSet.moveToInsertRow();

			resultSet.updateString("title", "Mastering JDBC 3rd Edition");
			
			resultSet.insertRow();

			connection.commit();

		}catch(SQLException ex){
	   		 if (connection != null){	   			 
	   			 try{
	   				 connection.rollback();
	   			 }catch(SQLException e){
	   				LOG.severe("failed to rollback the transaction: " + e);					
	   			 }
	   		 }
	   		 LOG.severe("SQLException" + ex);
	   	 }finally{
	   		 if (connection != null){
	   			 try {
					connection.close();
				} catch (SQLException e) {
					LOG.severe("failed to close connection: " + e);
				}
	   		 }
	   	 }
	}
}
