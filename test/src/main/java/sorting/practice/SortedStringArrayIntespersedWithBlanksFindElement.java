package sorting.practice;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortedStringArrayIntespersedWithBlanksFindElement {
	@Test
	public void test() {
		assertEquals(Integer.valueOf(2), Integer.valueOf(find("a",new String[]{"","","a","","b","","","c"})));
		assertEquals(Integer.valueOf(7), Integer.valueOf(find("c",new String[]{"","","a","","b","","","c"})));
		assertEquals(Integer.valueOf(4), Integer.valueOf(find("b",new String[]{"","","a","","b","","","c"})));
	}

	private int find(String string, String[] strings) {
		return find(string,strings,0,strings.length-1);
	}

	private int find(String string, String[] strings, int start, int end) {
		if (start > end) return -1;
		int mid = findMid(strings, start,end);
		if (string.compareTo(strings[mid]) == 0){
			return mid;
		}
		else if (string.compareTo(strings[mid]) < 0){
			return find(string,strings, start, mid-1);
		}else{
			return find(string,strings, mid+1, end);
		}
	}

	private int findMid(String[] strings, int start, int end) {
		int mid = (start+end)/2;
		while(strings[mid].length()==0)
			mid++;
		return mid;
	}
}
