package sort;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Shellsort {
	@Test
	public void test() {
		Comparable[] ar = new Comparable[] { 4, 3, 2, 1 };
		sort(ar);
		System.out.println(ar);
		assertTrue(isSorted(ar));
	}

	private static boolean isSorted(Comparable[] ar) {
		for (int i = 1; i < ar.length; i++) {
			if (less(ar[i], ar[i - 1])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * for h = 3 - worse case is N^(3/2) - better than quadratic
	 * 
	 * The only algo with no mathematical model - hence no performance guarantees of any kind
	 * 
	 * 600 times faster than Insertion sort - on 100k random data - hmmm... p 259 - 
	 * 
	 * based on insertion sort
	 * simple extension - if the smalles is N-1 - jumping from 1 element to the next will take longer in insertion sort
	 * than if we would jump several elements at a time - say 3 or 7 - sorting sequences
	 * h sorted array - divide array into h interleaved subsequences - sort them - p 258
	 * then sort the big chunk - insertion sort equiv
	 * 
	 * 
	 * @param ar
	 */
	public static void sort(Comparable[] ar) {
		// find first element that is greater than N/3 
		int h = 1;
		while(h < ar.length/3) h = h*3 + 1; //1, 4, 13, 40, 121, 364, 1093, ...
		
		while(h >=1){
			//insert sort on the h subsequence
			for(int i = h; i < ar.length; i++){
				int j = i;
				Comparable v = ar[i];
				while(j >= h && less(v,ar[j-h])){
					ar[j] = ar[j-h];
					j-=h;
				}
				ar[j]=v;
			}
			
			h /=3; // reverse of 1, 4, 13, 40, 121, 364, 1093, ...
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void swap(Comparable[] ar, int i, int j) {
		Comparable tmp = ar[i];
		ar[i] = ar[j];
		ar[j] = tmp;
	}
}
