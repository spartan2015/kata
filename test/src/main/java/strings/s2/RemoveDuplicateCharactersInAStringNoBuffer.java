package strings.s2;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class RemoveDuplicateCharactersInAStringNoBuffer {

	@Test
	public void test() {
		assertEquals("abc", removeDuplicateChars("abaac"));
		assertEquals("az", removeDuplicateChars("aaaaz"));
	}

	private String removeDuplicateChars(String string) {
		int lastUnique = 1;
		char[] chars = string.toCharArray();
		for (int i = 1; i < string.length(); i++) {
			if (unique(chars[i], chars, lastUnique)) {
				chars[lastUnique++] = chars[i];
			}
		}
		return new String(Arrays.copyOf(chars, lastUnique));
	}

	private boolean unique(char c, char[] chars, int lastUnique) {
		for (int i = 0; i < lastUnique; i++) {
			if (chars[i] == c) {
				return false;
			}
		}
		return true;
	}

}
