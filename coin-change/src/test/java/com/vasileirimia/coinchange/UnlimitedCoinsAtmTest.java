package com.vasileirimia.coinchange;



import java.util.Collection;



import com.vasileirimia.coinchange.domain.Atm;
import com.vasileirimia.coinchange.domain.Coin;
import com.vasileirimia.coinchange.domain.CoinStore;
import com.vasileirimia.coinchange.domain.impl.UnlimitedCoinsAtm;
import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.assertTrue;

public class UnlimitedCoinsAtmTest extends BaseCoinAtmTest {

	private Atm atm = new UnlimitedCoinsAtm();	

	@Override
	protected Atm getAtm() {	
		return atm;
	}
	
	@Override
	protected CoinStore getCoinStore() {
		return null;
	}
	
	@Test
	public void testChangeForZeroAmount() throws Exception {		
		Collection<Coin> coinsChange = atm.widthdraw(0);
		assertTrue("Expected no coins for 0 amount", coinsChange.size() == 0);
	}

	@Test
	public void testChangeFor1Penny() throws Exception {
		testSingleCoinChangeReceived(Coin.ONE_PENNY, 1);
	}
	
	@Test
	public void testChangeFor2Pence() throws Exception {
		testSingleCoinChangeReceived(Coin.TWO_PENCE, 1);
	}
	
	@Test
	public void testChangeFor5Pence() throws Exception {
		testSingleCoinChangeReceived(Coin.FIVE_PENCE, 1);
	}
	
	@Test
	public void testChangeFor50Penny() throws Exception {
		testSingleCoinChangeReceived(Coin.FIFTY_PENCE, 1);
	}
	
	@Test
	public void testChangeFor20Penny() throws Exception {
		testSingleCoinChangeReceived(Coin.TWENTY_PENCE, 1);
	}
	
	@Test
	public void testChangeFor10Penny() throws Exception {
		testSingleCoinChangeReceived(Coin.TEN_PENCE, 1);
	}

	@Test
	public void testChangeForOnePound() throws Exception {
		testSingleCoinChangeReceived(Coin.POUND, 1);
	}

	@Test
	public void testChangeFor100Pound() throws Exception {		
		testSingleCoinChangeReceived(Coin.POUND, 100);
	}
	
	@Test
	public void testChangeFor1PoundAnd50Pence() throws Exception {		
		Object[][] expectedCoins = new Object[][]{{Coin.POUND, 1},{Coin.FIFTY_PENCE,1}};
		int amountChanged = 150;
		testCoinChange(expectedCoins, amountChanged);
	}
	
	@Test
	public void testChangeFor1PoundAnd20Pence() throws Exception {		
		testCoinChange(new Object[][]{{Coin.POUND, 1},{Coin.TWENTY_PENCE,1}}, 120);
	}
	
	@Test
	public void testChangeFor1PoundAnd5Pence() throws Exception {		
		testCoinChange(new Object[][]{{Coin.POUND, 1},{Coin.FIVE_PENCE,1}}, 105);
	}

	@Test
	public void testChangeFor1PoundAnd2Pence() throws Exception {		
		testCoinChange(new Object[][]{{Coin.POUND, 1},{Coin.TWO_PENCE,1}}, 102);
	}
	
	@Test
	public void testChangeFor1PoundAnd1PPenny() throws Exception {		
		testCoinChange(new Object[][]{{Coin.POUND, 1},{Coin.ONE_PENNY,1}}, 101);
	}
	
	@Test
	public void testChangeFor1088Pence() throws Exception {		
		testCoinChange(new Object[][]{{Coin.POUND, 10},{Coin.FIFTY_PENCE,1},{Coin.TWENTY_PENCE,1},{Coin.TEN_PENCE,1},{Coin.FIVE_PENCE,1},{Coin.TWO_PENCE,1},{Coin.ONE_PENNY,1}}, 1000+50+20+10+5+2+1 );
	}
}
