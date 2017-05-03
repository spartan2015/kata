package java8.stream.primitives;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LongSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.junit.Test;

public class PrimitiveSummaryStatistics {

	@Test
	public void getSummaryStatistics(){
		
		IntSummaryStatistics iss = IntStream.rangeClosed(1, 3).summaryStatistics();
		double d = iss.getAverage();
		long l = iss.getSum();
		int minI = iss.getMin();
		int maxtI = iss.getMax();
		long count = iss.getCount();
		
		
		LongSummaryStatistics lss = LongStream.rangeClosed(1,3).summaryStatistics();
		
		DoubleSummaryStatistics dst = DoubleStream.of(1.1,2.1).summaryStatistics();
				
	}
	
}
