package chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArraysClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		 *Arrays.asList(T[]) - binds them - joined at the hip 
		 */
		int[] a = {3,2,1};
		List list = Arrays.asList(a);
		System.out.println(list + "," + list.size() + ", first element: " + list.get(0).getClass());
		// weird - there is not join at the hip crap - althogh seen it in the manual
		
		int index = Arrays.binarySearch(new int[]{1,2,3},2); // returns index, otherwise with (-)(N + 1) - where would it be positioned if existed
		System.out.println("Arrays.binarySearch(new int[]{1,2,3},2)[1] = " + index);
		
		// if the passed arrays is not sorted in natural way - the search will NOT be predictable
		System.out.println("Arrays.binarySearch(new int[]{3,2,1}, 1) = " + Arrays.binarySearch(new int[]{3,2,1}, 1));

		// sorting
		int[] x = new int[]{3,2,1};
		Arrays.sort(x);
		for(int i : x){
			System.out.print(i + ", ");
		}
		System.out.println();
				
		// Arrays.toString() - very usefull
		System.out.println("Arrays.toString(x[]) " + Arrays.toString(x));
		
		
		Integer[] list1 = new Integer[]{1,2,3};
		// sorting using comparator - only for arrays of objects
		Comparator<Integer> c = new Comparator<Integer>(){
			public int compare(Integer i1, Integer i2){
				return i2.compareTo(i1);
			}
		};
		
		Arrays.sort(list1,c);
		for(int i : list1){
			System.out.print(i + ", ");
		}
		System.out.println();
		
		
		// binarySearch using Comparator
		System.out.println("Arrays.binarySearch(list1,1,c) = " + Arrays.binarySearch(list1,1,c));
		
		
		
		// Collections
		/*
		 * int binarySearch(List,ley)
		 * List reverse(List)
		 * Comparator reverseOrder()
		 * Comparator reverseOrder(Comparator)
		 * sort(List)
		 * sort(List,Comparator)
		 * 
		 */
		
		
	}

}
