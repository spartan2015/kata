package hackerRank.searching;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

import org.junit.Test;

public class HouseAntenas {

	@Test
	public void test1() {
		assertEquals(Long.valueOf(2), Long.valueOf(placeAntenas(1, toMap(new int[] { 1, 2, 3, 4, 5 }))));
	}

	@Test
	public void test2() {
		assertEquals(Long.valueOf(1), Long.valueOf(placeAntenas(2, toMap(new int[] { 1, 2, 3, 4, 5 }))));
	}

	@Test
	public void test3() {
		assertEquals(Long.valueOf(1), Long.valueOf(placeAntenas(3, toMap(new int[] { 1, 2, 3, 4, 5 }))));
	}

	@Test
	public void test4() {
		assertEquals(Long.valueOf(1), Long.valueOf(placeAntenas(4, toMap(new int[] { 1, 2, 3, 4, 5 }))));
	}

	@Test
	public void test5() {
		assertEquals(Long.valueOf(1), Long.valueOf(placeAntenas(5, toMap(new int[] { 1, 2, 3, 4, 5 }))));
	}

	@Test
	public void test6() {
		assertEquals(Long.valueOf(5), Long.valueOf(placeAntenas(0, toMap(new int[] { 1, 2, 3, 4, 5 }))));
	}

	@Test
	public void test7() {
		assertEquals(Long.valueOf(3), Long.valueOf(placeAntenas(1, toMap(new int[] { 1, 3, 5 }))));
	}

	@Test
	public void test8() {
		assertEquals(Long.valueOf(2), Long.valueOf(placeAntenas(2, toMap(new int[] { 1, 2, 5 }))));
	}

	@Test
	public void test9() {
		assertEquals(Long.valueOf(3), Long.valueOf(placeAntenas(2, toMap(new int[] { 2, 4, 5, 6/*at4*/, 7, 9, 11,/**/ 12 }))));
	}

	@Test
	public void test10() {
		assertEquals(Long.valueOf(3), Long.valueOf(placeAntenas(2, toMap(new int[] { 2, 4, 5, 6,/*at4*/ 9, 11/*at11*/, 12, 15/*at15*/ }))));
	}

	TreeMap<Integer, Integer> toMap(int[] arr) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i : arr) {
			map.put(i, 1);
		}
		return map;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int noOfHouse = in.nextInt();
		int antenaRange = in.nextInt();

		TreeMap<Integer, Integer> map = readArr(in, noOfHouse);

		System.out.println(placeAntenas(antenaRange, map));
	}

	private static int placeAntenas(int antenaRange, int[] vector) {
		int i = 0;
		int location = 0;
		int n = vector.length;
		int count = 0;
		
		while (i < n) {
	        location = vector[i] + antenaRange; // define transmitter location
	        
	        while (i < n && vector[i] <= location) i++; // find transmiter location - max vector[i] under range
	        
	        location = vector[--i] + antenaRange; // where would this end location calculation - the other range 
	        
	        while (i < n && vector[i] <= location) i++; // place the i to the end of the range
	        
	        count++; // increase count by 1 each time the loop is activated
	    }
		return count;
	}
	
	private static int placeAntenas2(int antenaRange, Integer[] vector) {
		int i = 0;
		int location = 0;
		int n = vector.length;
		int count = 0;
		
		while (i < n) {
	        location = vector[i] + antenaRange; // define transmitter location
	        
	        while (i < n && vector[i] <= location) i++; // find transmiter location - max vector[i] under range
	        
	        Arrays.binarySearch(vector, location+1);
	        i--;
	         
	        location = vector[--i] + antenaRange; // where would this end location calculation - the other range 
	        
	        while (i < n && vector[i] <= location) i++; // place the i to the end of the range
	        
	        Arrays.binarySearch(vector, location+1); 
	        i--;
	        
	        count++; // increase count by 1 each time the loop is activated
	    }
		return count;
	}
	
	private static int placeAntenas(int antenaRange, TreeMap<Integer, Integer> map) {
		if (map.size() == 0)
			return 0;
		int count = 0;
		Integer index =map.firstKey();
		do {
			index = map.floorKey(index + antenaRange); // find middle
			count++;
			index = map.floorKey(index + antenaRange); // find range last element
		} while ((index = map.higherKey(index)) != null); // try to find next
		return count;
	}

	public static TreeMap<Integer, Integer> readArr(Scanner in, int n) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; n - i != 0; i++) {
			map.put(in.nextInt(), 1);
		}
		return map;
	}
}
