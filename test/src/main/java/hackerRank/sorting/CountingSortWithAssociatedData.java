package hackerRank.sorting;

import java.util.Scanner;

public class CountingSortWithAssociatedData {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		WordFrequency[] ar = readArr(in, n);

		int[] countSort = new int[100];
		for (WordFrequency w : ar) {
			countSort[w.frequency]++;
		}

		int count = 0;
		for (int i = 0; i < countSort.length; i++) {
			if (count!=0){
			System.out.printf("%d ",count);
			}
			count+=countSort[i];
		}
		System.out.printf("%d",count);
		
	}

		
	private static void print(int[] ar) {
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i]);
			if (i != ar.length - 1) {
				System.out.print(" ");
			}
		}
		System.out.println();
	}

	static class WordFrequency{
		int frequency;
		String work;
		WordFrequency(int frequency,String work ){
			this.frequency = frequency;
			this.work = work;
		}
	}
	
	public static WordFrequency[] readArr(Scanner in, int n) {
		WordFrequency[] ar = new WordFrequency[n];
		for (int i = 0; n - i != 0; i++) {
			int freq = in.nextInt();
			String word = in.next();
			ar[i]= new WordFrequency(freq, word);
		}
		return ar;
	}
}
