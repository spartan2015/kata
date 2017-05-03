package test.coinchange.domain.impl;

import test.coinchange.domain.Coin;

public class UnlimitedCoinChangeTransaction extends UnlimitedCoinCangeTransaction{

	public UnlimitedCoinChangeTransaction(int amount) {
		super(amount);
	}

	@Override
	protected int getAvailableCoins(Coin coin,int numberOfCoins) {		
		return numberOfCoins;
	}

}
