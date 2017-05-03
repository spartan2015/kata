package bitwise.s2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FindTheMissingNumber {

	@Test
	public void findMissingNumber(){
		
		assertTrue(7 == missing(Arrays.asList(0,1,2,3,4,5,6), 0));
		
	}

	private int missing(List<Integer> is, int bitNo) {
		if (bitNo > 2){
			return 0;
		}
		int odd=0;
		int even=0;
		for(Integer i : is){
			if ((i & 1 << bitNo) == 0){
				even++;
			}else{
				odd++;
			}
		}
		if (odd < even){ // missing a 1
			return missing(is,bitNo+1) | 1 << bitNo; 
		}else{ // missing a 0
			return missing(is,bitNo+1) | 0 << bitNo;
		}
	}
	
}
