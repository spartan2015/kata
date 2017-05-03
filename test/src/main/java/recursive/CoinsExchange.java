package recursive;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class CoinsExchange {
	@Test
	public void test() {
		// assertEquals(Integer.valueOf(1),
		// (Integer)howManyExchangePermutationsAreThere(5,new int[]{1},
		// Collections.EMPTY_LIST));

		// assertEquals(Integer.valueOf(2),
		// (Integer)howManyExchangePermutationsAreThere(5,new int[]{5,1},
		// Collections.EMPTY_LIST));

		assertEquals(Integer.valueOf(8),
				(Integer) howManyExchangePermutationsAreThere(10,100, new int[] {10, 5, 1 }, Collections.EMPTY_LIST));
		
	}
	
	@Test
	public void testCrack(){
		System.out.println(makeChange(10));
	}

	public int howManyExchangePermutationsAreThere(int amount,int prevCoin, int[] coins, List<Integer> chain) {
		if (amount == 0) {
			System.out.println(chain);
			return 1;
		}
		int sum = 0;
		for (int coin : coins) {
			if (coin <= prevCoin && amount >= coin) { // holding on to prev coin avoid prev solutions for unlimited amount 
				LinkedList<Integer> track = new LinkedList<>();
				track.addAll(chain);
				track.add(coin);
				sum += howManyExchangePermutationsAreThere(amount - coin,coin, coins, track);
			}
		}
		return sum;
	}

	public int makeChange(int amount) {
		return makeChange(amount, 25);
	}

	
	
	private int makeChange(int amount, int coin) {
		int nextCoin = 0;
		switch (coin) {
		case 25:
			nextCoin = 10;
			break;
		case 10:
			nextCoin = 5;
			break;
		case 5:
			nextCoin = 1;
			break;
		case 1:
			return 1;
		}
		int ways = 0;
		for(int i =0; i*coin <= amount; i++){
			ways+=makeChange(amount - i * coin, nextCoin);
		}
		return ways;
	}
}
