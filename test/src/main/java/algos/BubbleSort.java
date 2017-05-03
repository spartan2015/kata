package algos;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Battlestar on 1/27/2015.
 */
public class BubbleSort {

    @Test
    public void test(){
        int[] array = {4,3,2,1};

        bubbleSortWhileOptimized(array);
        System.out.println(Arrays.toString(array));

    }

    void bubbleSortWhile(int[] array){
        while(true){
            boolean swap = false;

            for(int i = 1; i < array.length; i++){
                if (array[i-1] > array[i]){
                    swap(array,i,i-1);
                    swap = true;
                }
            }

            if (!swap){
                break;
            }
        }
    }

    void bubbleSortWhileOptimized(int[] array){
        while(true){
            int iterations = 0;
            boolean swap = false;

            for(int i = 1; i < array.length - iterations; i++){
                if (array[i-1] > array[i]){
                    swap(array,i,i-1);
                    swap = true;
                }
            }

            iterations++;

            if (!swap){
                break;
            }
        }
    }

    void bubbleSortWithFor(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = i+1; j < array.length; j++){
                if (array[i] > array[j]){
                    swap(array, i, j);
                }
            }
        }
    }

    void swap(int[] array,int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
