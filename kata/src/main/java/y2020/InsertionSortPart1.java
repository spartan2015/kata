package y2020;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * InsertionSortPart1
 * /challenges/insertionsort1/problem
 */
public class InsertionSortPart1 {

    /**
     * print interim and final array
     * @param n
     * @param arr
     */

    static void insertionSort1(int n, int[] arr) {
        int val = arr[arr.length-1];
        for(int i = arr.length-2; i >=0; i--){
            if (arr[i] > val){
                arr[i+1] = arr[i];
                System.out.println(Arrays.stream(arr).mapToObj(c->c+"").collect(Collectors.joining(" ")));
            }else{
                arr[i+1] = val;
                System.out.println(Arrays.stream(arr).mapToObj(c->c+"").collect(Collectors.joining(" ")));
                return;
            }
        }

        arr[0] = val;
        System.out.println(Arrays.stream(arr).mapToObj(c->c+"").collect(Collectors.joining(" ")));
    }

    @Test
    public void t(){
        insertionSort1(5,
                Arrays.stream("2 3 4 5 6 7 8 9 10 1".split(" ")).mapToInt(Integer::valueOf).toArray());
    }

}
