package bitwise;

import static org.junit.Assert.*;

import java.util.BitSet;

import org.junit.Test;

public class BitSetFindDuplicates {

	@Test
	public void test(){
		assertTrue(6 == findFirstDuplicate(new int[]{1,2,3,4,5,6,6}, 6));
		assertFalse(5 == findFirstDuplicate(new int[]{1,2,3,4,5,6,6}, 6));
		
		assertTrue(4 == findFirstDuplicate(new int[]{1,2,3,4,4,5,6,6}, 6));
	}
	
	public static class BitSet{
		int[] bitfield;
		public BitSet(int size){
			bitfield = new int[size / 32 +1]; //32 bits in an int;
		}
		public boolean get(int pos){
			int intNo = pos / 32;
			int bitNo = pos % 32;
			return (bitfield[intNo] & 1 << bitNo) !=0;
		}
		public void set(int pos){
			int intNo = pos / 32;
			int bitNo = pos % 32;
			bitfield[intNo] |= 1 << bitNo;
		}
	}
	
	public int findFirstDuplicate(int[] source, int maxValue){
		BitSet bs = new BitSet(maxValue+1); // say zero
		for(int n : source){
			if (bs.get(n)){
				return n;
			}else{
				bs.set(n);
			}
		}
		return -1;
	}
	
}
