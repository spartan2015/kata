package combinatorics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import datastructures.LocalIntStack;

/**
 * 
 * @author vasil
 *
 */
public class WetSharkSubsequenceBad {
	/**
	 * the length of the original array (input)
	 */
	int m;
	// sum of sum 
	int r;
	// sum of diff
	int s;
	
	/**
	 * orig data
	 * 
	 */
	int[] data;
	int match = 0;

	public WetSharkSubsequenceBad(int m, int r, int s, int[] data) {
		this.m = m;
		this.r = r;
		this.s = s;
		this.data = data;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String headerLine = sc.nextLine();
		String dataLine = sc.nextLine();

		int[] intParts = toIntArray(headerLine);
		// System.out.println("header " + Arrays.toString(intParts));
		int[] data = toIntArray(dataLine);
		// System.out.println("data " + Arrays.toString(data));
		int m = intParts[0];
		int r = intParts[1];
		int s = intParts[2];

		System.out.println(new WetSharkSubsequenceBad(m, r, s, data).match() % 1_000_000_007);
	}

	private void validate() {
		if (m != data.length) {
			throw new IllegalArgumentException(
					String.format("data size[%d] is not equals with m[%d] size.", data.length, m));
		}
		checkBounds(m, 1, 100);
		checkBounds(r, 0, 2000);
		checkBounds(s, 0, 2000);
	}

	private static void checkBounds(int m, int lower, int upper) {
		if (!(m >= lower && m <= upper)) {
			throw new IllegalArgumentException("m >= " + lower + " && m <=" + upper);
		}
	}

	/**
	 * one has to be different
	 * 
	 * matching against same size
	 * 
	 * @return
	 */
	public int match() {
		validate();
		List<Subset> subsetList = null;
		for (int i = 0; i < m; i++) {
			subsetList = createSubSets(subsetList); // ever growing subset list from 1 to m-1 - which is good
			if (subsetList.size() > 1) {
				for (int x = 0; x < subsetList.size() - 1; x++) {
					for (int y = x + 1; y < subsetList.size(); y++) {
						Subset leftSubset = subsetList.get(x);
						Subset rightSubset = subsetList.get(y);
						leftRightMatch(leftSubset, rightSubset);
						leftRightMatch(rightSubset, leftSubset);
					}
				}
			}
		}

		return match;
	}

	private void leftRightMatch(Subset leftSubset, Subset rightSubset) {
		leftSubset.match(rightSubset);
	}

	public class Subset {
		LocalIntStack list;

		Subset(LocalIntStack list) {
			this.list = list;
		}

		public void match(Subset subsetB) {
			if (this.list.sum+subsetB.list.sum == r && this.list.sum-subsetB.list.sum == s) {
				match++;
			}
		}
		
		private long getS(LocalIntStack subA,LocalIntStack subB) {
			long sum = 0;
			for (int i = 0; i < list.currentIndex; i++) {
				sum += data[subA.arr[i]] - data[subB.arr[i]];
			}
			return sum;
		}

		private long getR(LocalIntStack subA,LocalIntStack subB) {
			long sum = 0;
			for (int i = 0; i < list.currentIndex; i++) {
				sum += data[subA.arr[i]] + data[subB.arr[i]];
			}
			return sum;
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for (int i = 0; i<  list.currentIndex; i++) {
				sb.append(data[list.arr[i]] + ",");
			}
			sb.append("]");
			return sb.toString();
		}
	}

	public List<Subset> createSubSets(List<Subset> previousSubSets) {
		if (previousSubSets == null) {
			previousSubSets = new ArrayList<>();
			for (int i = 0; i < data.length; i++) {
				LocalIntStack newStack = new LocalIntStack();
				newStack.push(i);
				previousSubSets.add(new Subset(newStack));
			}
			return previousSubSets;
		}
		return combine(previousSubSets);
	}

	private List<Subset> combine(List<Subset> list) {
		List<Subset> newList = new ArrayList<>();
		for (Subset set : list) {
			int lastIndex = set.list.peek();
			for (int j = lastIndex + 1; j < data.length; j++) {
				LocalIntStack subsetList = new LocalIntStack();
				subsetList.copy(set.list);
				subsetList.push(j);
				newList.add(new Subset(subsetList));
			}
		}
		 System.out.println(newList);
		 System.out.println(newList.size());
		return newList;
	}

	private static int[] toIntArray(String headerLine) {
		String[] headerParts = headerLine.split(" ");
		int[] intParts = new int[headerParts.length];
		for (int i = 0; i < headerParts.length; i++) {
			intParts[i] = Integer.valueOf(headerParts[i]);
		}
		return intParts;
	}
}
