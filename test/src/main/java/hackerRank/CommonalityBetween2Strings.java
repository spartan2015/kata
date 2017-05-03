package hackerRank;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class CommonalityBetween2Strings {

	@Test
	public void t(){
		assertEquals("YES",common(new Scanner("a\na")));
		assertEquals("NO",common(new Scanner("a\nb")));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		for(int i =0; i< n; i++){
			System.out.println(common(in));;
		}
		
	}

	private static String common(Scanner in) {
		String a = in.nextLine();
		String b = in.nextLine();
		boolean[] marked = new boolean[26];
		for(char c : a.toCharArray()){
			int pos = c - 97;
			marked[pos]=true;
		}
		
		for(char c : b.toCharArray()){
			int pos = c - 97;
			if (marked[pos]){
				return "YES";
			}
		}
		return "NO";
	}
	
}
