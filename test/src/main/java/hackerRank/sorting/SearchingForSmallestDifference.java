package hackerRank.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SearchingForSmallestDifference {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] vector = readArr(in, n);
		Arrays.sort(vector);
		
		int minDiff = Integer.MAX_VALUE;
		List<int[]> minPairs = new ArrayList<>();
		
		for(int i = 1; i < vector.length; i++){
			int diff = vector[i]-vector[i-1];
			if (diff < minDiff){
				minDiff = diff;
				minPairs.add(new int[]{vector[i-1],vector[i]});
				minPairs.clear();
			}else if (diff == minDiff){
				minPairs.add(new int[]{vector[i-1],vector[i]});
			}
		}
		
		for(int[] pair : minPairs){
			for(int i : pair){
				System.out.print(i + " ");
			}
		}
	}
	
	public static int[] readArr(Scanner in, int n) {
		int[] ar = new int[n];
		for (int i = 0; n - i != 0; i++) {
			ar[i] = in.nextInt();
		}
		return ar;
	}
}
