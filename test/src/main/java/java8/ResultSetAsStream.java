package java8;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.junit.Test;

public class ResultSetAsStream {

	@Test
	public void clientCodeJava7() throws Exception{
		try(Stream<String> brands = getBrands()){		
			brands.forEach(System.out::println);
		}
		
	}
	
	@Test
	public void clientCodeJava6() throws Exception{
		Stream<String> brands = null;
		try{
			brands =  getBrands();	
			brands.forEach(System.out::println);
		}finally{
			brands.close();
		}
		
	}
	
	public Stream<String> getBrands() throws Exception{
		String url = "";
		String username ="";
		String password = "";
		Connection connection = DriverManager.getConnection(url, username, password);
		PreparedStatement preparedStatement = connection.prepareStatement("select * from Car");
		ResultSet resultSet = preparedStatement.executeQuery();
		
		Spliterator<String> resultSetSpliterator = Spliterators.spliteratorUnknownSize(new Iterator<String>(){

			@Override
			public boolean hasNext() {
				return safeExecute(()->resultSet.next());
			}

			@Override
			public String next() {				
				return safeExecute(()->resultSet.getString("brand"));
			}}, Spliterator.CONCURRENT);
		
		Stream<String> stream = StreamSupport.stream(resultSetSpliterator, true);
		
		stream.onClose(()->{
			closeResource(preparedStatement);
			closeResource(resultSet);
			closeResource(connection);
		});
		
		return stream;
	}

	public static void closeResource(
			AutoCloseable resource) {
		if (resource != null){				
			safeExecute(()->{resource.close(); return true;});				
		}
	}
	
	interface UnsafeSupplier<T> extends Supplier<T>{
		default T get(){
			try {
				return getWithException();
			} catch (Exception e) {				
				e.printStackTrace();
			}
			return null;
		}
		
		public T getWithException() throws Exception;
	}
	
	public static <T> T safeExecute(UnsafeSupplier<T> supplier){
		return supplier.get();
	}

}
