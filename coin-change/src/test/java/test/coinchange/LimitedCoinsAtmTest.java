package test.coinchange;

import static org.junit.Assert.assertTrue;
import static org.mockito.AdditionalAnswers.returnsArgAt;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.internal.matchers.Equals;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import test.coinchange.domain.Atm;
import test.coinchange.domain.Coin;
import test.coinchange.domain.CoinStore;
import test.coinchange.domain.impl.InsuficientCoinsException;
import test.coinchange.domain.impl.LimitedCoinsAtm;

@RunWith(MockitoJUnitRunner.class)
public class LimitedCoinsAtmTest extends BaseCoinAtmTest {
	private LimitedCoinsAtm atm = new LimitedCoinsAtm();
	private CoinStore coinStore = mock(CoinStore.class);

	@Before
	public void before() {
		atm.setCoinStore(coinStore);
	}

	@Override
	protected Atm getAtm() {
		return atm;
	}
	
	@Override
	protected CoinStore getCoinStore() {
		return coinStore;
	}

	@Test
	public void testChangeForZeroAmount() throws Exception {
		Collection<Coin> coinsChange = atm.getOptimalChangeFor(0);
		validateMockitoUsage();
		assertTrue("Expected no coins for 0 amount", coinsChange.size() == 0);
	}

	@Test
	public void testChangeFor1PennyWhenStoreHasIt() throws Exception {
		testMockSingleCoinChangeReceived(Coin.ONE_PENNY, 1);
	}
	
	@Test(expected=InsuficientCoinsException.class)
	public void testChangeFor1PennyWhenStoreDoesNotHaveIt() throws Exception {
		testMockSingleCoinChangeReceivedWhenStoreDoesNotHaveIt(Coin.ONE_PENNY, 1);
	}

	@Test
	public void testChangeFor2PenceWhenStoreHasIt() throws Exception {
		testMockSingleCoinChangeReceived(Coin.TWO_PENCE, 1);
	}
	
	@Test(expected=InsuficientCoinsException.class)
	public void testChangeFor2PenceWhenStoreDoesNotHaveIt() throws Exception {
		testMockSingleCoinChangeReceivedWhenStoreDoesNotHaveIt(Coin.TWO_PENCE, 1);
	}

	@Test
	public void testChangeFor5PenceWhenStoreHasIt() throws Exception {
		testMockSingleCoinChangeReceived(Coin.FIVE_PENCE, 1);
	}
	
	@Test(expected=InsuficientCoinsException.class)
	public void testChangeFor5PenceWhenStoreDoesNotHaveIt() throws Exception {
		testMockSingleCoinChangeReceivedWhenStoreDoesNotHaveIt(Coin.FIVE_PENCE, 1);
	}

	@Test
	public void testChangeFor50PennyWhenStoreHasIt() throws Exception {
		testMockSingleCoinChangeReceived(Coin.FIFTY_PENCE, 1);
	}
	
	@Test(expected=InsuficientCoinsException.class)
	public void testChangeFor50PennyWhenStoreDoesNotHaveIt() throws Exception {
		testMockSingleCoinChangeReceivedWhenStoreDoesNotHaveIt(Coin.FIFTY_PENCE, 1);
	}

	@Test
	public void testChangeFor20PennyWhenStoreHasIt() throws Exception {
		testMockSingleCoinChangeReceived(Coin.TWENTY_PENCE, 1);
	}
	
	@Test(expected=InsuficientCoinsException.class)
	public void testChangeFor20PennyWhenStoreDoesNotHaveIt() throws Exception {
		testMockSingleCoinChangeReceivedWhenStoreDoesNotHaveIt(Coin.TWENTY_PENCE, 1);
	}

	@Test
	public void testChangeFor10PennyWhenStoreHasIt() throws Exception {
		testMockSingleCoinChangeReceived(Coin.TEN_PENCE, 1);
	}
	
	@Test(expected=InsuficientCoinsException.class)
	public void testChangeFor10PennyWhenStoreDoesNotHaveIt() throws Exception {
		testMockSingleCoinChangeReceivedWhenStoreDoesNotHaveIt(Coin.TEN_PENCE, 1);
	}

	@Test
	public void testChangeForOnePoundWhenStoreHasIt() throws Exception {
		testMockSingleCoinChangeReceived(Coin.POUND, 1);
	}

	@Test(expected=InsuficientCoinsException.class)
	public void testChangeForOnePoundWhenStoreDoesNotHaveIt() throws Exception {
		testMockSingleCoinChangeReceivedWhenStoreDoesNotHaveIt(Coin.POUND, 1);
	}
	
	@Test
	public void testChangeFor100PoundWhenStoreHasIt() throws Exception {
		long start = System.currentTimeMillis();
		testMockSingleCoinChangeReceived(Coin.POUND, 100);
		System.out.println(System.currentTimeMillis() - start);
	}
	
	@Test
	public void testChangeFor1PoundAnd50PenceWhenStoreHasIt() throws Exception {
		setupAvailableCoins(new Object[][] { { Coin.POUND, 1 }, { Coin.FIFTY_PENCE, 1 }, { Coin.TWENTY_PENCE, 0 },
			{ Coin.TEN_PENCE, 0 }, { Coin.FIVE_PENCE, 0 }, { Coin.TWO_PENCE, 0 }, { Coin.ONE_PENNY, 0 } });
		
		testCoinChange(new Object[][]{{Coin.POUND, 1},{Coin.FIFTY_PENCE,1}}, 150);
		validateMockitoUsage();
	}
	
	@Test
	public void testChangeForWhenPoundsAreNotAvailableBut50PencesAre() throws Exception {		
		setupAvailableCoins(new Object[][] { { Coin.POUND, 0 }, { Coin.FIFTY_PENCE, 2 }, { Coin.TWENTY_PENCE, 0 },
			{ Coin.TEN_PENCE, 0 }, { Coin.FIVE_PENCE, 0 }, { Coin.TWO_PENCE, 0 }, { Coin.ONE_PENNY, 0 } });
		
		testCoinChange(new Object[][]{{Coin.FIFTY_PENCE,2}}, 100);
		validateMockitoUsage();
	}
	
	@Test
	public void testChangeWhenOnly20AreAvailable() throws Exception {		
		setupAvailableCoins(new Object[][] { { Coin.POUND, 0 }, { Coin.FIFTY_PENCE, 0 }, { Coin.TWENTY_PENCE, 5 },
			{ Coin.TEN_PENCE, 0 }, { Coin.FIVE_PENCE, 0 }, { Coin.TWO_PENCE, 0 }, { Coin.ONE_PENNY, 0 } });
		
		testCoinChange(new Object[][]{{Coin.TWENTY_PENCE,5}}, 100);
		validateMockitoUsage();
	}
	
	@Test
	public void testChangeWhenOnly10AreAvailable() throws Exception {		
		setupAvailableCoins(new Object[][] { { Coin.POUND, 0 }, { Coin.FIFTY_PENCE, 0 }, { Coin.TWENTY_PENCE, 0 },
			{ Coin.TEN_PENCE, 10 }, { Coin.FIVE_PENCE, 0 }, { Coin.TWO_PENCE, 0 }, { Coin.ONE_PENNY, 0 } });
		
		testCoinChange(new Object[][]{{Coin.TEN_PENCE,10}}, 100);
		validateMockitoUsage();
	}
	
	@Test
	public void testChangeWhenOnly5AreAvailable() throws Exception {		
		setupAvailableCoins(new Object[][] { { Coin.POUND, 0 }, { Coin.FIFTY_PENCE, 0 }, { Coin.TWENTY_PENCE, 0 },
			{ Coin.TEN_PENCE, 0 }, { Coin.FIVE_PENCE, 20 }, { Coin.TWO_PENCE, 0 }, { Coin.ONE_PENNY, 0 } });
		
		testCoinChange(new Object[][]{{Coin.FIVE_PENCE,20}}, 100);
		validateMockitoUsage();
	}
	
	@Test
	public void testChangeWhenOnly2AreAvailable() throws Exception {		
		setupAvailableCoins(new Object[][] { { Coin.POUND, 0 }, { Coin.FIFTY_PENCE, 0 }, { Coin.TWENTY_PENCE, 0 },
			{ Coin.TEN_PENCE, 0 }, { Coin.FIVE_PENCE, 0 }, { Coin.TWO_PENCE, 50 }, { Coin.ONE_PENNY, 0 } });
		
		testCoinChange(new Object[][]{{Coin.TWO_PENCE,50}}, 100);
		validateMockitoUsage();
	}
	
	@Test
	public void testChangeWhenOnly1AreAvailable() throws Exception {			
		setupAvailableCoins(new Object[][] { { Coin.POUND, 0 }, { Coin.FIFTY_PENCE, 0 }, { Coin.TWENTY_PENCE, 0 },
			{ Coin.TEN_PENCE, 0 }, { Coin.FIVE_PENCE, 0 }, { Coin.TWO_PENCE, 0 }, { Coin.ONE_PENNY, 100 } });
		
		testCoinChange(new Object[][]{{Coin.ONE_PENNY,100}}, 100);
		validateMockitoUsage();
	}
	
	@Test
	public void testChangeWhen10and5And1AreAvailable() throws Exception {		
		setupAvailableCoins(new Object[][] { { Coin.POUND, 0 }, { Coin.FIFTY_PENCE, 0 }, { Coin.TWENTY_PENCE, 0 },
			{ Coin.TEN_PENCE, 5 }, { Coin.FIVE_PENCE, 0 }, { Coin.TWO_PENCE, 25 }, { Coin.ONE_PENNY, 100 } });
		
		testCoinChange(new Object[][]{{Coin.TEN_PENCE,5},{Coin.TWO_PENCE,25}}, 100);
		validateMockitoUsage();
	}
	
	@Test
	public void testChangeWhen10and5And1AreAvailableException() throws Exception { 		
		setupAvailableCoins(new Object[][]{{Coin.TEN_PENCE, 1},{Coin.TWO_PENCE, 3}});
		
		testCoinChange(new Object[][]{{Coin.TEN_PENCE,1},{Coin.TWO_PENCE,3}}, 16);
		validateMockitoUsage();
	}
	
	@Test
	public void testChangeWhen10and5And3Of2Pence() throws Exception { 		
		setupAvailableCoins(new Object[][]{{Coin.TEN_PENCE, 1},{Coin.FIVE_PENCE, 1}, {Coin.TWO_PENCE, 3}});
		
		testCoinChange(new Object[][]{{Coin.TEN_PENCE,1},{Coin.TWO_PENCE,3}}, 16);
		validateMockitoUsage();
	}
	
	private void testMockSingleCoinChangeReceivedWhenStoreDoesNotHaveIt(Coin coin, int numberOfCoins) throws Exception {
		when(coinStore.hasCoins(any(),anyInt())).thenReturn(false);
		validateMockitoUsage();
		coinChangeTest(new HashMap(), getAtm().getOptimalChangeFor(coin.getPence() * numberOfCoins));
	}
	
	private void testMockSingleCoinChangeReceived(Coin coin, int numberOfCoins) throws Exception {
		setupAvailableCoins(new Object[][]{{coin,numberOfCoins}});		
		validateMockitoUsage();
		testSingleCoinChangeReceived(coin, numberOfCoins);
	}
}
