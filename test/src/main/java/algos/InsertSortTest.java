package algos;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Battlestar on 1/27/2015.
 */
public class InsertSortTest {

    @Test

    public void test(){
        int[] array = {4,3,2,1};

        insertSort(array);

        System.out.println(Arrays.toString(array));

        insertSortLessOptimized(array);

        System.out.println(Arrays.toString(array));


    }

    void insertSort(int[] array){
        for(int i = 1; i < array.length; i++){
            int j = i;
            int value = array[i];
            while(array[j-1] > value){
                array[j] = array[j-1];
                j--;
                if (j <= 0) break;
            }
            array[j] = value;
        }
    }

    void insertSortLessOptimized(int[] array){
        for(int i = 1; i < array.length; i++){
            for(int j = i; array[i] < array[j] && j >= 0; j--){
                swap(array, i,j); // swaps every time - could just move the element (1 write) - and only the last one makes a full swap (2 writes)
            }
        }
    }

    void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
