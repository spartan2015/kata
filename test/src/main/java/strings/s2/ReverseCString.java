package strings.s2;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseCString {

	@Test
	public void test(){
		assertEquals("abcd", reverse("dcba"));
		assertEquals("cba", reverse("abc"));
	}

	private String reverse(String string) {
		if (string == null || string.length()==0) return string;
		char[] chars = string.toCharArray();
		for(int i =0; i< chars.length/2;i++){
			swap(chars,i,chars.length-1-i);
		}
		return new String(chars);
	}

	private void swap(char[] chars, int i, int j) {
		char tmp = chars[i];
		chars[i]=chars[j];
		chars[j]=tmp;
	}
}
