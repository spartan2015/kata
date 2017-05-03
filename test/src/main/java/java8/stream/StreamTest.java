package java8.stream;

import java.util.stream.Stream;

import org.junit.Test;

public class StreamTest {
	
	@Test
	public void basicStreamCreation(){
		Stream<String> stream = Stream.of("a","b","c");
		
		Stream<String> infinite = Stream.generate(()->"a");
		
	}
}
