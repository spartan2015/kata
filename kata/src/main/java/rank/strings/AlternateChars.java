package hackerRank.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AlternateChars {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();

		for (int i = 0; i < n; i++) {
			String str = in.next();
			System.out.println(howMany(str));
		}
	}

	private static int howMany(String str) {
		int count = 0;
		char prevChar = str.charAt(0);
		for(int i =1; i< str.length(); i++){
			if (str.charAt(i)== prevChar){
				count++;
			}else{
				prevChar = str.charAt(i);
			}
		}
		return count;
	}
}
