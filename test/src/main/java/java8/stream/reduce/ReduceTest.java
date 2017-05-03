package java8.stream.reduce;

import static org.junit.Assert.*;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import org.junit.Test;

public class ReduceTest {

	@Test
	public void reduceUsingJustTheAccumulator() {

		Optional<Integer> result = Stream.of(1, 2, 3).reduce((a, b) -> a + b);
		result.ifPresent(System.out::println);

	}

	@Test
	public void reduceUsingIdentityAndTheAccumulator() {
		Integer result = Stream.of(1, 2, 3).reduce(0, (a, b) -> a + b);
		assertEquals(Integer.valueOf(6), result);

		assertEquals("wolf",Stream.of("w","o","l","f").reduce("",String::concat));
	}
	
	@Test
	public void reduceUsingAMapperIdentityAndTheAccumulator() {
		BiFunction<String, ? super Integer, String> accumulator = (a,b)-> "" + a + b;
		BinaryOperator<String> combiner = (a, b) -> a + b;
		
		String result = Stream.of(1, 2, 3).reduce("", accumulator , combiner);
		assertEquals("123", result);
	}
}
