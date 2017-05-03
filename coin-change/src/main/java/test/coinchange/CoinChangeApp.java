package test.coinchange;

import java.util.Collection;

import test.coinchange.domain.Atm;
import test.coinchange.domain.Coin;
import test.coinchange.domain.impl.CoinStoreFactory;
import test.coinchange.domain.impl.InsuficientCoinsException;
import test.coinchange.domain.impl.LimitedCoinsAtm;
import test.coinchange.domain.impl.UnlimitedCoinsAtm;

public class CoinChangeApp {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println(
					"Expected 2 parameters: Store Type (limited or unlimited) and the amount you need change for\n"
					+ "Will try to read in the current folder the coin-inventory.properties if present");
		}
		Atm atm = getStoreType(args);				
		try {
			Collection<Coin> changeCoins = atm.getOptimalChangeFor(getAmount(args));
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

	private static Integer getAmount(String[] args) {
		String amountString = args[1];
		Integer amount = Integer.valueOf(amountString);
		return amount;
	}

}
