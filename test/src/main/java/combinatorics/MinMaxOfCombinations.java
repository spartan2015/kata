package combinatorics;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Scanner;

public class MinMaxOfCombinations {
	private List<CombinationInfo> prevCombinationHere;
	private int[] data;

	public MinMaxOfCombinations(int[] data) {
		this.data = data;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		MinMaxOfCombinations minmax = new MinMaxOfCombinations(readArr(in, in.nextInt()));
		minmax.combinations(4);
		LongSummaryStatistics lss = minmax.prevCombinationHere.stream().mapToLong(ci->ci.sum).summaryStatistics();
		System.out.println(lss.getMin() + " " + lss.getMax());
	}

	public static int[] readArr(Scanner in, int n) {
		int[] ar = new int[n];
		for (int i = 0; n - i != 0; i++) {
			ar[i] = in.nextInt();
		}
		return ar;
	}

	private void combinations(int seqLength) {
		if (seqLength == 1) {
			prevCombinationHere = new ArrayList<>();
			for (byte i = 0; i < data.length; i++) {
				prevCombinationHere.add(new CombinationInfo(i, data[i]));
			}
		} else {
			if (prevCombinationHere == null) {
				combinations((byte) (seqLength - 1));
			}
			if (prevCombinationHere.size() == 0)
				return;
			List<CombinationInfo> prevCombs = prevCombinationHere;
			prevCombinationHere = new ArrayList<>();
			for (CombinationInfo combination : prevCombs) {
				for (int i = (combination.lastIndex + 1); i < data.length; i++) {
					long newSum = combination.sum + data[i];
					CombinationInfo newComb = new CombinationInfo((byte) i, newSum);
					prevCombinationHere.add(newComb);
				}
			}
		}
	}

	public static class CombinationInfo {
		byte lastIndex;
		long sum;

		CombinationInfo(byte lastIndex, long sum) {
			this.lastIndex = lastIndex;
			this.sum = sum;
		}
	}

}
