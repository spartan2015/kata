package hackerRank;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.Test;

public class MakingAnagrams {
	@Test
	public void t1(){
		assertEquals(Integer.valueOf(4), Integer.valueOf(howManyDoWeDelete("cde", "abc")));
		
		assertEquals(Integer.valueOf(0), Integer.valueOf(howManyDoWeDelete("a", "a")));
		
		assertEquals(Integer.valueOf(0), Integer.valueOf(howManyDoWeDelete("ana", "naa")));
		
		assertEquals(Integer.valueOf(1), Integer.valueOf(howManyDoWeDelete("ax", "a")));
		
		assertEquals(Integer.valueOf(2), Integer.valueOf(howManyDoWeDelete("ax", "ay")));
		
		assertEquals(Integer.valueOf(0), Integer.valueOf(howManyDoWeDelete("aa", "aa")));
		
		assertEquals(Integer.valueOf(3), Integer.valueOf(howManyDoWeDelete("ab", "aab")));
		
		assertEquals(Integer.valueOf(2), Integer.valueOf(howManyDoWeDelete("x", "a")));
		
		assertEquals(Integer.valueOf(0), Integer.valueOf(howManyDoWeDelete("mama", "amam")));
		
		assertEquals(Integer.valueOf(1), Integer.valueOf(howManyDoWeDelete("mama", "amama")));
		// aamm
		// aaamm
	}
	
	@Test
	public void t2(){
	
		assertEquals(Integer.valueOf(1), Integer.valueOf(howManyDoWeDelete("mama", "amama")));
		// aamm
		// aaamm
		assertEquals(Integer.valueOf(2), Integer.valueOf(howManyDoWeDelete("mama", "amamam")));
		
		assertEquals(Integer.valueOf(3), Integer.valueOf(howManyDoWeDelete("mamac", "amamamcc")));
		
		assertEquals(Integer.valueOf(7), Integer.valueOf(howManyDoWeDelete("abcde", "fg")));
		
		assertEquals(Integer.valueOf(6), Integer.valueOf(howManyDoWeDelete("aa", "aaaaaaaa")));
		
		assertEquals(Integer.valueOf(1), Integer.valueOf(howManyDoWeDelete("xxyyzzaa", "xxyyzaa")));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.nextLine();
		String b = in.nextLine();
		
		System.out.println(howManyDoWeDelete(a, b));
	}

	/**
	 * this worked beautifully
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int howManyDoWeDeleteSecond(String a, String b){
		Map<String, Long> countA = countLetters(a);
		Map<String, Long> countB = countLetters(b);
		int common = 0;
		for(Entry<String, Long> e : countA.entrySet()){
			common +=Math.min(e.getValue(), countB.getOrDefault(e.getKey(), 0l));
		}
		return a.length() + b.length() - 2*common;
	}

	private Map<String, Long> countLetters(String a) {
		return Arrays.stream(a.split("")).filter(s->s.length()>0).collect(Collectors.groupingBy(s->s, Collectors.counting()));
	}
	
	private static int howManyDoWeDelete(String a, String b) {
		char[] ca = a.toCharArray();
		Arrays.sort(ca);
		char[] cb = b.toCharArray(); 
		Arrays.sort(cb);
		
		int common = 0;
		if (ca.length < cb.length){
			common = findFirstCommon(ca,cb);
		}else{
			common = findFirstCommon(cb,ca);
		}
		return ca.length + cb.length - 2*common;
	}
	
	static int findFirstCommon(char[] smaller, char[] greater){
		int common = 0;
		int smallerIndex = 0;
		int greaterIndex = -1;;
		for(;smallerIndex < smaller.length; smallerIndex++){
			greaterIndex = findFirst(greater,smaller[smallerIndex]);
			if (greaterIndex >=0){
				break;
			}
		}
		if (smallerIndex == smaller.length){
			return 0;
		}
		
		char prevCommon = 0;
		for(;smallerIndex < smaller.length && greaterIndex < greater.length; smallerIndex++,greaterIndex++){
			
			if (smaller[smallerIndex]==greater[greaterIndex]){
				prevCommon = smaller[smallerIndex];
				common++;
			}else{
				if (greater[greaterIndex] == prevCommon){
					smallerIndex--;
					continue;
				}else{
					break;
				}
			}
			
		}
		return common;
	}

	private static int findFirst(char[] greater, char c) {
		int result = -1;
		for(int i =0; i< greater.length; i++){
			if (greater[i]==c){
				return i;
			}
		}
		return result;
	}
}
