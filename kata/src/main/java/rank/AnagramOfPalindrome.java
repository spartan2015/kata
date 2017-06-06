package hackerRank;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.Test;

public class AnagramOfPalindrome {

	@Test
	public void t(){
		assertEquals("YES", isAnagramAndPalindrom("cac"));
		assertEquals("YES", isAnagramAndPalindrom("a"));
		assertEquals("NO", isAnagramAndPalindrom("ab"));
		assertEquals("YES", isAnagramAndPalindrom("aba"));
		assertEquals("YES", isAnagramAndPalindrom("racecar"));
		assertEquals("NO", isAnagramAndPalindrom("car"));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.nextLine();

		System.out.println(isAnagramAndPalindrom(a));
	}

	private static String isAnagramAndPalindrom(String a) {
		if (a.length() == 1) return "YES";
		
		Map<String, Long> count = countLetters(a);
		int single = 0;
		int pairs = 0;
		for(Entry<String, Long> entry : count.entrySet()){
			if (entry.getValue() % 2 != 0){
				single++;
			}else{
				pairs++;
			}
		}
		if (a.length() % 2 == 0 && single ==0){
			return "YES";
		}else if ((a.length() % 2 == 1 && single == 1 )){
			return "YES";
		}else{
			return "NO";
		}
			
	}

	private static Map<String, Long>  countLetters(String a) {
		return Arrays.stream(a.split("")).filter(s->s.length()>0).collect(Collectors.groupingBy(s->s, Collectors.counting()));
	}
}
