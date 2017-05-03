package bitwise;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUniqueBitWise {

	@Test
	public void test() {
		int theStorageBit = 0;
		for (char c = 'a'; c <= 'z'; c++) {
			byte translated0to122 = (byte) ((int) c - 'a');
			int theBitToCheckAgainst = 1 << translated0to122;
			theStorageBit |= theBitToCheckAgainst;
			int checkBit = theStorageBit & theBitToCheckAgainst;
			System.out.println(translated0to122 + " -> " + String.format("%26s", Integer.toBinaryString(theBitToCheckAgainst))
					+ " -> " + String.format("%26s", Integer.toBinaryString(theStorageBit)) + " -> "
					+ String.format("%26s", Integer.toBinaryString(checkBit)));
		}
	}
	
	@Test
	public void testNoUnique(){
		assertFalse(hasUniqueChars("aba"));
	}
	
	@Test
	public void testUnique(){
		assertTrue(hasUniqueChars("abcefghijklmnoprstuvwxyz"));
	}
	
	public boolean hasUniqueChars(String str){
		int bitStorage = 0;
		for(int i = 0; i < str.length(); i++){
			int checkAgainstBit = 1 << str.charAt(i);
			if ((bitStorage & checkAgainstBit) > 0) return false;
			bitStorage |=checkAgainstBit;
		}
		return true;
	}
}
