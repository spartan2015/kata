package hackerRank.sorting;

import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int V = in.nextInt();
		int n = in.nextInt();
		
		int index = 0;
		while(index < n){
			int i = in.nextInt();
			if (i == V){
				break;
			}
			index++;
		}
		System.out.println(index);
	}
}
