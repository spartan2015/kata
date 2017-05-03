package sorting;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Battlestar on 1/12/2015.
 */
public class InsertionSort {

    /**
     * worse case: n2 -
     * good for small datasets - good for streaming
     */
    @Test
    public void sort(){
        int[] array = {4,3,2,1};

        insertSort(array);

        System.out.println(Arrays.toString(array));
    }

    public void  insertSort(int[] array){
        for(int i = 1; i < array.length; i++){
                int j = i;
                int value = array[i];
                while (array[j - 1] > value){ // compare first value
                    array[j] = array[j-1];
                    j--;
                    if (j <= 0) break;
                }
                array[j] = value;
            }
     }

}
