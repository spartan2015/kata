package hackerRank.implementation;

import java.util.Scanner;

public class EqualizetheArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] marked = new int[100];
		
		int count = 0;
		int max = 0;
		for (int a_i = 0; a_i < n; a_i++) {
			int nx= in.nextInt();
			marked[nx-1]++;
			if (marked[nx-1] > max){
				max =marked[nx-1];
			}
		}
		
		System.out.println(n-max);
	}
}
