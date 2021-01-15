package com.vasileirimia.coinchange.domain;

public interface CoinStore {

	/**
	 * try to fetch up to numberOfCoins from the store 
	 * 
	 * @param coin type
	 * @param numberOfCoins that we want to extract
	 * @return number of coins actually extracted
	 */
	int substract(Coin coin, int numberOfCoins);
	
	/**
	 * returns if the store has the coins available
	 * 
	 * @param coin type
	 * @param number of coins
	 * @return
	 */
	boolean hasCoins(Coin coin, int count);

	/**
	 * @param coin type
	 * @return  number of available coins of the given type
	 */
	int get(Coin coin);
	
	/**
	 * Add coins to the store
	 * 
	 * @param coin type
	 * @param numberOfCoins
	 */
	void put(Coin coin, int numberOfCoins);

}
