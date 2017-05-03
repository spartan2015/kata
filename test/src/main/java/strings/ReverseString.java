package strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseString {

	@Test
	public void test(){
		assertEquals("edcba", reverseString("abcde"));
		assertEquals("ba", reverseString("ab"));
		assertEquals("cba", reverseString("abc"));
		assertEquals("", reverseString(""));
	}

	private String reverseString(String string) {
		char[] ch = string.toCharArray();
		for(int i = 0; i < ch.length /2 ; i++){
			int endPos = ch.length-1-i;
			swap(ch, i, endPos);
		}
		return new String(ch);
	}

	private void swap(char[] ch, int i, int endPos) {
		char tmp = ch[i];
		ch[i] = ch[endPos];
		ch[ch.length-1-i]=tmp;
	}
	
}
