package sorting.s2;

import java.util.Arrays;

import org.junit.Test;

public class QuickSortRecurrsiveTest {

	@Test
	public void main() {
		int[] array = { 9,8,7,6,5,4,3,2,1};
		sort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}

	public void sort(int[] array, int start, int end) {
		if (end <= start)
			return;
		int i = sedgewickPartition(array, start, end);
		sort(array, start, i -1);
		sort(array, i + 1, end);
	}

	private int partition(int[] array, int start, int end) {
		int middle = (start + end) / 2;
		int i = start;
		int j = end;
		while (i<j && array[i] <= array[middle])
			i++;
		while (j>=i && array[j] >= array[middle])
			j--;

		while (j >= i) {
			if (array[j] <= array[middle] && j >= i) {
				swap(array, i++, j--);				
			}
			if(array[i] >= array[middle] && j >= i) {
				swap(array, i++, j--);				
			}			
		}
		return j+1; // now this return is important - shoul be the middle in the right position
	}
	
	private int sedgewickPartition(int[] array, int start, int end){
		int i = start;
		int j = end+1;
		int middleVal = array[start];
		while(true){
			while(array[++i] < middleVal) if (i == end) break;
			while(array[--j] > middleVal) if (j == start) break;
			if (i >=j) break;
			swap(array, i, j);
		}
		swap(array, start, j);
		return j;
	}

	private void swap(int[] array, int j, int i) {
		int tmp = array[j];
		array[j] = array[i];
		array[i] = tmp;
	}
}
