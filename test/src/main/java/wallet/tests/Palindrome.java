package wallet;

import static org.junit.Assert.*;

import org.junit.Test;

public class Palindrome {

	@Test
	public void testTruePalindrom() {

		assertTrue(isPalindrome("a"));
		assertTrue(isPalindrome("madam"));
		assertTrue(isPalindrome("racecar"));
		assertTrue(isPalindrome("aa"));
	}

	@Test
	public void testFalsePalindrom() {
		assertFalse(isPalindrome(""));
		assertFalse(isPalindrome("racecars"));
		assertFalse(isPalindrome("madame"));
		assertFalse(isPalindrome("ab"));
	}


}
