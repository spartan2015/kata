package com.vasileirimia.coinchange;

import java.util.Collection;

import com.vasileirimia.coinchange.domain.impl.InsuficientCoinsException;
import com.vasileirimia.coinchange.domain.impl.LimitedCoinsAtm;
import com.vasileirimia.coinchange.domain.impl.UnlimitedCoinsAtm;
import com.vasileirimia.coinchange.domain.Atm;
import com.vasileirimia.coinchange.domain.Coin;
import com.vasileirimia.coinchange.domain.impl.CoinStoreFactory;

public class CoinChangeApp {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println(
					"Expected 2 parameters: Store Type (limited or unlimited) and the amount you need change for\n"
					+ "Will try to read in the current folder the coin-inventory.properties if present");
		}
		Atm atm = getStoreType(args);				
		try {
			Collection<Coin> changeCoins = atm.widthdraw(getAmount(args));
			System.out.println(changeCoins);
		} catch (InsuficientCoinsException e) {
			System.out.println("Not enough coins to change the amount");
		}		
	}

	private static Atm getStoreType(String[] args) {
		Atm atm = null;
		String storeType = args[0];
		if ("unlimited".equals(storeType)){ 
			atm = new UnlimitedCoinsAtm();
		}else if ("limited".equals(storeType)){
			LimitedCoinsAtm limitedAtm = new LimitedCoinsAtm();
			limitedAtm.setCoinStore(CoinStoreFactory.getInstance().getDefaultCoinStore());
			atm = limitedAtm;
		}else{
			throw new RuntimeException("Invalid store type: " + storeType);
		}
		return atm;
	}

	private static java.lang.Integer getAmount(String[] args) {
		String amountString = args[1];
		java.lang.Integer amount = java.lang.Integer.valueOf(amountString);
		return amount;
	}

}
