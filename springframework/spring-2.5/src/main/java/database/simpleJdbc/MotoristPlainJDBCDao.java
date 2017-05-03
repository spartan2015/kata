package database.simpleJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.beans.Motorist;

public class MotoristPlainJDBCDao {
	private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String dbName = "jdbcDemoDB";
	private static final String connectionURL = "jdbc:derby:" + dbName
			+ ";create=true";
	static {
		try {
			Class.forName(driver);
			System.out.println(driver + " loaded. ");
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
			System.out
					.println("\n    >>> Please check your CLASSPATH variable   ");
		}
	}

	private static final String insertMotorist = "insert into motorist(id,email,password,firstName,lastName)"
			+ " values(null, ?,?,?,?)";

	public void saveMotorist(Motorist motorist) {
		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DriverManager.getConnection(connectionURL);
			st = conn.prepareStatement(insertMotorist);

			st.setString(2, motorist.getEmail());
			st.setString(3, motorist.getPassword());
			st.setString(4, motorist.getFirstName());
			st.setString(5, motorist.getLastName());

			st.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
				if (conn != null)
					conn.close();				
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	private static final String updateMotorist = "update motorist set email = ?," +
			" password = ?, firstName = ?, lastName = ? where id = ?";
	
	public void updateMotorist(Motorist motorist){
		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DriverManager.getConnection(connectionURL);
			st = conn.prepareStatement(updateMotorist);
			
			st.setString(1, motorist.getEmail());
			st.setString(2, motorist.getPassword());
			st.setString(3, motorist.getFirstName());
			st.setString(4, motorist.getLastName());
			
			st.setInt(5, motorist.getId());

			st.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
				if (conn != null)
					conn.close();				
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private static final String queryMotorist = "select email, password, firstName, lastName from Motorist where id=?";
	
	public Motorist getMotorist(int id){
		Connection conn = null;
		PreparedStatement st = null;
		Motorist motorist = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(connectionURL);
			st = conn.prepareStatement(queryMotorist);
						
			st.setInt(1, id);

			st.executeQuery();
			
			rs = st.getResultSet();
			
			if (rs.next()){
				motorist = new Motorist();
				motorist.setId(rs.getInt("id"));
				motorist.setEmail(rs.getString(1));
				motorist.setPassword(rs.getString(2));
				motorist.setFirstName(rs.getString(3));
				motorist.setLastName(rs.getString(4));
			}
							
				
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (conn != null)
					conn.close();
				
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return motorist;
	}
}
