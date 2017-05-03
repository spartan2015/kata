package bitwise.s2;

import static org.junit.Assert.*;

import org.junit.Test;

public class SwapOddAndEvenBits {

	@Test
	public void test(){
		//System.out.println(Integer.toString(swap(5), 2));
		assertEquals(Integer.valueOf(10),Integer.valueOf(swap(5)));
		assertEquals(Integer.valueOf(1),Integer.valueOf(swap(2)));
	}

	private int swap(int n) {
		return ((n & 0x5555555) << 1) | ((n & 0xaaaaaaa) >> 1);
	}
	
}
