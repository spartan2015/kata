package com.vasileirimia.coinchange.domain.impl;

import java.util.Collection;

import com.vasileirimia.coinchange.domain.Atm;
import com.vasileirimia.coinchange.domain.Coin;

/**
 * UnlimitedCoinsAtm will attempt to change the amount provided in coins
 * assuming an unlimited supply of coins
 * 
 * @author vasilei
 *
 */
public class UnlimitedCoinsAtm implements Atm {

	/**
	 * Returns the min amount of coins need to change the amount provided
	 * Assumes unlimited coins 
	 */
	@Override
	public Collection<Coin> widthdraw(int amount) throws InsuficientCoinsException {
		WithdrawTransaction transaction = new UnlimitedCoinWithdrawTransaction(amount);
		return transaction.change();
	}

}
