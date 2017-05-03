package parsingtext;

import java.util.Scanner;

public class ScannerClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// you could use Scanner instead of Pattern
		finder("abaaba",".*a");
	}
	
	static void finder(String s, String pattern){
		Scanner sc = new Scanner(s);
		String found = null;
		while((found = sc.findInLine(pattern))!=null){
			System.out.println("Found: " + found);
		}
	}

}
