package algos;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Battlestar on 1/27/2015.
 */
public class MergeSortTest {

    @Test
    public void t(){
        int[] array = {4,3,2,1};
        int[] tmp = new int[array.length];
        mergeSort(array, tmp, 0, array.length -1 );

        System.out.println(Arrays.toString(array));
    }

    void mergeSort(int[] array, int[] temp, int start ,int end){
        if (end - start > 0){
            int mid = (start+end)/2;
            mergeSort(array,temp, start, mid);
            mergeSort(array,temp,mid+1, end);

            merge(array,temp, start, mid, end);
        }
    }

    void merge(int[] array, int[] temp, int start, int mid, int end){
        int start1 = start;
        int end1 = mid;
        int start2 = mid+1;
        int end2 = end;

        int tmp_pos = start;
        while( start1 <= end1 && start2 <= end2){
            if (array[start1] <= array[start2]){
                temp[tmp_pos++]=array[start1++];
            }else{
                temp[tmp_pos++]=array[start2++];
            }
        }

        while(start1 <= end1) temp[tmp_pos++]=array[start1++];
        while(start2 <= end2) temp[tmp_pos++]=array[start2++];

        for(int i =start; i <= end; i++){
            array[i] = temp[i];
        }
    }
}
