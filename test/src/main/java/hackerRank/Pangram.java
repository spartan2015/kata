package hackerRank;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class Pangram {
	@Test
	public void test(){
		assertEquals("pangram", pangram("We promptly judged antique ivory buckles for the next prize"));
		assertEquals("pangram", pangram("The quick brown fox jumps over the lazy dog"));
		assertEquals("not pangram", pangram("We promptly judged antique ivory buckles for the prize"));
	}
	
	@Test
	public void t(){
		System.out.println(pangram("We promptly judged antique ivory buckles for the next prize"));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		System.out.println(pangram(s));
	}

	private static String pangram(String s) {
		s = s.toLowerCase();
		boolean[] marked = new boolean[26];
		int count = 0;
		for(int i =0; i< s.length(); i++){
			char c = s.charAt(i);
			int base = c-97;
			if (base >=0 && base <= 25){
				if (!marked[base]){
					count++;
					marked[base]=true;
				}
			}
		}
		if (count == 26){
			return "pangram";
		}else{
			return "not pangram";
		}
	}
}
