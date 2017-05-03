package hackerRank.competition.week30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * works for low numbers
 * 
 * unfortunately computing all permutations - takes too longs
 * 
 * needs a different solution - based on some mathematical stuf relation on the cost precomputed
 * 
 * @author vasil
 *
 */
public class MovinPolesDownTheMountainDynamic {

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

		getMinimumCostOfArrangingGivenPolesIntoStacks(poles, howManyStackToCreate);
		System.out.println(minCost);

	}

	private static void getMinimumCostOfArrangingGivenPolesIntoStacks(Pole[] poles, int k) {
		dynamic(poles, Arrays.asList(0),0,  1,k);
	}
	
	private static void dynamic(Pole[] poles, List<Integer> prevCombination,int cost, int index, int k) {
		if (prevCombination.size() == k){
			
			int costSoFar = cost;
			int startAt = prevCombination.get(prevCombination.size()-1);
			for (int y = startAt+1; y < poles.length; y++){
				costSoFar+=costOfMoving(poles[y], poles[startAt]);
			}
			
			//int cost = 0;
			
//			for(int i = 0; i < prevCombination.size(); i++){
//				int startIndex = prevCombination.get(i);
//				
//				int lastIndex = i+1 < prevCombination.size() ? prevCombination.get(i+1) : poles.length;
//			
//				
//				
//				for(int j = startIndex+1; j < lastIndex; j++){
//					cost+= costOfMoving(poles[j], poles[startIndex]);
//				}
//			}
			System.out.println(prevCombination + " " + costSoFar);
			minCost = Math.min(costSoFar, minCost);
			
			return;
		}
		
		// dramatic cost reduction in computing if we compute solution as we go and drop the ones higher than min found
		for(int i = index; i < poles.length; i++){ 
			List<Integer> option = new ArrayList<>();
			option.addAll(prevCombination);
			
			int costSoFar = cost;
			int startAt = prevCombination.get(prevCombination.size()-1);
			for (int y = startAt+1; y < i; y++){
				costSoFar+=costOfMoving(poles[y], poles[startAt]);
			}
			
			if (costSoFar < minCost){
				option.add(i);
				dynamic(poles, option, costSoFar, i+1, k);
			}
		}
		
	}

	static int minCost = Integer.MAX_VALUE;
	
	private static int costOfMoving(Pole pole, Pole toPole) {
		if (pole.alt < toPole.alt) {
			throw new RuntimeException("a pole can only be moved from higher altitudes to lower altitudes");
		}
		return (pole.alt - toPole.alt) * pole.weight;
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
