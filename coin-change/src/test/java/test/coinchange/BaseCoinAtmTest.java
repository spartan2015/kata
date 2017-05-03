package test.coinchange;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import test.coinchange.domain.Atm;
import test.coinchange.domain.Coin;
import test.coinchange.domain.CoinStore;

public abstract class BaseCoinAtmTest {
	protected abstract Atm getAtm();

	protected abstract CoinStore getCoinStore();

	protected Map<Coin, Long> buildCombinedCoinMap(Object[][] coinsArray) {
		Map<Coin, Long> expected = new HashMap<>();
		for (int i = 0; i < coinsArray.length; i++) {
			expected.put((Coin) coinsArray[i][0], Long.valueOf((Integer) coinsArray[i][1]));
		}
		return expected;
	}

	protected void testCoinChange(Object[][] expectedCoins, int pence) throws Exception {
		Map<Coin, Long> expected = buildCombinedCoinMap(expectedCoins);
		coinChangeTest(expected, getAtm().getOptimalChangeFor(pence));
	}

	protected void testSingleCoinChangeReceived(Coin coin, int expectedCoins) throws Exception {
		Map<Coin, Long> expected = buildSingleCoinMap(coin, expectedCoins);
		coinChangeTest(expected, getAtm().getOptimalChangeFor(coin.getPence() * expectedCoins));
	}

	protected Map<Coin, Long> buildSingleCoinMap(Coin coin, int expectedCoins) {
		Map<Coin, Long> expected = new HashMap<>();
		expected.put(coin, Long.valueOf(expectedCoins));
		return expected;
	}

	protected void coinChangeTest(Map<Coin, Long> expectedChangeMap, Collection<Coin> receivedChange) {
		Map<Coin, Long> receivedCoinsMap = mapReceivedChange(receivedChange);

		assertEquals("Expected coin types", expectedChangeMap.size(), receivedCoinsMap.size());
		for (Coin coin : expectedChangeMap.keySet()) {
			assertEquals(String.format("Expected %s", coin), expectedChangeMap.get(coin), receivedCoinsMap.get(coin));
		}
	}

	protected Map<Coin, Long> mapReceivedChange(Collection<Coin> receivedChange) {
		return receivedChange.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}

	protected void setupAvailableCoins(Object[][] availableCoinsArray) {
		Map<Coin, Long> availableCoinsMap = buildCombinedCoinMap(availableCoinsArray);
		setupCoinStoreValue(availableCoinsMap, Coin.POUND);
		setupCoinStoreValue(availableCoinsMap, Coin.FIFTY_PENCE);
		setupCoinStoreValue(availableCoinsMap, Coin.TWENTY_PENCE);
		setupCoinStoreValue(availableCoinsMap, Coin.TEN_PENCE);
		setupCoinStoreValue(availableCoinsMap, Coin.FIVE_PENCE);
		setupCoinStoreValue(availableCoinsMap, Coin.TWO_PENCE);
		setupCoinStoreValue(availableCoinsMap, Coin.ONE_PENNY);
	}

	protected void setupCoinStoreValue(Map<Coin, Long> availableCoinsMap, Coin coin) {
		final Integer coinCount = (Integer) availableCoinsMap.getOrDefault(coin, 0l).intValue();
		when(getCoinStore().hasCoins(eq(coin), anyInt())).then(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				return (Integer) invocation.getArguments()[1] <= coinCount ? true : false;
			}
		});
	}
}
