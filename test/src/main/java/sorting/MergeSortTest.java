package sorting;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Battlestar on 1/10/2015.
 */
public class MergeSortTest {

    /**
     * O(n log(n))
     */
    @Test
    public void mergeSortTest(){

        int[] array = {4,3,2,1};

        mergeSort(array);

        System.out.println(Arrays.toString(array));
    }

    public void mergeSort(int[] array){
        int[] tempArray = new int[array.length];
        split(array, tempArray, 0, array.length-1);
    }

    public void split(int[] array, int[] tempArray, int startPos, int endPos){
        if (startPos < endPos){
            int midPos = (startPos + endPos) / 2;
            split(array, tempArray, startPos, midPos);
            split(array, tempArray, midPos+1, endPos);

            merge(array, tempArray, startPos, midPos, endPos);
        }
    }

    public void merge(int[] array, int[] tempArray,int startPos, int midPos, int endPos){

        int startPos1 = startPos;
        int endPos1 = midPos;

        int startPos2 = midPos+1;
        int endPos2 = endPos;

        int tmp_pos = startPos1;

        int count = endPos-startPos+1;

        while(startPos1 <= endPos1 && startPos2 <= endPos2){
            if (array[startPos1] <= array[startPos2]){
                tempArray[tmp_pos++]=array[startPos1++];
            }else{
                tempArray[tmp_pos++]=array[startPos2++];
            }
        }

        while(startPos1 <= endPos1){
            tempArray[tmp_pos++]=array[startPos1++];
        }

        while(startPos2 <= endPos2){
            tempArray[tmp_pos++]=array[startPos2++];
        }

        for(int i =0; i < count; i++){
            array[endPos2]=tempArray[endPos2--];
        }
    }
}
