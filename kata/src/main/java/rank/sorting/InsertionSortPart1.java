package hackerRank.sorting;

import java.util.Scanner;

import org.junit.Test;

public class InsertionSortPart1 {

	@Test
	public void test() {
		insertionSortPart2(new int[] { 1, 4, 3, 5, 6, 2 });
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int V = in.nextInt();
		int n = in.nextInt();

		int[] ar = readArr(in, n);

		System.out.println(insertionSortPart2(ar));
	}

	public static void insertIntoSorted(int[] ar) {
		insertSort(ar.length - 1, ar[ar.length - 1], ar);
	}

	public static int insertionSortPart2(int[] ar) {
		int shifts = 0;
		for (int i = 1; i < ar.length; i++) {
			shifts += insertSort2(i, ar[i], ar);
		}
		return shifts;
	}

	private static int insertSort2(int i, int V, int[] ar) {
		int shifts = 0;
		while (i > 0 && ar[i - 1] > V) {
			shifts++;
			ar[i] = ar[i - 1];
			i--;
		}
		ar[i] = V;
		// printArray(ar);
		return shifts;
	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

	private static void insertSort(int i, int V, int[] ar) {
		while (i > 0 && ar[i - 1] > V) {
			ar[i] = ar[i - 1];
			print(ar);
			i--;
		}
		ar[i] = V;
		print(ar);
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

	public static int[] readArr(Scanner in, int n) {
		int[] ar = new int[n];
		for (int i = 0; n - i != 0; i++) {
			ar[i] = in.nextInt();
		}
		return ar;
	}

}
