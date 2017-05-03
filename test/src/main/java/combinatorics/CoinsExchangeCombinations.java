package combinatorics;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class CoinsExchangeCombinations {

	@Test
	public void test() {
		exchange(new int[] { 25, 10, 5, 1 }, 10, 0,new LinkedList<>());
	}

	private void exchange(int[] coins, int amount, int startCoin,  List<Integer> prevList) {
		if (amount == 0){
			System.out.println(prevList);
			return;
		}
		for (int i = startCoin; i < coins.length; i++) {
			int leftAmount = amount - coins[i];
			if (leftAmount >= 0) {
				List<Integer> variant = new LinkedList<>();
				variant.addAll(prevList);
				variant.add(coins[i]);
				exchange(coins, leftAmount, i, variant);
			}
		}
	}
}