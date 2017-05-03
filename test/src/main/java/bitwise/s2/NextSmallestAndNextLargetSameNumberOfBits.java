package bitwise.s2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * trick is ONCE YOU PASSES A -0 turn next 1 to 0 turn next 0 to 1
 * an reverse
 * 
 * @author vasil
 *
 */
public class NextSmallestAndNextLargetSameNumberOfBits {

	@Test
	public void test(){
		assertEquals(0b11,nextSmallest(0b101));
		assertEquals(0b1,nextSmallest(0b10));
		
		assertEquals(0b1100,nextLargest(0b1010));
		
		assertEquals(0b110,nextLargest(0b101)); // correct

		assertEquals(0b1001,nextLargest(0b110)); //larger than 6 is 9
	}

	/**
	 * from right to left 0 to 32
	 * 
	 * pass first 1 
	 * turn next 0 to 1
	 * turn prev 1 to 0
	 * 
	 * move 1 bits to right
	 * 
	 * @param n
	 * @return
	 */
	private int nextLargest(int n){
		int bitNo = 0;
		int countOnes = 0;
		while(!bitIsOne(n,bitNo)){
			bitNo++;
		}
		while(!bitIsZero(n,bitNo)){
			bitNo++;
			countOnes++;
		}
		n = turnOn(n,bitNo--);
		System.out.println();	
		n = turnOff(n,bitNo--);
		
		int actuallyTurnedOff = 0;
		for(int i = 0; i< countOnes-1;i ++){
			while(!bitIsOne(n,bitNo)){				
				bitNo--;
			}
			n = turnOff(n,bitNo);
			actuallyTurnedOff++;
		}
			
		for(int i = 0; i< actuallyTurnedOff;i ++){
			n = turnOn(n,i);
		}
		return n;
	}
	
	private boolean bitIsOne(int n, int i) {
		return (n & 1 << i) != 0;
	}

	/**
	 * from right to left 0 to 32
	 * 
	 * pass first 0
	 * turnoff next 1
	 * turnon the right 0
	 * 
	 * move bits to left
	 * 
	 * @param n
	 * @return
	 */
	private int nextSmallest(int n) {
		int bitNo =0;
		int countOnes = 0;
		while(!bitIsZero(n,bitNo)) {
			bitNo++;
			countOnes++;
		}
		while(!bitIsOne(n,bitNo)) {
			bitNo++;
		}
		n=turnOff(n,bitNo--);
		n=turnOn(n,bitNo--);
		
		for(int i =0; i< countOnes; i++){
			n=turnOn(n, bitNo--);
		}
		
		while(bitNo>=0){
			n=turnOff(n, bitNo--);
		}
		return n;
	}

	private boolean bitIsZero(int n, int bitNo) {
		return (n & 1 << bitNo) == 0;
	}

	private int turnOff(int n, int i) {
		return n & ~(1 << i);
	}


	private int turnOn(int n, int i) {
		return n | (1 << i);
	}
	
	private int countBits(int n) {
		int count = 1;
		while( (n >>= 1) != 0){
			count++;
		}
		return count;
	} 	
}