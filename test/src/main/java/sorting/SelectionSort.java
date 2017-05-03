package sorting;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by vasilei on 3/17/2015.
 */
public class SelectionSort {

    @Test
    public void t(){
        Integer[] ar = {2,1,0};
        sort(ar);
        System.out.println(Arrays.toString(ar));
    }

    public void sort(Comparable[] array){
        for(int i = 0; i< array.length;i++){
            int min = i;
            for(int j = i+1; j< array.length; j++){
                if (less(array[j], array[i])) min = j;
            }
            swap(array, i, min);
        }
    }

    public void swap(Comparable[] array, int i1, int i2){
        Comparable temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

    public boolean less(Comparable c1, Comparable c2){
        return c1.compareTo(c2) < 0;
    }
}
