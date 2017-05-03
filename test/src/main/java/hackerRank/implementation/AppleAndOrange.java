package hackerRank.implementation;

import java.util.Scanner;

public class AppleAndOrange {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int t = in.nextInt();

		int appleX = in.nextInt();
		int orangeX = in.nextInt();

		int mApples = in.nextInt();
		int nOranges = in.nextInt();

		System.out.println(countInRange(in, s, t, appleX, mApples));
		System.out.println(countInRange(in, s, t, orangeX, nOranges));
		
	}

	private static int countInRange(Scanner in, int s, int t, int x, int n) {
		int inRangeCounter = 0;
		for (int i = 0; i < n; i++) {
			int l = x + in.nextInt();
			if (s<=l && l <= t){
				inRangeCounter++;
			}
		}
		return inRangeCounter;
	}
}
