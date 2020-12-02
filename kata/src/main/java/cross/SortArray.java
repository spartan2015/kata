package cross;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * given an array of distinct integers
 * sort array
 * divide into one or more slices
 * then we sort each slice
 * join the slices in the same order
 *
 * write a function that returns max no of slices
 * for which the algo will return a sorted array.
 *
 * e.g. A=[2,4,1,6,5,9,7] => function returns 3
 */
public class SortArray {

    @Test
    public void t1(){
        assertEquals(3, new SortArray().solution(new int[]{2,4,1,6,5,9,7}));
        assertEquals(1, new SortArray().solution(new int[]{4,3,2,6,1})); // cannot be split - must be sorted all at once
        assertEquals(3, new SortArray().solution(new int[]{2,1,6,4,3,7}));
        // good question is when to decide to split - first split if we find item smaller than previous - true first, true second, true third.
        // slicing factor - not at first that is lower than previous but at first that is greater than the lower previous
        // hmm so the tough part is slicing it ... the result must be a sorted array - you might miss the slicing part -
        // then putting all slices together does not form a sorted array... you could actually check that

        // SO, this means that the next slice cannot contain a number lower than previous slices - else they are the same slice
        // sort of think it backwards... to have  - you need knowledge of the later elements - to decide if that is a slice or not
        // for first case - we should go into th 2 , 4 can make a slice if there is no further lower element

        // but thinki it backwards - 9,7 - next is 5 so no  but why - when should we stop slicing
        // add to slice as long as the no is greater than min of slice
        // - good for 3
        // -

    }

    // so this is 11% success
    // so this was a complete failure almost ... my partitioning thing... did not account for everthing.
    public int solution(int[] A) {
        int slices = 1;
        int currentSliceMin = A[A.length-1];
        for(int i = A.length-2; i >=0; i--){
            if (! (A[i] > currentSliceMin)){
                slices++;
                currentSliceMin = A[i];
            }
        }
        return slices;
    }

}
