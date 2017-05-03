package sorting.solving;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchRotatedArray {

	@Test
	public void test() {
		int[] arr = { 6, 7, 8, 1, 2, 3, 4, 5 };

		assertTrue(0 == findInRotated(arr, 6));
		assertTrue(1 == findInRotated(arr, 7));
		assertTrue(2 == findInRotated(arr, 8));
		assertTrue(3 == findInRotated(arr, 1));
		assertTrue(4 == findInRotated(arr, 2));
		assertTrue(5 == findInRotated(arr, 3));
		assertTrue(6 == findInRotated(arr, 4));
		assertTrue(7 == findInRotated(arr, 5));
	}

	
	private int findInRotated(int[] arr, int whatWeLookFor) {
		int start = 0;
		int end = arr.length-1;
		while(end - start >= 0){
			int mid = (start+end)/2;
			if (whatWeLookFor == arr[mid]){
				return mid;
			}else{
				if (arr[start] > arr[mid]){ // rotated case
					if (whatWeLookFor >= arr[start]){
						end = mid-1;
					}else{
						start = mid+1;
					}
				}else{
					if (whatWeLookFor > arr[mid]){ // normal case
						start = mid+1;
					}else{
						end = mid-1;
					}
				}
			}
		}
		return -1;
	}
	
	private int findInRotatedNotEfficient(int[] arr, int whatWeLookFor) { // NOT EFFICIENT
		int realStart = 0;
		for (; arr[realStart] < arr[realStart + 1]; realStart++)
			; // would scan n in worse case not so good
		realStart++;
		
		int start = 0;
		int end = arr.length - 1;
		while (end - start >= 0) {
			int mid = (start + end) / 2;
			int adjustedCoordinate = mid + realStart > arr.length-1 ?  mid+ realStart - arr.length : mid+realStart;
			if (arr[adjustedCoordinate] == whatWeLookFor) {
				return adjustedCoordinate;
			}
			if (whatWeLookFor < arr[adjustedCoordinate]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return -1;
	}
}
