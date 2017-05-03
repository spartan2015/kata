package strings;

import java.util.Arrays;

import org.junit.Test;

public class RemoveDuplitcatesString {

	@Test
	public void test() {
		char[] str = { 'a', 'b', 'a', 'a','a' ,'z','z','y'};
		removeDupes(str);
		System.out.println(Arrays.toString(str));
	}

	private void removeDupes(char[] str) {
		if (str.length == 1)
			return;
		int tail = 1;
		for (int i = 1; i < str.length; i++) {
			int j;
			for (j = 0; j < tail; j++) {
				if (str[i] == str[j]) break;
			}
			if (j == tail){ // NO DUPES, i is brought to tail - tail increments
				str[tail++]=str[i];
			}
		}
		str[tail]=0; // simple tail marker - efficient ops
//		for (int i = tail; i < str.length; i++) { // resets all dupes - not really needed
//			str[i] = 0;
//		}
	}

}
