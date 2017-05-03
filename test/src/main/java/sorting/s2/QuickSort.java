package sorting.s2;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Battlestar on 1/27/2015.
 */
public class QuickSort {

    @Test
    public void test(){
        int[] array  = {1,2,3};

        quickSortWithPartition(array,0, array.length-1);;

        System.out.println(Arrays.toString(array));
    }

    void quickSort(int[] array, int start, int end){
        int mid = (start+end)/2;
        int value = array[mid];
        int i = start;
        int j = end;
        if (i>=j) return;
        do {
            while (array[i] < value) i++;
            while (array[j] > value) j--;

            if (i <= j){
                swap(array, i++, j--);
            }

        } while (i <= j);

        quickSort(array, start, mid - 1);
        quickSort(array, mid + 1, end);
    }


    void quickSortWithPartition(int[] array, int start, int end){
        if (end > start) {
            int pivot = partition(array, start, end);
            quickSort(array, start, pivot - 1);
            quickSort(array, pivot + 1, end);
        }
    }

    int partition(int[] array,int start,int end){
        int value = array[0];
        int i = start +1;
        int j = end;

        while(i < j){
            while(array[i] < value && i < end) i++;
            while(array[j] > value) j--;

            if(i < j) swap(array, i,j);

        }

        array[0] = array[j];
        array[j]=value;
        return j;
    }

    void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
