package com.vasileirimia.coinchange.domain;

import java.util.Collection;

import com.vasileirimia.coinchange.domain.impl.InsuficientCoinsException;

public interface Atm {
	/**
	 * Return a collection of Coins that change the amount provided
	 * 
	 * @param amount - in pence
	 * @return collection of coins
	 * @throws InsuficientCoinsException if not enough coins are in the coins store
	 */
	Collection<Coin> widthdraw(int amount) throws InsuficientCoinsException;
}
