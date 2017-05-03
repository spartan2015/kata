package hackerRank.strings;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.Test;

public class Anagrams {

	@Test
	public void t1() {
		assertEquals(Long.valueOf(3), Long.valueOf(howMany("aaabbb")));
		assertEquals(Long.valueOf(1), Long.valueOf(howMany("ab")));
		assertEquals(Long.valueOf(2), Long.valueOf(howMany("mnop")));
		assertEquals(Long.valueOf(0), Long.valueOf(howMany("xyyx")));
		
		assertEquals(Long.valueOf(-1), Long.valueOf(howMany("abc")));
	}
	

	@Test
	public void t12(){
		assertEquals(Long.valueOf(1), Long.valueOf(howMany("xaxbbbxx")));
	}


	@Test
	public void t3() {
		assertEquals(Long.valueOf(13), Long.valueOf(howMany("xtnipeqhxvafqaggqoanvwkmthtfirwhmjrbphlmeluvoa")));

	}
	
	@Test
	public void t4() {
		assertEquals(Long.valueOf(13), Long.valueOf(howMany("vxxzsqjqsnibgydzlyynqcrayvwjurfsqfrivayopgrxewwruvemzy")));

	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println(howMany(in.next()));
		}
	}

	private static int howMany(String str) {

		if (str.length() % 2 != 0) {
			return -1;
		}
		int half = str.length() / 2;

		Map<String, Long> s2 = toMapCount(str.substring(0, half));

		Map<String, Long> s1 = toMapCount(str.substring(half, str.length()));
		
		int count = 0;
		for(Entry<String,Long> s1Entry : s1.entrySet()){ // change - means we can 1 chars - changed so 
			if (s2.get(s1Entry.getKey())==null){
				count+=s1Entry.getValue();
			}else{
				count+= Math.abs( s1Entry.getValue() - s2.get(s1Entry.getKey()).longValue());
			}
		}
		
		for(Entry<String,Long> s2Entry : s2.entrySet()){ // change - means we can 1 chars - changed so 
			if (s1.get(s2Entry.getKey())==null){
				count+=s2Entry.getValue();
			}
		}
		
		return count/2;
	}

	private static Map<String, Long> toMapCount(String s) {
		Map<String, Long> map = Arrays.stream(s.split("")).filter(c -> c.length() == 1)
				.collect(Collectors.groupingBy(a -> a, Collectors.counting()));
		return map;
	}
}
