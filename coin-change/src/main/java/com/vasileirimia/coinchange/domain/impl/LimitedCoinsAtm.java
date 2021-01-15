package com.vasileirimia.coinchange.domain.impl;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.vasileirimia.coinchange.domain.Atm;
import com.vasileirimia.coinchange.domain.Coin;
import com.vasileirimia.coinchange.domain.CoinStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Limited Coins will attempt to change the amount provided in coins assuming an
 * a limited supply of coins provided by the CoinStore
 * 
 * @author vasilei
 *
 */
@Component
public class LimitedCoinsAtm implements Atm {
	private static final LinkedList<Coin> EMPTY_BAG = new LinkedList<>();
	@Autowired
	private CoinStore coinStore;

	public void setCoinStore(CoinStore coinStore) {
		this.coinStore = coinStore;
	}

	/**
	 * Returns the min amount of coins need to change the amount provided
	 * Assumes limited coins provided by the CoinStore
	 */
	@Override
	public Collection<Coin> widthdraw(int amount) throws InsuficientCoinsException {
		if (amount == 0) { // the bottom up algo already takes care of that - should delete this
			return EMPTY_BAG;
		}
		List<Integer> coinValueList = getOptimalCoinsChange(amount);
		if (coinValueList == null || coinValueList.size() == 0) {
			throw new InsuficientCoinsException();
		}
		List<Coin> coinList = coinValueList.stream().map(penceValue -> Coin.fromPence(penceValue))
				.collect(Collectors.toList());
		synchronized (coinStore) {
			coinList.stream().forEach(coin -> {
				coinStore.substract(coin, 1);
			});
			return coinList;
		}
	}

	/**
	 * A dynamic programming, bottom up algorithm
	 * 
	 * @param forAmount
	 * @return
	 */
	private List<Integer> getOptimalCoinsChange(int forAmount) {
		List<Integer>[] bottomUpSolutionList = initializeBottomUpSolutionList(forAmount);
		computeBottomUpSolutions(forAmount, bottomUpSolutionList);
		return bottomUpSolutionList[forAmount];
	}

	@SuppressWarnings("unchecked")
	private List<Integer> getOptimalCoinChange(int forAmount, List<Integer>[] bottomUpSolutionList) {
		if (bottomUpSolutionList[forAmount] != null) {
			return bottomUpSolutionList[forAmount];
		}
		List<Integer>[] mySolutions = new LinkedList[getCoinTypeNumber()];
		if (forAmount == 0) {
			return new LinkedList<Integer>();
		}
		computeAllSolutions(forAmount, bottomUpSolutionList, mySolutions);
		bottomUpSolutionList[forAmount] = chooseOptimalSolution(mySolutions, forAmount);
		return bottomUpSolutionList[forAmount];
	}

	private void computeAllSolutions(int forAmount, List<Integer>[] bottomUpSolutionList, List<Integer>[] mySolutions) {
		for (int i = 0; i < getCoinTypeNumber(); i++) {
			int currentCoinPenceValue = Coin.values()[i].getPence();
			mySolutions[i] = new LinkedList<Integer>();
			if (currentCoinPenceValue <= forAmount) {
				mySolutions[i].addAll(getOptimalCoinChange(forAmount - currentCoinPenceValue, bottomUpSolutionList));
				mySolutions[i].add(currentCoinPenceValue);
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

	private List<Integer> chooseOptimalSolution(List<Integer>[] mySolutions, int forAmount) {
		List<Integer> chosenSolution = null;
		for (int i = 0; i < getCoinTypeNumber(); i++) {
			List<Integer> currentSolution = mySolutions[i];
			int sum = currentSolution.stream().mapToInt(in->in.intValue()).sum();
			if (currentSolution.size() > 0) {
				if (forAmount == sum && areCoinsAvailable(currentSolution)
						&& (chosenSolution == null || currentSolution.size() < chosenSolution.size())) {
					chosenSolution = currentSolution;
				}
			}
		}
		if (chosenSolution == null) {
			return new LinkedList<>();
		} else {
			return chosenSolution;
		}
	}

	private boolean areCoinsAvailable(List<Integer> currentSolution) {
		Map<Coin, Long> coinCountMap = toCoinCountMap(currentSolution);
		return hasCoins(coinCountMap);
	}

	private boolean hasCoins(Map<Coin, Long> coinMap) {
		for (Coin coin : coinMap.keySet()) {
			if (!coinStore.hasCoins(coin, coinMap.getOrDefault(coin, 0L).intValue())) {
				return false;
			}
		}
		return true;
	}

	private Map<Coin, Long> toCoinCountMap(List<Integer> currentSolution) {
		return currentSolution.stream().map(valueInPence -> Coin.fromPence(valueInPence))
				.collect(Collectors.groupingBy(coin -> coin, Collectors.counting()));
	}

	private int getCoinTypeNumber() {
		return Coin.values().length;
	}

}
