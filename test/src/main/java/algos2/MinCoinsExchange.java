package algos2;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Test;

public class MinCoinsExchange {

	int[] coinValues = { 1, 2, 3 };
	int[] actualValues = { 1, 2, 3 };

	@Test
	public void test() {
		// System.out.println(howManyCoins(1));
		System.out.println(getOptimalCoinsChange(65));
		// System.out.println(howManyCoins(3));
		// System.out.println(howManyCoins(4));

	}

	// of course ugin dynamic programming is cute - but it is easier (complexity
	// and logic) to go from largest coing and divide take reminder an so forth
	// - the response is just as easy

//	void budgetCoins(int amount){ // could solve with optimal for dif or just go over budget (map of AtomicInteger - so we can lock-free update multithreaded)
//		Map<Integer, Long> mapCoinCount= optimalCoins(amount).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		while(true){
//		for(Entry<Integer, Long> entry : mapCoinCount){
//			int missing = getMissingCoins(entry.getKey(),entry.getValue());
//			if (missing >0){
//				optimalCoins(missing * entry.getKey(), coinValues )
//			}
//		}
//		}
//	}
	/**
	 * A dynamic programming, bottom up algorithm
	 * 
	 * @param amoun
	 * @return
	 */
	public List<Integer> getOptimalCoinsChange(int forAmount) {
		List<Integer>[] bottomUpSolutionList = initializeBottomUpSolutionList(forAmount);
		computeBottomUpSolutions(forAmount, bottomUpSolutionList);
		return bottomUpSolutionList[forAmount];
	}
	
	@SuppressWarnings("unchecked")
	private List<Integer> getOptimalCoinChange(int forAmount, List<Integer>[] bottomUpSolutionList) {
		if (bottomUpSolutionList[forAmount] != null) {
			return bottomUpSolutionList[forAmount];
		}
		List<Integer>[] mySolutions = new LinkedList[coinValues.length];
		if (forAmount == 0) {
			return new LinkedList<Integer>();
		}
		computeAllSolutions(forAmount, bottomUpSolutionList, mySolutions);
		bottomUpSolutionList[forAmount] = chooseOptimalSolution(mySolutions);
		return bottomUpSolutionList[forAmount];
	}

	private void computeAllSolutions(int forAmount, List<Integer>[] bottomUpSolutionList, List<Integer>[] mySolutions) {
		for (int i = 0; i < coinValues.length; i++) {
			mySolutions[i] = new LinkedList<Integer>();
			int currentCoin = coinValues[i];
			if (currentCoin <= forAmount) {
				mySolutions[i].addAll(getOptimalCoinChange(forAmount - currentCoin, bottomUpSolutionList));
				mySolutions[i].add(currentCoin);
				System.out.println("Solution: " + i + " = " + mySolutions[i]);
			}
		}
	}

	private void computeBottomUpSolutions(int maxAmount, List<Integer>[] bottomUpsolutionList) {
		for (int currentAmount = 1; currentAmount <= maxAmount; currentAmount++) {
			bottomUpsolutionList[currentAmount] = getOptimalCoinChange(currentAmount, bottomUpsolutionList);
		}
	}

	private List<Integer>[] initializeBottomUpSolutionList(int amount) {
		@SuppressWarnings("unchecked")
		List<Integer>[] bottomUpsolutionList = new List[amount + 1];
		bottomUpsolutionList[0] = new LinkedList<Integer>();
		return bottomUpsolutionList;
	}

	private List<Integer> chooseOptimalSolution(List<Integer>[] mySolutions) {
		List<Integer> chosenSolution = null;
		for (int i = 0; i < coinValues.length; i++) {
			List<Integer> currentSolution = mySolutions[i];
			if (currentSolution.size() > 0) {
				if (chosenSolution == null || currentSolution.size() < chosenSolution.size()) {
					chosenSolution = currentSolution;
				}
			}
		}
		return chosenSolution;
	}
}