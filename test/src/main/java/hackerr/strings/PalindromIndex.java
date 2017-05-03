package hackerRank.strings;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.Test;

public class PalindromIndex {
	@Test
	public void t1() {
		assertEquals(Long.valueOf(3), Long.valueOf(howMany("aaab")));
		assertEquals(Long.valueOf(0), Long.valueOf(howMany("baa")));
		assertEquals(Long.valueOf(-1), Long.valueOf(howMany("aaa")));
		assertEquals(Long.valueOf(-1), Long.valueOf(howMany("abcba")));
		assertEquals(Long.valueOf(0), Long.valueOf(howMany("bcbc")));
		assertEquals(Long.valueOf(-1), Long.valueOf(howMany("a")));
		
	}

	@Test
	public void t2() {
		assertEquals(Long.valueOf(3), Long.valueOf(howMany("racxecar")));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println(howMany(in.next()));
		}

	}

	private static int howMany(String str) {
		return howMany(str,0,str.length()-1);
	}

	private static int howMany(String str, int start, int end) {
		int count = -1;
		for (int i = start, j =0; i < (start+end+1)/2; i++, j++) {
			int aIndex = i;
			char a = str.charAt(aIndex);
			
			int bIndex = end-j;
			char b = str.charAt(bIndex);
			if (a != b) {
				if (-1 == howMany(str,i+1, bIndex)){
					return aIndex;
				}else{
					return bIndex;
				}
			}
		}
		return count;
	}
}
