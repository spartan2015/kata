package parsing;

import java.util.Scanner;

public class ScannerExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner("aba");
		
		String token = null;
		do{
			token = sc.findInLine("a");
			System.out.println("=" + token + "=");
		}while(token != null);

	}

}
