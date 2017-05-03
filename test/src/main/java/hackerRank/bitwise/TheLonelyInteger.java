package hackerRank.bitwise;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

public class TheLonelyInteger {

	@Test
	public void t() {
		assertEquals(Long.valueOf(2), Long.valueOf(lonelyInteger(new int[] { 2 })));
		
		assertEquals(Long.valueOf(3), Long.valueOf(lonelyInteger(new int[] { 2,2,3,4,4 })));
		
		assertEquals(Long.valueOf(2), Long.valueOf(lonelyInteger(new int[] { 1,1,2 })));
	}

	private static int lonelyInteger(int[] a) {
		Arrays.sort(a);
		if (a.length == 1) return a[0];
		for (int i = 0; i < a.length - 1; i += 2) {
			if ((a[i] ^ a[i + 1]) != 0) {
				return a[i];
			}
		}
		if (a[a.length-1]!=a[a.length-2]){
			return a[a.length-1];
		}

		return 0;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		System.out.println(lonelyInteger(a));
	}
}
