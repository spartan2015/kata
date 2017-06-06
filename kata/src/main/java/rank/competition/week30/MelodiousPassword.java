package hackerRank.competition.week30;

import java.util.Scanner;

import org.junit.Test;

public class MelodiousPassword {
	
	@Test
	public void gen1(){
		generatedPassword(6);
	}

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		generatedPassword(n);
		
	}

	private static void generatedPassword(int n) {
		char[] consonants = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','z'};
		char[] vowels = {'a','e','i','o','u'};
		
		if (n == 1){
			print(consonants);
			print(vowels);
		}else{
			dynamic(consonants, vowels,new char[n], 0, n);
			dynamic(vowels, consonants,new char[n], 0, n);
		}
	}

	private static void dynamic(char[] consonants, char[] vowels, char[] prevComb, int i, int max) {
		if (i == max){
			printInOneLine(prevComb);
			return;
		}

		char[] chooseFrom = i % 2 == 0 ? consonants : vowels; 
		for(char c : chooseFrom){
			char[] option = prevComb.clone();
			option[i] = c;
			dynamic(consonants, vowels, option, i+1, max);
		}
		
	}

	private static void printInOneLine(char[] ch) {
		for(char c : ch){
			System.out.print(c);
		}
		System.out.println();
	}
	
	private static void print(char[] ch) {
		for(char c : ch){
			System.out.println(c);
		}
	}
}
