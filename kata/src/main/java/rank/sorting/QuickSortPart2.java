package hackerRank.sorting;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class QuickSortPart2 {

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
		assertTrue(Arrays.equals(new int[] { 2, 3, 4,4, 5 }, ar));
	}

	@Test
	public void t6() {
		int[] ar = { 7,6,5,4,3,2,1 };
		quick3Way(ar);
		print(ar);
	}
	

	@Test
	public void t7() {
		int[] ar = { 5, 8, 1, 3, 7, 9, 2 };
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
		
		quickSort(ar,start,end);
	}

	private static void quickSort(int[] ar, int start, int end) {
		if (end-start < 1) return;
		int v = ar[start];
		
		List<Integer> lower = new ArrayList<>();
		List<Integer> higher = new ArrayList<>();
		
		for(int i = start + 1; i <= end; i++){
			if (ar[i] < v) lower.add(ar[i]);
			if (ar[i] >= v) higher.add(ar[i]);
		}
		
		int index = start;
		for(int n : lower){
			ar[index++]=n;
		}
		
		quickSort(ar, start, index-1);
		if (lower.size() > 1)
		print(ar,start,index-1);
		
		ar[index++]=v;
		int mid = index-1;
		
		for(int n : higher){
			ar[index++]=n;
		}
		
		quickSort(ar, mid+1, end);
		if (higher.size() > 1)
			print(ar, mid+1, end);
		
	}

	public static int[] readArr(Scanner in, int n) {
		int[] ar = new int[n];
		for (int i = 0; n - i != 0; i++) {
			ar[i] = in.nextInt();
		}
		return ar;
	}

	private static void print(int[] ar, int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(ar[i]);
			if (i != end) {
				System.out.print(" ");
			}
		}
		System.out.println();
		
	}
	
	private static void print(List ar) {
		for (int i = 0; i < ar.size(); i++) {
			System.out.print(ar.get(i));
			if (i != ar.size() - 1) {
				System.out.print(" ");
			}
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
}
