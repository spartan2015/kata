package java8.concurrency;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class WorkingWithParallelStreams {

	
	@Test
	public void t(){
		// limitations of parallel Streams - if you need more threads than CPU threads you have to use a custom implementation
		// creation method 1
		IntStream stream1 = IntStream.range(1, 10).parallel();
		
		// creation method 2
		Stream stream2 =Arrays.asList(1,2,3).parallelStream();
		
		
	}
}
