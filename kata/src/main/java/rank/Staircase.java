package hackerRank;

import java.util.Scanner;

public class Staircase {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int spacesIndex = n-1;
		int hashsesIndex = 1;
		for(int row = 0; row < n; row++){
			for(int spaces = 0; spaces < spacesIndex; spaces++){
				System.out.print(" ");
			}
			spacesIndex--;
			for(int i = 0; i < hashsesIndex ; i++){
				System.out.print("#");
			}
			hashsesIndex++;
			System.out.println();
		}
	}
}
