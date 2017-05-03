package java8.stream.primitives;

import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.junit.Test;

public class WorkingWithPrimitiveStreamsTest {

	@Test
	public void primitiveStreams(){
		IntStream intStream = IntStream.iterate(0, i -> i +1);		
		intStream = IntStream.generate(()->1);
		
		LongStream longStream = LongStream.iterate(0l, l -> l +1);
		longStream = LongStream.generate(()-> 1l);
		
		DoubleStream doubleStream = DoubleStream.iterate(1.1, d -> d * 2);
		doubleStream = DoubleStream.generate(()->1.1);
		
		IntStream ranged = IntStream.range(1, 6);
		ranged = IntStream.rangeClosed(1, 6);
		
	}
	
	@Test
	public void mapToInt(){
		ToIntFunction<Integer> toIntFunction = Integer::intValue;
		IntStream intStream = Stream.of(1,2,3).mapToInt(toIntFunction);
		int sum = intStream.sum();
	}
	@Test
	public void mapToLong(){
		ToLongFunction<Long> toLongFunction = Long::longValue;
		LongStream longStream = Stream.of(1l,2l,3l).mapToLong(toLongFunction);
		double sum = longStream.sum();
	}
	
	@Test
	public void mapToDouble(){		
		ToDoubleFunction<Double> toDoubleFunction = Double::doubleValue;		
		DoubleStream doubleStream = Stream.of(1.1,2.1,3.1).mapToDouble(toDoubleFunction);	
		double sum = doubleStream.sum();				
	}
	
	@Test
	public void IntToDoubleFunction(){
		IntToDoubleFunction intToDouble = i -> i;
		IntStream.of(1).mapToDouble(intToDouble);
	}
	
	@Test
	public void DoubleToIntFunction(){
		DoubleToIntFunction doubleToIntFunction = d->(int)d;
		DoubleStream.of(1.1).mapToInt(doubleToIntFunction);		
	}
	
	@Test
	public void DoubleToLongFunction(){
		DoubleToLongFunction doubleToIntFunction = d->(long)d;
		DoubleStream.of(1.1).mapToLong(doubleToIntFunction);		
	}
}
