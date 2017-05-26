package hackerRank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.PrimitiveIterator;
import java.util.Scanner;
import java.util.Spliterators;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

public class NumbersInVectors {

	 public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 int n = in.nextInt();
		IntStream is = streamInts(in, n);
		 
		 int[] summary = new int[3];
		 is.forEach(i->{
			 if (i < 0) summary[0]++;
			 if (i == 0) summary[1]++;
			 if (i>0) summary[2]++;
		 });
		 System.out.println(precisionDivision(summary[2],n));
		 System.out.println(precisionDivision(summary[0],n));
		 System.out.println(precisionDivision(summary[1],n));
	 }

	private static BigDecimal precisionDivision(int what, int toWhat) {
		return BigDecimal.valueOf(what).divide(BigDecimal.valueOf(toWhat), 6, RoundingMode.CEILING);
	}
	
	public static IntStream streamInts(final Scanner in, final int n) {
		return StreamSupport.intStream(Spliterators.spliteratorUnknownSize(new PrimitiveIterator.OfInt() {
			int i = 0;

			@Override
			public void forEachRemaining(IntConsumer action) {
				while (n - i != 0) {
					action.accept(in.nextInt());
					i++;
				}
			}

			@Override
			public boolean hasNext() {
				return n - i != 0;
			}

			@Override
			public Integer next() {
				i++;
				return in.nextInt();
			}

			@Override
			public int nextInt() {
				i++;
				return in.nextInt();
			}
		}, 1), false);
	}
	
}
