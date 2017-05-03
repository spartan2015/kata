package hackerRank;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class FunnyString {

	@Test
	public void test(){
		assertEquals("Funny",funny("aczx"));
		assertEquals("Not Funny",funny("bczx"));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();

		for (int i = 0; i < n; i++) {
			String str = in.next();
			System.out.println(funny(str));
		}
	}

	private static String funny(String str) {
		int lastIndex = str.length()-1;
		for (int i = 0; i < str.length()-1; i++) {
			if (Math.abs((int)str.charAt(i) - str.charAt(i+1))!=Math.abs((int)str.charAt(lastIndex-i) - str.charAt(lastIndex-(i+1))) ){
				return "Not Funny";
			}
		}
		return "Funny";
	}
}
