package strings.algo.substring;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

import org.junit.Test;

/**
 * Worst case: N*M 
 * N - length of text M - length of substring we search for
 * 
 * @author vasil
 *
 */
public class BruteForce {

	@Test
	public void test() {
		assertEquals(Integer.valueOf(2), Integer.valueOf(search("c", "abc")));
		assertEquals(Integer.valueOf(1), Integer.valueOf(search("bc", "abc")));
		assertEquals(Integer.valueOf(0), Integer.valueOf(search("abc", "abc")));
	}

	@Test
	public void testVariant() {
		assertEquals(Integer.valueOf(2), Integer.valueOf(searchVariant("c", "abc")));
		assertEquals(Integer.valueOf(1), Integer.valueOf(searchVariant("bc", "abc")));
		assertEquals(Integer.valueOf(0), Integer.valueOf(searchVariant("abc", "abc")));
	}
	
	private int search(String pattern, String text) {
		for (int i = 0; i <= text.length() - pattern.length(); i++) {
			int j = 0;
			for (j = 0; j < pattern.length(); j++) {
				if (text.charAt(i + j) != pattern.charAt(j)) {
					break;
				}
			}
			if (j == pattern.length()) {
				return i;
			}
		}
		return -1;
	}

	private int searchVariant(String pattern, String text) {
		int M = pattern.length();
		int N = text.length();
		int i, j;
		for (i = 0, j = 0; i < N && j < M; i++) {
			if (pattern.charAt(j) != text.charAt(i)) {
				i -= j;
				j=0;
				continue;
			}
			j++;
		}
		if (j == M){
			return i-j;
		}
		
		return -1;
	}
}
