package sorting.practice;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class MergeTwoSortedArrays {
	@Test
	public void test(){
		assertTrue(Arrays.equals(new int[]{1,2,3,4,5}, merge(new int[]{1,5,0,0,0}, 2,new int[]{2,3,4})));
	}

	private int[] merge(int[] dest,int size, int[] toMergeArray) {
		int indexDest=0;
		int indexToMergeArray =0 ;
		int[] aux = new int[dest.length];
		
		int auxIndex = 0;
		while(indexToMergeArray < toMergeArray.length || indexDest < size){
			if(indexDest > size-1){
				aux[auxIndex++] = toMergeArray[indexToMergeArray++];
			}else if(indexToMergeArray > toMergeArray.length-1){
				aux[auxIndex++] = dest[indexDest++];
			}
			else if (dest[indexDest] < toMergeArray[indexToMergeArray]){
				aux[auxIndex++] = dest[indexDest++];
			}else{
				aux[auxIndex++] = toMergeArray[indexToMergeArray++];
			}
		}
		
		for(int i =0 ; i < dest.length; i++){
			dest[i] = aux[i];
		}
		
		return dest;
	}
}
