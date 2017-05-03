package strings.s2;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReplaceWithLargerString {

	@Test
	public void test() {
		assertEquals("I%20am%20happy%20at%20fb", replace("I am happy at fb"));
	}

	private String replace(String string) {
		if (string == null){
			return null;
		}
		int countSpaces = counteReplaceChars(string);
		char[] newChars =  new char[string.length() + 2*countSpaces];
		int index = 0;
		for(int i = 0; i < string.length(); i++){
			if (string.charAt(i) == ' '){
				newChars[index++]='%';
				newChars[index++]='2';
				newChars[index++]='0';
			}else{
				newChars[index++]=string.charAt(i);
			}
		}
		return new String(newChars);
	}

	private int counteReplaceChars(String string) {
		int countSpaces = 0;
		for(int i = 0; i < string.length(); i++){
			if (string.charAt(i) == ' '){
				countSpaces++;
			}
		}
		return countSpaces;
	}

}
