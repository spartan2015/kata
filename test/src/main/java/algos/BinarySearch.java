package algos;

import org.junit.Test;

import java.util.concurrent.locks.Lock;

/**
 * Created by Battlestar on 1/27/2015.
 */
public class BinarySearch {

    @Test
    public void test(){
        int[] a = {1,2,3,4,5};
        System.out.println(binarySearch(a,0,a.length,1));
    }
// log n
    int binarySearch(int[] array,int start, int end, int value){
        if (end > start) return -1;
        int mid = (start + end)/2;
        if (array[mid]==value){
            return mid;
        }else if (array[mid]> value){
            return binarySearch(array, start, mid-1,value);
        }else{
            return binarySearch(array, mid+1, end,value);
        }


    }
}
