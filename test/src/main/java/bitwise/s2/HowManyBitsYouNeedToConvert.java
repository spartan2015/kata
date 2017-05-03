package bitwise.s2;

import static org.junit.Assert.*;

import org.junit.Test;

public class HowManyBitsYouNeedToConvert {

	@Test
	public void test() {
		assertEquals(Integer.valueOf(1), Integer.valueOf(howMany(0b0, 0b1)));
		assertEquals(Integer.valueOf(2), Integer.valueOf(howMany(0b01, 0b10)));
		assertEquals(Integer.valueOf(1), Integer.valueOf(howMany(0b10, 0b11)));
	}

	/**
	 * actually look at the bit pattern
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	private int howMany(int i, int j) {
		int count = 0;
		while (i > 0 | j > 0) {
			if (bitNo(i, 0) != bitNo(j, 0)) {
				count++;
			}
			i >>= 1;
			j >>= 1;
		}

		return count;
	}

	private boolean bitNo(int n, int bitNo) {
		return (n & 1 << bitNo) != 0;
	}

}
