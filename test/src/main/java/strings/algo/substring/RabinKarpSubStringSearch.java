package strings.algo.substring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RabinKarpSubStringSearch {

	@Test
	public void test1() {
		assertEquals(Integer.valueOf(0), Integer.valueOf(search("elefant", "elefant")));
	}

	@Test
	public void test2() {
		assertEquals(Integer.valueOf(3), Integer.valueOf(search("elefant", "123elefant")));

	}

	@Test
	public void test3() {
		assertEquals(Integer.valueOf(9), Integer.valueOf(search("elefant", "123elefanelefant")));
	}

	@Test
	public void test4() {
		assertEquals(Integer.valueOf(15), Integer.valueOf(search("needle", "findinahaystackneedle")));
	}

	/**
	 * this is the idea aprox - which is worse than brute force in this form
	 * 
	 * Rabin-Karp computes the hash efficiently - this is their key incredient
	 * 
	 * @param pattern
	 * @param text
	 * @return
	 */
	private int search(String pattern, String text) {
		int Q = 997;
		int R = 256;
		int M = pattern.length();
		int N = text.length();

		// compute removal of leading char
		long RM = 1;
		for (int i = 1; i < M; i++) {
			RM = (R * RM) % Q;
		}

		long patternHash = hash(pattern, M, Q, R);

		// match at the beginning
		long textHash = hash(text, M, Q, R);
		if (patternHash == textHash) {
			if (check(pattern, text, 0, M)) {
				return 0;
			}
		}
		// check one by one
		for (int i = M; i < N ; i++) {
			textHash = ((textHash + Q - RM * text.charAt(i - M)) % Q) % Q;
			textHash = (textHash * R + text.charAt(i)) % Q;
			
			if (textHash == patternHash && check(pattern, text, i, M)) {
				return i - M + 1;
			}
		}
		return -1;
	}

	private boolean check(String pattern, String text, int indexInText, int M) {
		for (int i = 0; i < M; i++) {
			if (pattern.charAt(i) != text.charAt(indexInText + i)) {
				return false;
			}
		}
		return true;
	}

	private long hash(String text, int M, int Q, int R) {
		long h = 0;
		for (int i = 0; i < M; i++) {
			h = (R * h + text.charAt(i)) % Q;
		}
		return h;
	}
}
