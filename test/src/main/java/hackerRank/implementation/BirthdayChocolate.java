package hackerRank.implementation;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.Test;



public class BirthdayChocolate {
	@Test
	public void t1() {
		assertEquals(Integer.valueOf(2), Integer.valueOf(getWays(new int[] { 1, 2, 1, 3, 2 }, 3, 2)));
	}

	@Test
	public void t2() {
		assertEquals(Integer.valueOf(1), Integer.valueOf(getWays(new int[] { 4 }, 4, 1)));
	}

	@Test
	public void t3() {
		assertEquals(Integer.valueOf(3), Integer.valueOf(getWays(stringToIntArray("2 5 1 3 4 4 3 5 1 1 2 1 4 1 3 3 4 2 1"), 18, 7)));
	}

	private int[] stringToIntArray(String s) {
		List<Integer> list = Arrays.stream(s.split(" ")).map(Integer::valueOf).collect(Collectors.toList());
		int[] ar = new int[list.size()];
		int index = 0;
		for (Integer i : list) {
			ar[index++] = i;
		}
		return ar;
	}

	static int getWays(int[] squares, int sumTarget, int mConsecutive) {
		int count = 0;
		boolean first = true;
		int sum = 0;
		for(int i = 0; i+mConsecutive <= squares.length; i++){
			if (first){
				for(int k = 0; k < mConsecutive; k++ ){
					sum+=squares[k];
				}
				first = false;
			}else{
				sum -= squares[i-1];
				sum += squares[i+mConsecutive-1];
			}
			if (sum == sumTarget){
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] s = new int[n];
		for (int s_i = 0; s_i < n; s_i++) {
			s[s_i] = in.nextInt();
		}
		int d = in.nextInt();
		int m = in.nextInt();
		int result = getWays(s, d, m);
		System.out.println(result);
	}
}
