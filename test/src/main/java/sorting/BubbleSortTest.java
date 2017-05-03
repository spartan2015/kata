package sorting;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Battlestar on 1/10/2015.
 */
public class BubbleSortTest {

    /**
     *  permutari: worst case: n^2 - best n - usual n^2 - worse algo for sorting
     */
    @Test
    public void testSort(){

        int[] array = {4,3,2,1};

        bubbleSort(array);

        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testSortFirstOptimization(){

        int[] array = {4,3,2,1};

        bubbleSortFirstOptimization(array);

        System.out.println(Arrays.toString(array));
    }


    @Test
    public void testSortBestOptimization(){

        int[] array = {4,3,2,1};

        bubbleSortBestOptimization(array);

        System.out.println(Arrays.toString(array));
    }

    public void bubbleSort(int[] array){
        while(true){
            boolean swap = false;
            for(int i = 1; i < array.length; i++) {
                int j = i - 1;
				if (less(array, i, j)) {
                    swap(array, i, j);
                    swap = true;
                }
            }
            if (!swap){
                return;
            }
        }
    }

	private boolean less(int[] array, int i, int j) {
		return array[i] < array[j];
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}

    public void bubbleSortFirstOptimization(int[] array){
        // on each iteration the biggest number will always reach it's final position
        int iterations = 0;
        while(true){
            boolean swap = false;
            for(int i = 1; i < array.length - iterations; i++) {
                int j = i - 1;
				if (less(array, i, j)) {
                    swap(array, i, j);
                    swap = true;
                }
            }
            iterations++;
            if (!swap){
                return;
            }
        }
    }

    public void bubbleSortBestOptimization(int[] array){
        // on each iteration the biggest number will always reach it's final position
        while(true){
            boolean swap = false;
            int lastSwapPosition = array.length;
            for(int i = 1; i < lastSwapPosition; i++) {
            	int j = i - 1;
				if (less(array, i, j)) {
                    swap(array, i, j);
                    swap = true;
                    lastSwapPosition = i;
                }
            }
            if (!swap){
                return;
            }
        }
    }
}
