package hackerRank.sorting;

import java.util.Scanner;

public class CountingSortSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] ar = readArr(in, n);

		int[] countSort = new int[100];
		for (int i : ar) {
			countSort[i]++;
		}

		for (int i = 0; i < countSort.length; i++) {
			for (int j = 0; j < countSort[i]; j++) {
				System.out.print(i);

			}
			System.out.print(" ");
		}
		System.out.println();
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
