package sorting;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.ToIntFunction;

import org.junit.Test;

/**
 * Created by Battlestar on 1/10/2015.
 */
public class BucketSortTest {

	/**
	 * between n*no_of_buckets and n^2
	 */
	@Test
	public void t() {

		int[] array = { 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		bucketSortClassic(array);

		bucketSortMaxBuckets(array);

		System.out.println(Arrays.toString(array));

	}
	
	static class Person{
		int age;
		Person(int age){
			this.age = age;
		}
		public String toString(){
			return "Person[age="+age+"]";
		}
	}
	
	@Test
	public void testGeneric(){
		Person[] persons = new Person[]{new Person(10), new Person(5), new Person(4)};
		bucketSort(persons, p->p.age,10);
		System.out.println(Arrays.toString(persons));		
		assertTrue(persons[0].age == 4);
	}

	public <T> void bucketSort(T[] objects, ToIntFunction<T> mapper, int max){
		List<T>[] buckets = new List[max+1];
		for(T object : objects){
			int bucketNo = mapper.applyAsInt(object);
			if (buckets[bucketNo] == null){
				buckets[bucketNo] = new ArrayList<>();
			}
			buckets[bucketNo].add(object);
		}
		
		for(int i = 0, y = 0; i < buckets.length; i++){
			if (buckets[i]!=null){
				for(T object : buckets[i]){
					objects[y++] = object;
				}
			}
		}
	}
	
	public void bucketSortClassic(int[] array) {
		int maxValue = findMaxValue(array);

		int NO_BUCKETS = 3; // how do we choose an appropiate no of buckets ?
							// this depends on the data - dif between min and
							// max, how is the data dispersed
		// 2 - quicksort like
		// so if you are sorting by age- we can say age is between 0 and 150 -
		// List[120] - that is it - O(N) sorting

		List<Integer>[] buckets = new List[NO_BUCKETS];
		for (int x : array) {
			int bucketNo = x / (maxValue / NO_BUCKETS + 1);
			System.out.println(bucketNo + " add " + x);
			if (buckets[bucketNo] == null)
				buckets[bucketNo] = new ArrayList();
			buckets[bucketNo].add(x);
		}

		// sort each bucket content
		for (List l : buckets) {
			Collections.sort(l);
		}

		int pos = 0;
		// spit out all buckets in order
		for (List<Integer> l : buckets) {
			for (int x : l) {
				array[pos++] = x;
			}
		}
	}

	public void bucketSortMaxBuckets(int[] array) {
		int[] buckets = new int[findMaxValue(array) + 1];

		sortWithBuckets(array, buckets);

		putBackInTheOriginalArrayTheSortedBuckets(array, buckets);

	}

	private void sortWithBuckets(int[] array, int[] buckets) {
		for (int x : array) {
			buckets[x]++; // simple increment
		}
	}
	
	private void putBackInTheOriginalArrayTheSortedBuckets(int[] array, int[] buckets) {
		int pos = 0;
		for (int i = 0; i < buckets.length; i++) {
			for (int y = 0; y < buckets[i]; y++) {
				array[pos++] = i;
			}
		}
	}

	private int findMaxValue(int[] array) {
		int maxValue = 0;
		for (int x : array) {
			if (x > maxValue)
				maxValue = x;
		}
		return maxValue;
	}

}
