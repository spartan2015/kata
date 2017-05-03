package hackerRank.implementation;

import java.util.Scanner;

public class BreakingBestAndWorseRecords {
	static int[] getRecord(int[] s) {
		int min = s[0];
		int max = s[0];
		int countMin = 0;
		int countMax = 0;
		for (int k = 1; k < s.length; k++) {
            int i = s[k];
			if (i > max) {
				countMax++;
				max = i;
			}
			if (i < min) {
				countMin++;
				min = i;
			}
		}
		return new int[] { countMax, countMin };
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] s = new int[n];
		for (int s_i = 0; s_i < n; s_i++) {
			s[s_i] = in.nextInt();
		}
		int[] result = getRecord(s);
		String separator = "", delimiter = " ";
		for (Integer val : result) {
			System.out.print(separator + val);
			separator = delimiter;
		}
		System.out.println("");
	}
}
