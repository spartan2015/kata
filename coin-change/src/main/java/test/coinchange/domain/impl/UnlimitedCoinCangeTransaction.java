package test.coinchange.domain.impl;

import java.util.Collection;
import java.util.LinkedList;

import test.coinchange.domain.Coin;

abstract class UnlimitedCoinCangeTransaction {
	private Collection<Coin> change = new LinkedList<>();
	private Coin[] orderedCoins = Coin.values();
	private int amount;

	public UnlimitedCoinCangeTransaction(int amount) {
		this.amount = amount;
	}
	
	public Collection<Coin> change() throws InsuficientCoinsException {
		for (int i = 0; i < orderedCoins.length && amount > 0; i++) {
			changeFor(orderedCoins[i]);
		}
		return change;
	}

	private void changeFor(Coin coin) {
		int neededNumberOfCoins = amount / coin.getPence();
		int availableNumberOfCoins = getAvailableCoins(coin, neededNumberOfCoins);
		addCoins(availableNumberOfCoins, coin);
		amount -= availableNumberOfCoins * coin.getPence();
	}
	
	/**
	 * Try to substract up to [numberOfCoins] from store
	 * 
	 * @param numberOfCoins that we need to substract
	 * @param coin type
	 * @return actual number of coins substracted from the store 
	 */
	protected abstract int getAvailableCoins(Coin coin,int numberOfCoins);

	private void addCoins(int numberOfCoins, Coin coin) {
		for (int i = 0; i < numberOfCoins; i++) {
			change.add(coin);
		}
	}
}