package hackerRank.strings;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class LoveMisteryStringPalindromReduction {
	
	@Test
	public void t1(){
		assertEquals(Long.valueOf(2), Long.valueOf(howMany("abc")));
		assertEquals(Long.valueOf(0), Long.valueOf(howMany("abcba")));
		assertEquals(Long.valueOf(4), Long.valueOf(howMany("abcd")));
		assertEquals(Long.valueOf(2), Long.valueOf(howMany("cba")));	
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println(howMany(in.next()));
		}

	}

	private static int howMany(String str) {
		int count = 0;
		for (int i = 0; i < str.length() / 2; i++) {
			char a = str.charAt(i);
			int b = str.charAt(str.length() - 1 - i);
			if (a != b) {
				char max = (char) Math.max(a, b);
				char min = (char) Math.min(a, b);
				while (max != 'a' && max != min){
					max--;
					count++;
				}
			}
		}
		return count;
	}
}
