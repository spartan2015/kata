package strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniqueLetters {

	@Test
	public void test(){
		
		assertFalse(hasUniqueLetters("abcdefghijklmnoa"));
	
		assertTrue(hasUniqueLetters("abc"));
		
	}

	private boolean hasUniqueLetters(String string) {
		int bitfield =0 ; // 32 bits tracking 26 letters
		for(char c : string.toLowerCase().toCharArray()){
			int charNo = c-97;
			if ((bitfield & 1 << charNo)!=0){
				return false;
			}
			bitfield |= 1<< charNo;
		}
		return true;
	}

}
