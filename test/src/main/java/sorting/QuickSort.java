package sorting;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Battlestar on 1/10/2015.
 */
public class QuickSort {

    /**
     * between n*log n and n^2
     */
    @Test
    public void test(){

        int[] array = {4,3,2,1};

        quickSort(array,0,array.length-1);

        System.out.println(Arrays.toString(array));
    }

    public void quickSort(int[] array, int startPos,int endPos){
        int middleValue = array[(startPos+endPos)/2];
        int i = startPos;
        int j = endPos;

        // all values that are < middleValue must be before it else must be after it
        do{
            // find the first element before the middleValue that is > middleValue
            while(array[i] < middleValue) i++;
            // find the first element after middleValue that is LESS THAN middle value
            while(array[j] > middleValue) j--;
            //swap these elemetsn
            if (i <= j) {
                int tmp = array[i];
                array[i++] = array[j];
                array[j--] = tmp;
            }
        }while(i<=j);

        // recurse for the 2 arrays until there is not the last element is sorted
        if (i<endPos) quickSort(array,i,endPos); // why edn pot - and why start with i - ar fi middle endpo
        if (j>startPos) quickSort(array,startPos,j); // startpost middpost - should be same
    }
}
