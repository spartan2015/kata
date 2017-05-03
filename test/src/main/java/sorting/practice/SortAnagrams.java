package sorting.practice;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class SortAnagrams {

	@Test
	public void sortAnagramTest(){
		assertEquals(new String[]{"ana", "naa", "ab", "ba", "nax"}, sort(new String[]{"ana", "nax","ab","naa", "ba"}));
	}

	private String[] sort(String[] strings) {
		Arrays.sort(strings, this::compare);
		System.out.println(Arrays.toString(strings));
		return strings;
	}

	private int compare(String str1,String str2) {
		char[] c1 = str1.toCharArray();
		Arrays.sort(c1);
		char[] c2 = str2.toCharArray();
		Arrays.sort(c2);
		return new String(c1).compareTo(new String(c2));
	}
}
