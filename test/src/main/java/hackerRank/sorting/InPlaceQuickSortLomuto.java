package hackerRank.sorting;

import java.util.Scanner;

public class InPlaceQuickSortLomuto {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] ar = readArr(in, n);

		quickSort(ar);

	}

	private static void quickSort(int[] ar) {
		quickSort(ar, 0, ar.length - 1);
	}

	public static void quickSort(int[] arr, int start, int end) {
		// Lomuto partitioning scheme
		if (start >= end)
			return;

		int pivot = arr[end];
		int elementsLessThanPivotIndex = start;
		int count = 0;
		for (int i = start; i < end; i++) {
			if (arr[i] <= pivot) {
				swap(arr, i, elementsLessThanPivotIndex);
				elementsLessThanPivotIndex++;
			}
		}
		swap(arr, elementsLessThanPivotIndex, end);
		print(arr);

		quickSort(arr, start, elementsLessThanPivotIndex - 1);
		quickSort(arr, elementsLessThanPivotIndex + 1, end);

	}

	private static void swap(int[] ar, int i, int j) {
		int tmp = ar[i];
		ar[i] = ar[j];
		ar[j] = tmp;
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
