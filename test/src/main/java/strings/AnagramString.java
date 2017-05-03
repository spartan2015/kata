package strings;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class AnagramString {

	@Test
	public void test() {
		assertTrue(anagram("silent", "listen"));
		assertFalse(anagram("silent", "listex"));
	}

	private boolean anagram(String string1, String string2) {
		if (string1.length() != string2.length())
			return false;
		char[] first = string1.toCharArray();
		Arrays.sort(first);
		char[] second = string2.toCharArray();
		Arrays.sort(second);
		for (int i = 0; i < first.length; i++) {
			if (first[i] != second[i]) {
				return false;
			}
		}
		return true;
	}

}
