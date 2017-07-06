package utils;

import java.util.PrimitiveIterator;
import java.util.Scanner;
import java.util.Spliterators;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

public class ReadingUtils {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//IntStream is = streamInts(in, in.nextInt());
		
		//int[] ar = readArr(in, in.nextInt());
		sum();
	}
	
	public static void sum(){
		Scanner in = new Scanner(System.in);
		IntStream is = streamInts(in, in.nextInt());
		long sum = is.mapToLong(i->i).sum();
		System.out.println(sum);
	}
	
	public static int[] readArr(Scanner in, int n) {
		int[] ar = new int[n];
		for (int i = 0; n - i != 0; i++) {
			ar[i] = in.nextInt();
		}
		return ar;
	}

	public static int[][] readMatrix(Scanner in, int n){
		int[][] matrix = new int[n][n];
		for(int i =0; i<n;i++){
			matrix[i] = readArr(in, n);
		}
		return matrix;
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
