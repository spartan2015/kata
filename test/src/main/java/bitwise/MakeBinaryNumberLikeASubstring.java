package bitwise;

import static org.junit.Assert.*;

import org.junit.Test;

public class MakeBinaryNumberLikeASubstring {

	@Test
	public void test(){
		assertTrue(0b10001010100==incorporateOptimized(0b10000000000,0b10101,2,6));
		
		assertTrue(0b10001010100==incorporateOptimized(0b10001111100,0b10101,2,6));
	}

	public int incorporateOptimized(int n, int m, int i, int j){
		int mask = createClearingBitsMask(i, j);		
		int nCleared = n & mask;
		System.out.println("nCleared: " + Integer.toBinaryString(nCleared));
		int mShiftedToMatchN = m << i;
		System.out.println("mShiftedToMatchN: " + Integer.toBinaryString(mShiftedToMatchN));
		return nCleared | mShiftedToMatchN;
	}

	private int createClearingBitsMask(int start, int end) {
		int max = Integer.MAX_VALUE;		
		System.out.println("max: " + Integer.toBinaryString(max));
		int left = max - (1 << end+1) +1; // or max - (1 << end) -1
		System.out.println("left: " + Integer.toBinaryString(left));
		int right = ((max >> 31 - start)) ; // or (1 << start)-1
		System.out.println("right: " + Integer.toBinaryString(right));
		int mask = left | right;
		System.out.println("mask: " + Integer.toBinaryString(mask));
		return mask;
	}
	
	public int incorporateBitByBit(int into, int number, int start, int end) {
		System.out.println("into: " + Integer.toBinaryString(into));
		for(int i = start, j=0; i<=end; i++,j++){
			int intoVal = into & (1 << i);  
			System.out.println("intoVal: " + Integer.toBinaryString(intoVal));
			int setToVal = number & (1 << j); 
			System.out.println("setToVal: " + Integer.toBinaryString(setToVal));
			int setToValIntoVal = setToVal << start; 
			System.out.println("setToVal shifted: " + Integer.toBinaryString(setToValIntoVal));
			if (intoVal != setToValIntoVal){
				if (intoVal == 0){
					into = into | setToValIntoVal;
				}else{
					into = into ^ intoVal;
				}
				System.out.println("into: " + Integer.toBinaryString(into));
			}
		}
		System.out.println("final: " + Integer.toBinaryString(into));
		return into;
	}
}
