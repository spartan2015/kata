package sorting;

import java.util.Arrays;

import org.junit.Test;

public class Quick3Way {

	@Test
	public void main() {
		int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		sort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}

	private void sort(int[] array, int start, int end) {
		if (end <= start) return;
		int lt = start;
		int gt = end;		
		
		int i = start+1;
		
		while(i <= gt){
			if (array[i] < array[lt]) swap(array, lt++ , i++);
			else if (array[i] > array[lt]) swap(array, i , gt--);
			else i++;
		}
		
		sort(array, start, lt-1);
		sort(array, gt+1, end);
	}
	
	private void swap(int[] array, int j, int i) {
		int tmp = array[j];
		array[j] = array[i];
		array[i] = tmp;
	}
}
