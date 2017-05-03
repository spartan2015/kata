package bitwise;

import static org.junit.Assert.*;

import org.junit.Test;

public class SwaptOddAndEvenBits {

	@Test
	public void test(){
		assertTrue(swap(2)==1);
	}

	private int swap(int i) {
		return ((i & 0xaaaaaaaa) >> 1) | ((i & 0x55555555) << 1);
	}
	
}
