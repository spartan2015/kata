package hackerRank.sorting;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

public class QuickSortPart1 {

	@Test
	public void t1() {
		int[] ar = { 1 };
		quick3Way(ar);
		assertTrue(Arrays.equals(new int[] { 1 }, ar));
	}

	@Test
	public void t2() {
		int[] ar = { 1, 2 };
		quick3Way(ar);
		assertTrue(Arrays.equals(new int[] { 1, 2 }, ar));
	}

	@Test
	public void t3() {
		int[] ar = { 1, 2, 3 };
		quick3Way(ar);
		assertTrue(Arrays.equals(new int[] { 1, 2, 3 }, ar));
	}

	@Test
	public void t4() {
		int[] ar = { 2, 1 };
		quick3Way(ar);
		assertTrue(Arrays.equals(new int[] { 1, 2 }, ar));
	}

	@Test
	public void t5() {
		int[] ar = { 4, 3, 2, 4, 5 };
		quick3Way(ar);
		assertTrue(Arrays.equals(new int[] { 2, 3, 4, 4, 5 }, ar));
	}

	@Test
	public void t6() {
		int[] ar = { 4,5,3,7,2 };
		quick3Way(ar);
		print(ar);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] ar = readArr(in, n);

		quick3Way(ar);

		print(ar);
	}

	private static void quick3Way(int[] ar) {
		int start = 0;
		int end = ar.length - 1;

		int lo = start + 1;
		int v = ar[start];
		int hi = end;

		while (hi > lo) { // 2 1 - lo = 1, hi = 1  - 2 > 1 - we don't get out of the loop  - 
			while (lo < hi && ar[lo] < v)
				lo++;
			while (hi >= lo && ar[hi] >= v)
				hi--;
			if (lo < hi) {
				swap(ar, lo++, hi--);
			}
		}
		if (ar[0] > ar[hi])
		swap(ar, 0, hi);
	}

	private static void swap(int[] ar, int i, int j) {
		int tmp = ar[i];
		ar[i] = ar[j];
		ar[j] = tmp;
	}

	public static int[] readArr(Scanner in, int n) {
		int[] ar = new int[n];
		for (int i = 0; n - i != 0; i++) {
			ar[i] = in.nextInt();
		}
		return ar;
	}

	private static void print(int[] ar) {
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i]);
			if (i != ar.length - 1) {
				System.out.print(" ");
			}
		}
		System.out.println();
	}
}
