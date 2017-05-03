package java8.stream.primitives;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.junit.Test;

public class OptionalPrimitiveTest {

	@Test
	public void avgMinMaxReturnOptional(){
		OptionalDouble optionalAvgDouble1 = IntStream.range(1, 3).average();
		OptionalInt optionalMinDouble2 = IntStream.range(1, 3).min();
		OptionalLong optionalMaxDouble3 = LongStream.range(1, 3).max();
	}
	
	@Test
	public void optionalDouble() {
		OptionalDouble optionalDouble = IntStream.rangeClosed(1, 3).average();

		DoubleConsumer doubleConsumer = doubleVar -> {};		
		optionalDouble.ifPresent(doubleConsumer);
		double d1 = optionalDouble.orElse(2.2);
		
		double d = optionalDouble.getAsDouble();
		DoubleSupplier doubleSupplier = () -> 2.2;
		optionalDouble.orElseGet(doubleSupplier);
		
		OptionalDouble oD1 = OptionalDouble.of(2.2);
		OptionalDouble oD2 = OptionalDouble.empty();
	}

}
