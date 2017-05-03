package java8.stream.primitives;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.junit.Test;

public class StreamSumDoesNotReturnOptional {

	@Test
	public void streamSumDoesNotReturnOptional() {
		int alwaysReturnsPrimitveInt = IntStream.rangeClosed(1, 3).sum();

		long alwaysReturnsPrimitveLong = LongStream.rangeClosed(1, 3).sum();

		double alwaysReturnsPrimitveDouble = DoubleStream.of(1.1, 2.1).sum();
	}

}
