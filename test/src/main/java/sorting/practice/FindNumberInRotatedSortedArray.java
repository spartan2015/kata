package sorting.practice;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindNumberInRotatedSortedArray {

	@Test
	public void test(){
		assertEquals(Integer.valueOf(0), Integer.valueOf(find(7, new int[]{7,8,1,2,3,4,5,6})));
		assertEquals(Integer.valueOf(1), Integer.valueOf(find(8, new int[]{7,8,1,2,3,4,5,6})));
		assertEquals(Integer.valueOf(2), Integer.valueOf(find(1, new int[]{7,8,1,2,3,4,5,6})));
		assertEquals(Integer.valueOf(3), Integer.valueOf(find(2, new int[]{7,8,1,2,3,4,5,6})));
		assertEquals(Integer.valueOf(4), Integer.valueOf(find(3, new int[]{7,8,1,2,3,4,5,6})));
		
		assertEquals(Integer.valueOf(6), Integer.valueOf(find(7, new int[]{1,2,3,4,5,6,7,8})));
		assertEquals(Integer.valueOf(0), Integer.valueOf(find(1, new int[]{1,2,3,4,5,6,7,8})));
	}

	private int find(int whatToFind, int[] array) {
		return find(whatToFind, array, 0, array.length-1);
	}

	private int find(int whatToFind, int[] array, int start, int end) {
		if (start > end){
			return -1;
		}
		int mid = (start+end) >>1;
		if (array[mid] == whatToFind){
			return mid;
		}else{
			if (whatToFind > array[mid]){
				if (array[start] > array[mid] && whatToFind >= array[start]){
					return find(whatToFind, array, start,mid-1);
				}else{
					return find(whatToFind, array,  mid+1, end);
				}
			}else{
				if (array[mid] > array[end] && whatToFind < array[start]){
					return find(whatToFind, array, mid+1,end);
				}else{
					return find(whatToFind, array, start, mid-1);
				}
			}
		}
	}
	
}
