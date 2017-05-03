package hackerRank.sorting;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

public class QuickSortRunningtimeVsInsertionSort {

	@Test
	public void t1() {
		int[] ar = { 1 };
		insertionSort(ar);
		quickSort(ar);
		assertTrue(Arrays.equals(new int[] { 1 }, ar));
	}

	@Test
	public void t2() {
		int[] ar = { 1, 2 };
		insertionSort(ar);
		quickSort(ar);
		assertTrue(Arrays.equals(new int[] { 1, 2 }, ar));
	}

	@Test
	public void t3() {
		int[] ar = { 1, 2, 3 };
		insertionSort(ar);
		quickSort(ar);
		assertTrue(Arrays.equals(new int[] { 1, 2, 3 }, ar));
	}

	@Test
	public void t4() {
		int[] ar = { 2, 1 };
		insertionSort(ar);
		quickSort(ar);
		assertTrue(Arrays.equals(new int[] { 1, 2 }, ar));
	}

	@Test
	public void t5() {
		int[] ar = { 1, 3, 9, 8, 2, 7, 5 };
		int swapsQuick = quickSort(ar);

		assertTrue(Arrays.equals(new int[] { 1, 2, 3, 5, 7, 8, 9 }, ar));

		ar = new int[] { 1, 3, 9, 8, 2, 7, 5 };
		int swapsInsert = insertionSort(ar);

		assertEquals(Integer.valueOf(1), Integer.valueOf(swapsInsert - swapsQuick));

	}

	@Test
	public void t6() {
		int[] ar = { 5, 4, 3, 2, 1 };
		quickSort(ar);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] ar = readArr(in, n);

		int[] clone = ar.clone();
		int quickSort = quickSort(ar);
		isSorted(ar);
		int insertionSort = insertionSort(clone);
		isSorted(clone);
		System.out.println(insertionSort - quickSort);
	}

	private static void isSorted(int[] ar) {
		for(int i =1; i< ar.length; i++){
			if (ar[i-1] > ar[i]){
				throw new RuntimeException("incorrect sorting");
			}
		}
	}

	public static int[] readArr(Scanner in, int n) {
		int[] ar = new int[n];
		for (int i = 0; n - i != 0; i++) {
			ar[i] = in.nextInt();
		}
		return ar;
	}

	private static int insertionSort(int[] ar) {
		int swaps = 0;
		for (int i = 1; i < ar.length; i++) {
			int j = i;
			int value = ar[i];
			while (j - 1 >= 0 && ar[j - 1] > value) {
				ar[j] = ar[j - 1];
				swaps++;
				j--;
			}
			ar[j] = value;
			// swaps++;

		}
		return swaps;
	}

	private static int quickSort(int[] ar) {
		return quickSort(ar, 0, ar.length - 1);
	}

	 public static int quickSort(int[] arr, int start, int end) {
		 	// Lomuto partitioning scheme
	        if(start>=end)
	           return 0;

	        int pivot = arr[end];
	        int indx = start;
	        int count = 0;
	        for(int i=start;i<end;i++) {
	            if(arr[i] <= pivot) {
	                swap(arr,i,indx);
	                count++;
	                indx++;
	            }
	        }
	        swap(arr,indx,end);
	        count++;
	        
	        count+=quickSort(arr,start,indx-1);
	        count+=quickSort(arr,indx+1,end);
	        
	        return count;
	    }
	    
	   
	private static int quickSort1(int[] ar, int start, int end) {
		if (end - start <= 0)
			return 0;
		int swaps = 0;

		int pivot = ar[end];
		int i = start;
		int j = end - 1;
		// hoare partitioning scheme
		while (i < j) {
			while (ar[i] < pivot && i <= j)
				i++;
			while (j > i && ar[j] > pivot)
				j--;
			if (i < j) {
				swap(ar, i, j);
				swaps++;
			}
		}
		if (ar[i] > pivot) {
			swap(ar, i, end); // so j is not
			swaps++;
		}
		swaps += quickSort(ar, start, i - 1);
		swaps += quickSort(ar, i + 1, end);

		return swaps;
	}

	private static void swap(int[] ar, int i, int j) {
		int tmp = ar[i];
		ar[i] = ar[j];
		ar[j] = tmp;
	}
	

	
}
