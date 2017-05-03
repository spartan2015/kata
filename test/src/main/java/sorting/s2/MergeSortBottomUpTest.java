package sorting.s2;

import java.util.Arrays;

import org.junit.Test;

public class MergeSortBottomUpTest {

	@Test
	public void t() {
		int[] array = new int[] { 4, 3, 2, 1 };
		mergeSortBottomUp(array, new int[4], 0, 4);
		System.out.println(Arrays.toString(array));
	}

	void mergeSortBottomUp(int[] array, int[] aux, int start, int end) {
		for (int subarraySize = 1; subarraySize < array.length; subarraySize *= 2) {
			forEachSubarrayLevel(array, aux, subarraySize);
		}
	}

	private void forEachSubarrayLevel(int[] array, int[] aux, int subarraySize) {
		for (int firstArrayIndex = 0; firstArrayIndex < array.length - subarraySize; firstArrayIndex += subarraySize
				* 2) {
			int secondArrayIndex = firstArrayIndex + subarraySize;
			makeCopy(array, aux, subarraySize, firstArrayIndex, secondArrayIndex);
			merge(array, aux, subarraySize, firstArrayIndex, secondArrayIndex);
		}
	}

	private void makeCopy(int[] array, int[] aux, int subarraySize, int firstArrayIndex, int secondArrayIndex) {
		for (int k = firstArrayIndex; k < secondArrayIndex + subarraySize; k++) {
			aux[k] = array[k];
		}
	}

	private void merge(int[] array, int[] aux, int subarraySize, int firstArrayIndex, int secondArrayIndex) {
		int i = firstArrayIndex;
		int j = secondArrayIndex;
		for (int k = firstArrayIndex; k < secondArrayIndex + subarraySize ; k++) {
			if (j > secondArrayIndex + subarraySize - 1)
				array[k] = aux[i++];
			else if (i > firstArrayIndex + subarraySize - 1)
				array[k] = aux[j++];
			else if (aux[j] < aux[i])
				array[k] = aux[j++];
			else
				array[k] = aux[i++];
		}
	}

}
