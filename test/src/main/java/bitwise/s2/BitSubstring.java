package bitwise.s2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BitSubstring {

	@Test
	public void test(){
		assertEquals(0b1001011, mask(0b1000101, 0b101, 1 ,3));
		assertEquals(0b1011011, mask(0b1000101, 0b1101, 1 ,4));
	}

	private int mask(int n, int m, int i, int j) {
		n = clearBits(n, i,j);
		return n | m << i;
	}

	private int clearBits(int n, int i, int j) {
		int max = ~0;
		int head = max << j+1;
		int tail = 1 << i-1;
		return n & head | tail;
	}
	
}
