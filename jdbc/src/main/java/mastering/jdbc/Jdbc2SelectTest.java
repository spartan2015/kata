package mastering.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Jdbc2SelectTest {
	private final static Logger LOG = Logger.getLogger(Jdbc2SelectTest.class.getSimpleName());
	
	public static void main(String[] ar) {

		Connection connection = null;
		try {
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "1234");

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from books");
			
			
			List<Book> bookList = new ArrayList<>();
			while(resultSet.next()){
				
				Book book = new Book();				
				book.setId(resultSet.getLong(1));				
				
				String title = resultSet.getString(2);
				title = (String)resultSet.getObject(2); // you can use the generic getObject
				
				book.setTitle(title);
				book.setDate(resultSet.getDate("date").toLocalDate());
				book.setTime(resultSet.getTime("date").toLocalTime());
				book.setDateTime(resultSet.getTimestamp("date").toLocalDateTime());
								
				bookList.add(book);
			}
			
			System.out.println(bookList);

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
