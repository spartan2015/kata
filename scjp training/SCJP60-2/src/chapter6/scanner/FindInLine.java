package chapter6.scanner;

import java.util.Scanner;
import java.util.regex.Pattern;

public class FindInLine {

	
	public static void main(String[] args) {
	
		
		Pattern pattern = Pattern.compile("[a-f]");
		
		Scanner scanner = new Scanner(System.in);
		
		String token = null;
		do{
			System.out.println(token = scanner.findInLine(pattern));
		}while(token != null);
	}

}
