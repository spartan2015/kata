package sorting.solving;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class SortByAnagrams {

	@Test
	public void test() {
		// ana nan - da ad
		
		List<String> stringList = Arrays.asList("ana","naa","nai","ad","da","ax","xa","abcd","bacd");
		//Collections.sort(stringList, SortByAnagrams::compare); // this worked the same - also more efficient - no sort of diff length array
		
		Collections.sort(stringList, SortByAnagrams::compareAnagrams);
		System.out.println(stringList);
	}

	public static int compareAnagrams(String string1, String string2) {
		char[] str1Chars = string1.toCharArray();
		Arrays.sort(str1Chars);
		
		char[] str2Chars = string2.toCharArray();
		Arrays.sort(str2Chars);
		
		return new String(str1Chars).compareTo(new String(str2Chars));
	}
	public static int compare(String string1, String string2) {
		int diff = string1.length() - string2.length();
		if (diff != 0) {
			return diff;
		} else {
			if (anagram(string1, string2)) {
				return -1;
			} else {
				return string1.compareTo(string2);
			}
		}
	}

	public static boolean anagram(String string1, String string2) {
		char[] str1 = string1.toCharArray();
		Arrays.sort(str1);
		char[] str2 = string2.toCharArray();
		Arrays.sort(str2);
		for(int i = 0; i< str1.length; i++){
			if (str1[i]!=str2[i]){
				return false;
			}
		} 
		return true;
	}

}
