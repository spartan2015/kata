package hackerRank;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * 5 passed - only 15 points out of 60
 * 
 * timeout
 * 
 * 
 * 
 * @author vasil
 *
 */
public class CommonChildDynamicProgramming {
	
	@Test
	public void input01() {
		assertEquals(Integer.valueOf(15),
				Integer.valueOf(timed(() -> maxFromString("WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS",
														  "FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC"))));
	}
	
	@Test
	public void test(){
		assertEquals(Integer.valueOf(3),Integer.valueOf(maxFromString("ABCD", "ABDC")));
	}
	
	@Test
	public void test2(){
		assertEquals(Integer.valueOf(3),Integer.valueOf(maxFromString("SHINCHAN", "NOHARAAA")));
	}
	
	@Test
	public void test3(){
		assertEquals(Integer.valueOf(2),Integer.valueOf(maxFromString("ABCDEF", "FBDAMN")));
	}
	
	
	@Test
	public void t2(){
		assertEquals(Integer.valueOf(24),Integer.valueOf(timed(()->maxFromString("ABCDEFGH", "ABCDEFGHIABCDEFGHI"))));
	}
	
	public static <T> T timed(Callable<T> task){
		long start = System.currentTimeMillis();
		T result;
		try {
			result = task.call();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println("Duration: " + (System.currentTimeMillis()-start));
		return result;
	}
	
	

	static class LastMatch{
		int sIndex;
		int bIndex;
		LastMatch(int sIndex,int bIndex ){
			this.sIndex = sIndex;
			this.bIndex = bIndex;
		}
	}
	
	static class IncremenetalHash{
		int prevHash = 0;
		int hash = 0;
		List<Character> list = new ArrayList<>();
		void add(Character a){
			//prevHash = hash;
			//hash += 13 + 7 * a.charValue();
			list.add(a);
		}
		IncremenetalHash(){}
		IncremenetalHash(IncremenetalHash other){
			//this.hash = other.hash;
			list.addAll(other.list);
		}
		public String toString(){
			return list.toString();
		}
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String aString = in.next();
		String bString = in.next();
		
		System.out.println(maxFromString(aString, bString));
	}
	
	private static int maxFromString(String aString, String bString) {
		Set<Character> aSet = Arrays.stream(aString.split("")).filter(s->s.length()!=0).map(s->s.charAt(0)).collect(Collectors.toSet());
		Set<Character> bSet = Arrays.stream(bString.split("")).filter(s->s.length()!=0).map(s->s.charAt(0)).collect(Collectors.toSet());
		
		aSet.retainAll(bSet);
		
		char[] a = retainCommon(aString, aSet);
		char[] b = retainCommon(bString, aSet);
		
		return max(a, 0,new IncremenetalHash(), b, new HashMap(), 0, 0);
	}
	
	private static int max(char[] ch, int index, IncremenetalHash orig, char[] bString, Map<Integer, LastMatch> lastKnown, int sIndex, int bIndex) {
		if (index > ch.length-1) return 0;
		int max = 0;
		for(int i = index; i < ch.length; i++){
			IncremenetalHash option = new IncremenetalHash(orig);
			option.add(ch[i]);
			//System.out.println("option " + option); 
			// speed up idea - don't check options below current max - only bigger
			// skipping ones is ok since we already retain common
			int[] lastCoord = null;
			if ((lastCoord=possible(option,bString, lastKnown, sIndex, bIndex))!=null){
				//System.out.println("option " + option); 
				max = Math.max(max, 1+max(ch, i+1, option, bString, lastKnown, lastCoord[0], lastCoord[1]));
				if (max == ch.length-index) return max; //strange but beautiful
			}			
		}
		return max;
	}

	static final LastMatch def = new LastMatch(0, 0);
	
	private static int[] possible(IncremenetalHash sequence,char[] bString, Map<Integer,LastMatch> lastKnown, int sIndex, int bIndex) {
		//LastMatch last = lastKnown.getOrDefault(sequence.prevHash, def);
		//System.out.println("sequence " + sequence + " prevHash " + sequence.prevHash + ", last" + last.sIndex + "- " + last.bIndex);
		//int sIndex = 0;//last.sIndex;
		//int bIndex = 0; //last.bIndex;
		for(; bIndex < bString.length && sIndex < sequence.list.size(); bIndex++){
			//System.out.println(bString[bIndex] + " == " + sequence.list.get(sIndex) + " option: " + sequence.list);
			if (bString[bIndex] == sequence.list.get(sIndex)){
				//System.out.println("sequence " + sequence + " hash " + sequence.hash + ", last" + sIndex + "- " + bIndex);
				//lastKnown.put(sequence.hash, new LastMatch(sIndex+1, bIndex+1));
				sIndex++;
			}
			if (sIndex == sequence.list.size()){
				//System.out.println("Valid: " + sequence);
				return new int[]{sIndex,bIndex+1};
			}
		}
		return null;
	}

	private static char[] retainCommon(String aString, Set<Character> aSet) {
		StringBuilder s1Sb = new StringBuilder();
		for(int i =0; i < aString.length(); i++){
			char ch = aString.charAt(i);
			if (aSet.contains(ch)){
				s1Sb.append(ch);
			}
		}
		char[] chars = new char[s1Sb.length()];
		s1Sb.getChars(0, s1Sb.length(), chars, 0);;
		return chars;
	}
}
