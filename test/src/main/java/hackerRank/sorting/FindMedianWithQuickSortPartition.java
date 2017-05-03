package hackerRank.sorting;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

import utils.TimerUtils;

/**
 * REMARKABLE MEDIAN FINDER
 * 
 * @author vasil
 *
 */
public class FindMedianWithQuickSortPartition {

	@Test
	public void te1() {
		assertEquals(Long.valueOf(3), Long.valueOf(findMedian(new int[] { 1, 2, 3, 4, 5 })));

	}

	@Test
	public void te2() {
		assertEquals(Long.valueOf(2), Long.valueOf(findMedian(new int[] { 1, 2, 3 })));
	}
	
	@Test
	public void te3() {
		assertEquals(Long.valueOf(3), Long.valueOf(findMedian(new int[] { 5,4,3,2,1 })));
	}
	
	@Test
	public void te4() {
		assertEquals(Long.valueOf(8), Long.valueOf(findMedian(new int[] { 11,4,8,14,3 })));
	}
	
	@Test
	public void te5() {
		assertEquals(Long.valueOf(3), Long.valueOf(findMedian(new int[] { 0,1,2,4,6,5,3 })));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		for(int i =0; i< 3; i++){
		int n = in.nextInt();

		int[] vector = readArr(in, n);
		int medianValue = TimerUtils.timed(()->findMedian(vector));
		
		//quickSort(vector);
		//isSorted(vector);
		//System.out.println(medianValue + " " + vector[vector.length/2]);
		System.out.println(medianValue);
		}
	}

	private static int findMedian(int[] vector) { // finding median is way faster than sort 4 ms to find median vs 6 seconds full sort
		int p = -1;
		int med = vector.length / 2;
		int start = 0;
		int end = vector.length-1;
		do{
			if (p < med){
				start=p+1;
			}
			else{ // is before p
				end = p;
			}
			p = pivotSpec(vector, start, end);
		} while (p != med);

		return vector[p];
	}

	
	private static int pivotSpec(int[] vector, int lo, int hi) {
		if (lo >= hi)
			return lo;
		int pivot = vector[lo];
		int i = lo + 1;
		int j = hi;
		while (i <= j) {
			//System.out.println(i + " " + j +  " " );
			while (i <=hi && vector[i] <= pivot){
				i++;
			}
			while (j>lo && vector[j] >= pivot)
				j--;
			if (i < j) {
				swap(vector, i++, j--);
			}
		}
		swap(vector, lo, j);

		return j;
	}
	
	
	
	
	static void quickSort(int[] ar){
		quickSort(ar, 0, ar.length-1);
	}
	static void quickSort(int[] ar, int lo, int hi){
		if (lo >=hi){
			return;
		}
		int p = pivot(ar, lo, hi);
		quickSort(ar,lo, p);
		quickSort(ar,p+1, hi);
	}
	
	
	
	private static int pivot(int[] vector, int lo, int hi) {
		if (lo >= hi)
			return lo;
		int pivot = vector[lo];
		int i = lo + 1;
		int j = hi;
		while (i <= j) {
			while (i <=hi && vector[i] <= pivot){
				i++;
			}
			while (j>lo && vector[j] >= pivot)
				j--;
			if (i < j) {
				swap(vector, i++, j--);
			}
		}
		swap(vector, lo, j);

		return j;
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

	private static void isSorted(int[] ar) {
		for(int i =1; i< ar.length; i++){
			if (ar[i-1] > ar[i]){
				throw new RuntimeException("incorrect sorting");
			}
		}
	}
}
