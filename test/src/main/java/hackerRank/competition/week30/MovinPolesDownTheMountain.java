package hackerRank.competition.week30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

// it is the min of all stack - if stacks are same number as poles -
// then easy - nothing is moved - cost is zero
// it the nearest move would be obvious move if it would be for the
// weight
// you only have to move higher alt poles so guess this reduces the
// options
// seems like dynamic programming
// what is interesting we have to create k stacks
// so we have to choose k starting points - those poles at k will not
// move
// but everything above th
// it may seems that some poles
// arrange them by cost - minimizing cost - cost compared to
// if the altitudes and the cost is predicatable from 1,2,3, or 10,20,30
// - that would be easy
// but given random higher, and random weights - we need serious
// computation
// so from one give poles - compute all costs above it - then choose
// minimal cost
// yeah but how do we factor in multiple stacks - make one big stack -
// from the lowest - then split it ?
// looking at the subsequence ? choosing min cost subsequence -
// so there are n poles - each has a minimal combination of poles above
// it
// does remember tower of hanoi -
// take from start we have a cost
// if we were to split that stack in 2 - what poles would minimize the
// cost -
// would take min cost from that - woould take all costs from all -
// starting from 0
// so starting from all poles - what would be the min cost above it
// then choosing from that n min start poles - kth elements from min
// costs above it
// would that give correct answer ?
// wouldn't that also include incorrect answers - based on fact that
// when we divide in kth elements - some of those have a lower cost now
// ?
// as you move lower the cost will always be higher - it is proportional
// to the distance

// so we have total cost above it - and we can minimize by going up or
// down this cost line
// we need to choose cost at pole - k costs -
// that are minimal - so min

//

public class MovinPolesDownTheMountain {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfPoles = in.nextInt();
		int howManyStackToCreate = in.nextInt();

		Pole[] poles = new Pole[noOfPoles]; // always given from lowest to
											// highest
		for (int i = 0; i < noOfPoles; i++) {
			int alt = in.nextInt();
			int weight = in.nextInt();
			poles[i] = new Pole(alt, weight);
		}

		System.out.println(getMinimumCostOfArrangingGivenPolesIntoStacks(poles, howManyStackToCreate));

	}

	private static int getMinimumCostOfArrangingGivenPolesIntoStacks(Pole[] poles, int k) {

		int C = poles.length / k;
		int D = poles.length % k;

		if (D != 0) {
			boolean[] marked = new boolean[poles.length];
			return giveMeMinSum(poles, marked, k - D, C) + giveMeMinSum(poles, marked, k - (k - D), C + 1);
		} else {
			return giveMeMinSum(poles, null, k, C);
		}

	}

	private static int giveMeMinSum(Pole[] poles, boolean[] visited, int firstElementsNo, int c) {
		combine(poles, visited, c);

		Collections.sort(prevCombinationHere);
		Set<Integer> considered = new HashSet<>();
		int sum = 0;
		int count = 0;
		for (int i = 0; i < prevCombinationHere.size() && count < firstElementsNo; i++) {
			CombinationInfo combinationInfo = prevCombinationHere.get(i);
			combinationInfo.polesIndexList.removeAll(considered);
			if (combinationInfo.polesIndexList.size() != c) {
				continue;
			}
			System.out.println(combinationInfo.polesIndexList + " " + combinationInfo.combinationCost);
			count++;
			sum += combinationInfo.combinationCost;
			considered.addAll(combinationInfo.polesIndexList);
			if (visited != null) {
				for (int x : combinationInfo.polesIndexList) {
					visited[x] = true;
				}
			}
		}
		prevCombinationHere = null;

		return sum;
	}

	static List<CombinationInfo> prevCombinationHere;

	private static void combine(Pole[] poles, boolean[] removed, int seqLength) {
		if (seqLength == 1) {
			prevCombinationHere = new ArrayList<>();
			for (byte i = 0; i < poles.length; i++) {
				if (removed != null && removed[i]) {
					continue;
				}
				prevCombinationHere.add(new CombinationInfo(poles[i], i));
			}
		} else {
			if (prevCombinationHere == null) {
				combine(poles, removed, seqLength - 1);
			}
			if (prevCombinationHere.size() == 0)
				return;

			List<CombinationInfo> prevCombs = prevCombinationHere;

			prevCombinationHere = new ArrayList<>();

			for (CombinationInfo combination : prevCombs) {
				for (int i = (combination.lastIndex + 1); i < poles.length; i++) {
					if (removed != null && removed[i]) {
						continue;
					}
					CombinationInfo newComb = new CombinationInfo(combination, i, poles[i]);
					prevCombinationHere.add(newComb);
				}
			}
		}
	}

	static class CombinationInfo implements Comparable<CombinationInfo> {
		private Pole startPole;
		private List<Integer> polesIndexList = new ArrayList<>();
		private int lastIndex;
		private int combinationCost;

		CombinationInfo(Pole startPole, int index) {
			this.startPole = startPole;
			this.lastIndex = index;
			polesIndexList.add(index);
		}

		CombinationInfo(CombinationInfo ci, int index, Pole pole) {
			this.startPole = ci.startPole;
			this.polesIndexList.add(index);
			this.polesIndexList.addAll(ci.polesIndexList);
			this.lastIndex = index;
			this.combinationCost = ci.combinationCost + costOfMoving(pole, this.startPole.alt);
		}

		@Override
		public int compareTo(CombinationInfo other) {
			return combinationCost - other.combinationCost;
		}
	}

	private static int costOfMoving(Pole pole, int toHeight) {
		if (pole.alt < toHeight) {
			throw new RuntimeException("a pole can only be moved from higher altitudes to lower altitudes");
		}
		return (pole.alt - toHeight) * pole.weight;
	}

	static class Pole {
		int alt;
		int weight;

		Pole(int alt, int weight) {
			this.alt = alt;
			this.weight = weight;
		}
	}

}
