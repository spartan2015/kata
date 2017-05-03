package jndi;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConventionalJNDI {

	public static void main(String[] args) {
		
		
		InitialContext ctx = null;
		try {
		  ctx = new InitialContext();
		  DataSource ds =
		      (DataSource)ctx.lookup("java:comp/env/jdbc/RantzDatasource");
		} catch (NamingException ne) {
		  ne.printStackTrace();
		} finally {
		  if(ctx != null) {
		    try {
		      ctx.close();
		    } catch (NamingException ne) {}
		  }
		}


	}

}
