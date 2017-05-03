package strings.s2;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class Anagrams {

	@Test
	public void test() {
		assertTrue(areAnagrams("baa", "aba"));
		assertTrue(areAnagrams("ana", "aan"));
		assertFalse(areAnagrams("ana1", "aan"));
	}

	private boolean areAnagrams(String string, String string2) {
		char[] first = string.toCharArray();
		Arrays.sort(first);
		char[] second = string2.toCharArray();
		Arrays.sort(second);
		return Arrays.equals(first, second);
	}

}
