package test.coinchange.domain;

import java.util.Collection;

import test.coinchange.domain.impl.InsuficientCoinsException;

public interface Atm {
	/**
	 * Return a collection of Coins that change the amount provided
	 * 
	 * @param forAmount - in pence
	 * @return collection of coins
	 * @throws InsuficientCoinsException if not enough coins are in the coins store
	 */
	Collection<Coin> getOptimalChangeFor(int forAmount) throws InsuficientCoinsException;
}
