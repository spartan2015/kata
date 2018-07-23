package mastering.jdbc.dao3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.sql.DataSource;

/*public class FunctionalStream {
	
	public static void main(String[] args) throws Exception{
		try(Stream stream = tableAsStream(null, "asd")){
			
		}
	}
	
	public static <T> Stream<T> tableAsStream(DataSource dataSource, String table)
		    throws SQLException {

		    UncheckedCloseable close=null;
		    try {
		        Connection connection = dataSource.getConnection();
		        close=UncheckedCloseable.wrap(connection);
		        String sql = "select * from " + table;
		        PreparedStatement pSt = connection.prepareStatement(sql);
		        close=close.nest(pSt);
		        connection.setAutoCommit(false);
		        pSt.setFetchSize(5000);
		        ResultSet resultSet = pSt.executeQuery();
		        close=close.nest(resultSet);
		        return StreamSupport.stream(new Spliterators.AbstractSpliterator<Record>(
		            Long.MAX_VALUE,Spliterator.ORDERED) {
		            @Override
		            public boolean tryAdvance(Consumer<? super Record> action) {
		                try {
		                    if(!resultSet.next()) return false;
		                    action.accept(createRecord(resultSet));
		                    return true;
		                } catch(SQLException ex) {
		                    throw new RuntimeException(ex);
		                }
		            }
		        }, false).onClose(close);
		    } catch(SQLException sqlEx) {
		        if(close!=null)
		            try { close.close(); } catch(Exception ex) { sqlEx.addSuppressed(ex); }
		        throw sqlEx;
		    }
		}
	
	public static <T> T createRecord(ResultSet rs){
		return null;
	}
}*/
