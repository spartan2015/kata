package java84th.basic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.junit.Test;

public class SupplierConsumer {

	@Test
	public void supplier(){
		
		Supplier<LocalDate> dateSupplier = LocalDate::now;//static method references - T get();  so static method references can make Suppliers		
		LocalDate d1 = dateSupplier.get();
		
		dateSupplier = () -> LocalDate.now();
		d1 = dateSupplier.get();
		
		Supplier<StringBuilder> sbSupplier = StringBuilder::new; // constructor reference
		sbSupplier = () -> new StringBuilder();
		
		Supplier<List<String>> listSupplier = ArrayList<String>::new;
	}
	
	@Test
	public void consumer(){
		
		Consumer<String> stringConsumer = System.out::println;
		stringConsumer = s -> { System.out.println(s);};
		
		stringConsumer.accept("string");
		
				
	}
}
