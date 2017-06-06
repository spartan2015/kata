package hackerRank.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import utils.TimerUtils;

public class CountingSortWithAssociated2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		TimerUtils.timed(()->{
		
		WordFrequency[] ar = readArr(in, n);

		List<String>[] sortedWords = new List[n];
		int mid = ar.length / 2;
		for (int i = 0; i < ar.length; i++) {
			WordFrequency w = ar[i];
			if (sortedWords[w.frequency] == null) {
				sortedWords[w.frequency] = new ArrayList<>(50000);
			}
			sortedWords[w.frequency].add(i < mid ? "-" : w.work);
		}

		StringBuilder sb = new StringBuilder();
		for (List<String> list : sortedWords) {
			if (list != null) {
				for (String s : list) {
					//System.out.print(s+" ");
					sb.append(s).append(" ");
				}
			}
		}
		System.out.println(sb.toString());
		});
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

	static class WordFrequency {
		int frequency;
		String work;

		WordFrequency(int frequency, String work) {
			this.frequency = frequency;
			this.work = work;
		}
	}

	public static WordFrequency[] readArr(Scanner in, int n) {
		WordFrequency[] ar = new WordFrequency[n];
		for (int i = 0; n - i != 0; i++) {
			int freq = in.nextInt();
			String word = in.next();
			ar[i] = new WordFrequency(freq, word);
		}
		return ar;
	}
}
