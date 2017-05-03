package sorting.s2;

import org.junit.Test;

public class MergeSortTopDownTest {

	@Test
	public void t() {
		mergeSortTopDown(new int[] { 4, 3, 2, 1 }, new int[4], 0, 4);
	}

	void mergeSortTopDown(int[] array, int[] aux, int start, int end) {
		if (end - start < 1)
			return;
		int half = (start + end) / 2;
		mergeSortTopDown(array, aux, start, half);
		mergeSortTopDown(array, aux, half + 1, end);		
		merge(array,aux, start, half, end);
	}

	private void merge(int[] array, int[] aux, int start, int half, int end) {		
		for(int k = start; k <= end; k++){
			aux[k]=array[k];		
		}
		
		int i = start;
		int j = half+1;
		for(int k = start; k <= end; k++){
			if (i>half) array[k]=aux[j++];
			else if (j > end) array[k]=aux[i++];
			else if (aux[j] < aux[i]) array[k]=aux[j++];
			else array[k]=aux[i++];
		}
	}
	
	private void mergeBad(int[] array, int[] aux, int start, int end) { // using unoptimized selection sort - would lose optimization of a proper merge
		for (int i = start + 1; i <= end; i++) {
			for (int j = i; j <= end; j++) {
				if (array[j] < array[i - 1]) {
					int tmp = array[i];
					array[i] = array[j];
					array[i] = tmp;
				}
			}
		}
	}
}
