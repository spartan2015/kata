package bitwise;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberOfBitsRequiredToConvertFromIntegerAToB {

	@Test
	public void test(){
		
		assertTrue(2 == noOfBitsRequiredToConvertFrom(1,2));
		
		assertTrue(2 == noOfBitsRequiredToConvertFrom(31,14));
		
	}

	private int noOfBitsRequiredToConvertFrom(int a, int b) {
		int count = 0;
		for(int i =0; i< 32; i++){
			if (bitValue(a,i) != bitValue(b,i)){
				count++;
			}
		}
		return count;
	}

	private boolean bitValue(int a, int i) {
		return (a & 1 << i) > 0 ? true : false;
	}
	
}
