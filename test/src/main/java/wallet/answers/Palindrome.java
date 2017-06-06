package wallet.answers;

import static org.junit.Assert.*;

import org.junit.Test;
/*
Write an efficient algorithm to check if a string is a palindrome. A string is a palindrome if the string matches the reverse of string.
Example: 1221 is a palindrome but not 1121.
*/
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

	/**
	 * linear complexity - O(N/2)
	 * @param s
	 * @return
	 */
	private boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		for (int i = 0; i < s.length() / 2; i++) { //linear complexity - O(N/2)
			char a = s.charAt(i);
			char b = s.charAt(s.length() - 1 - i);
			if (a != b) {
				return false;
			}
		}
		return true;
	}

}
