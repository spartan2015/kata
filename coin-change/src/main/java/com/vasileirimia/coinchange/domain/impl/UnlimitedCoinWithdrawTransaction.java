package com.vasileirimia.coinchange.domain.impl;

import com.vasileirimia.coinchange.domain.Coin;

public class UnlimitedCoinWithdrawTransaction extends WithdrawTransaction {

	public UnlimitedCoinWithdrawTransaction(int amount) {
		super(amount);
	}

	@Override
	protected int getAvailableCoins(Coin coin, int numberOfCoins) {
		return numberOfCoins;
	}

}
