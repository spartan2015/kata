package test.coinchange.domain.impl;

import java.util.Collection;

import test.coinchange.domain.Atm;
import test.coinchange.domain.Coin;

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
	public Collection<Coin> getOptimalChangeFor(int amount) throws InsuficientCoinsException {
		UnlimitedCoinCangeTransaction transaction = new UnlimitedCoinChangeTransaction(amount);
		return transaction.change();
	}

}
