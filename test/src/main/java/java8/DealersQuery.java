package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class DealersQuery {

	static class Car{
		String name;
	}
	
	static class Dealer{
		public List<Car> getCars(){
			try {
				Thread.currentThread().sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Arrays.asList(new Car());
		}
		
	}
	
	List<Dealer> dealers = Arrays.asList(new Dealer(), new Dealer(), new Dealer());
	
	@Test
	public void getCars(){		
		for(Dealer dealer : dealers){			
		}
		
		dealers.parallelStream().map .collect(Collectors.toList());
		
	}
	
	
}
