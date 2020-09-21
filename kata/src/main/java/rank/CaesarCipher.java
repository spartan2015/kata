package rank;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class CaesarCipher {
	
	@Test
	public void t(){
		assertEquals("b-b", encrypt("a-a", 1));
		assertEquals("a-a", encrypt("z-z", 1));
		assertEquals("b-b1", encrypt("a-a1", 1));
		assertEquals("b-b1", encrypt("a-a1", 1));
		assertEquals("a", encrypt("a", 26));
	}
	
	@Test
	public void t2(){
		assertEquals("a", encrypt("a", 5*26));
	}
	
	@Test
	public void testED(){
		assertEquals("vasile",encrypt(encrypt("vasile", -10),10));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		String string = in.nextLine();
		int k = in.nextInt();
		
		System.out.println(encrypt(string,k));
	}

	private static String encrypt(String string, int k) {
		StringBuilder sb = new StringBuilder();
		for(int i =0; i < string.length();i++){
			sb.append(encrypt(string.charAt(i),k));
		}
		return sb.toString();
	}

	private static char encrypt(char c, int k) {
		return rotateLetterInAlpabet(c,k);
	}

	private static char rotateLetterInAlpabet(char c, int k) {
		int rotation = c+k%26;
		if (isUpperCaseAZ(c)){
			return (char)rotateWithingBoundaries(rotation,65,90);
		}else if (isSmallLetterAZ(c)){
			return (char)rotateWithingBoundaries(rotation,97,122);
		}
		return c;
	}

	private static int rotateWithingBoundaries(int rotation, int lower, int upper) {
		if (rotation < lower){
			return rotation+26;
		}else if (rotation > upper){
			return rotation-26;
		}else{
			return rotation;
		}
	}

	private static boolean isUpperCaseAZ(char c) {
		return c >= 65 && c <=90;
	}

	private static boolean isSmallLetterAZ(char c) {
		return c >=97 && c <=97+25;
	}
}
