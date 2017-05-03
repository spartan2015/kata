package bitwise;

import static org.junit.Assert.*;

import org.junit.Test;

public class NextLargestSameNumberOf1Bits {

	@Test
	public void test() {

		assertTrue(2 == nextLargestSameNumberOf1BitsBruteForce(1));

		assertTrue(5 == nextLargestSameNumberOf1BitsBruteForce(3));

		assertTrue(11 == nextLargestSameNumberOf1BitsBruteForce(7));

		assertTrue(2 == nextLargestSameNumberOf1BitsSmart(1));

		assertTrue(5 == nextLargestSameNumberOf1BitsSmart(3));

		assertTrue(11 == nextLargestSameNumberOf1BitsSmart(7));

	}

	@Test
	public void findNextSmallestSameNumberOfBits() {
		assertTrue(1 == nextSmallesNumberSameNumberOf1BitsSmart(2));

		assertTrue(3 == nextSmallesNumberSameNumberOf1BitsSmart(5));

		assertTrue(7 == nextSmallesNumberSameNumberOf1BitsSmart(11));

	}

	@Test
	public void findFirst0ToLeft() {
		assertTrue(2 == findFirstZeroToLeft(3));
	}

	public int nextLargestSameNumberOf1BitsSmart(int n) { 
		int pos = findFirstZeroToLeft(n);
		n = turnOnBit(n, pos);
		pos = findFirstOneToRight(n, pos);
		n = turnOffBit(n, pos);
		return n;
	}

	/**
	 * 11 cannot go lower while keeping the same number of 1 bits - we do not account for this with this algo 
	 * 
	 * @param n
	 * @return
	 */
	public int nextSmallesNumberSameNumberOf1BitsSmart(int n) {
		int pos = countBits(n)-1;
		n = turnOffBit(n, pos);
		pos = findFirstZeroToRight(n, pos);
		n = turnOnBit(n, pos);
		return n;
	}

	private int turnOnBit(int n, int pos) {
		return n | 1 << pos;
	}

	private int turnOffBit(int n, int pos) {
		return n & ~(1 << pos);
	}

	private int findFirstOneToRight(int n, int pos) {
		pos--;
		while (bitIsOff(n, pos)) {
			pos--;
		}
		return pos;
	}

	private int findFirstZeroToRight(int n, int pos) {
		pos--;
		while (bitIsOn(n, pos)) {
			pos--;
		}
		return pos;
	}

	private int countBits(int n) {
		int count = 0;
		while( n > 0){
			n /=2;
			count++;
		}
		return count;
	}

	private int findFirstZeroToLeft(int n) {
		int pos = 0;
		while (bitIsOn(n, pos)) {
			pos++;
		}
		return pos;
	}

	private boolean bitIsOn(int n, int j) {
		return !bitIsOff(n, j);
	}

	private boolean bitIsOff(int n, int j) {
		return (n & (1 << j)) == 0;
	}

	public int nextLargestSameNumberOf1BitsBruteForce(int i) {
		int count1Bits = count1Bits(i);
		while (count1Bits(++i) != count1Bits);
		return i;
	}

	public int count1Bits(int i) {
		int count1Bits = 0;
		while (i > 0) {
			if (i % 2 == 1)
				count1Bits++;
			i /= 2;
		}
		return count1Bits;
	}
	
	public int count1BitsBetter(int i) {
		int count = 0;
		while(i!=0){
			count += i & 1;
			i >>= 1;
		}
		return count;
	}
}