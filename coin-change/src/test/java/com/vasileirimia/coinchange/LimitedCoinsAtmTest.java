package com.vasileirimia.coinchange;


import com.vasileirimia.coinchange.domain.Atm;
import com.vasileirimia.coinchange.domain.Coin;
import com.vasileirimia.coinchange.domain.CoinStore;
import com.vasileirimia.coinchange.domain.impl.InsuficientCoinsException;
import com.vasileirimia.coinchange.domain.impl.LimitedCoinsAtm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class LimitedCoinsAtmTest extends BaseCoinAtmTest {
    private final LimitedCoinsAtm atm = new LimitedCoinsAtm();
    private final CoinStore coinStore = mock(CoinStore.class);

    @BeforeEach
    public void before() {
        atm.setCoinStore(coinStore);
    }

    @Test
    public void testChangeForZeroAmount() throws Exception {
        Collection<Coin> coinsChange = atm.widthdraw(0);
        validateMockitoUsage();
        assertTrue("Expected no coins for 0 amount", coinsChange.size() == 0);
    }

    @Test
    public void testChangeFor1PennyWhenStoreHasIt() throws Exception {
        testMockSingleCoinChangeReceived(Coin.ONE_PENNY, 1);
    }

    @Test
    public void testChangeFor1PennyWhenStoreDoesNotHaveIt() throws Exception {
        Assertions.assertThrows(InsuficientCoinsException.class, () -> {
            testMockSingleCoinChangeReceivedWhenStoreDoesNotHaveIt(Coin.ONE_PENNY, 1);
        });
    }

    @Test
    public void testChangeFor2PenceWhenStoreHasIt() throws Exception {
        testMockSingleCoinChangeReceived(Coin.TWO_PENCE, 1);
    }

    @Test
    public void testChangeFor2PenceWhenStoreDoesNotHaveIt() throws Exception {
        Assertions.assertThrows(InsuficientCoinsException.class, () -> {
            testMockSingleCoinChangeReceivedWhenStoreDoesNotHaveIt(Coin.TWO_PENCE, 1);
        });
    }

    @Test
    public void testChangeFor5PenceWhenStoreHasIt() throws Exception {
        testMockSingleCoinChangeReceived(Coin.FIVE_PENCE, 1);
    }

    @Test
    public void testChangeFor5PenceWhenStoreDoesNotHaveIt() throws Exception {
        Assertions.assertThrows(InsuficientCoinsException.class, () -> {
            testMockSingleCoinChangeReceivedWhenStoreDoesNotHaveIt(Coin.FIVE_PENCE, 1);
        });
    }

    @Test
    public void testChangeFor50PennyWhenStoreHasIt() throws Exception {
        testMockSingleCoinChangeReceived(Coin.FIFTY_PENCE, 1);
    }

    @Test
    public void testChangeFor50PennyWhenStoreDoesNotHaveIt() throws Exception {
        Assertions.assertThrows(InsuficientCoinsException.class, () -> {
            testMockSingleCoinChangeReceivedWhenStoreDoesNotHaveIt(Coin.FIFTY_PENCE, 1);
        });
    }

    @Test
    public void testChangeFor20PennyWhenStoreHasIt() throws Exception {
        testMockSingleCoinChangeReceived(Coin.TWENTY_PENCE, 1);
    }

    @Test
    public void testChangeFor20PennyWhenStoreDoesNotHaveIt() throws Exception {
        Assertions.assertThrows(InsuficientCoinsException.class, () -> {
            testMockSingleCoinChangeReceivedWhenStoreDoesNotHaveIt(Coin.TWENTY_PENCE, 1);
        });
    }

    @Test
    public void testChangeFor10PennyWhenStoreHasIt() throws Exception {
        testMockSingleCoinChangeReceived(Coin.TEN_PENCE, 1);
    }

    @Test
    public void testChangeFor10PennyWhenStoreDoesNotHaveIt() throws Exception {
        Assertions.assertThrows(InsuficientCoinsException.class, () -> {
            testMockSingleCoinChangeReceivedWhenStoreDoesNotHaveIt(Coin.TEN_PENCE, 1);
        });
    }

    @Test
    public void testChangeForOnePoundWhenStoreHasIt() throws Exception {
        testMockSingleCoinChangeReceived(Coin.POUND, 1);
    }

    @Test
    public void testChangeForOnePoundWhenStoreDoesNotHaveIt() throws Exception {

        Assertions.assertThrows(InsuficientCoinsException.class, () -> {
            testMockSingleCoinChangeReceivedWhenStoreDoesNotHaveIt(Coin.POUND, 1);
        });
    }

    @Test
    public void testChangeFor100PoundWhenStoreHasIt() throws Exception {
        long start = System.currentTimeMillis();
        testMockSingleCoinChangeReceived(Coin.POUND, 100);
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void testChangeFor1PoundAnd50PenceWhenStoreHasIt() throws Exception {
        setupAvailableCoins(
                new Object[][]{{Coin.POUND, 1}, {Coin.FIFTY_PENCE, 1}, {Coin.TWENTY_PENCE, 0}, {Coin.TEN_PENCE, 0}, {Coin.FIVE_PENCE, 0}, {Coin.TWO_PENCE, 0}, {Coin.ONE_PENNY, 0}});

        testCoinChange(new Object[][]{{Coin.POUND, 1}, {Coin.FIFTY_PENCE, 1}}, 150);
        validateMockitoUsage();
    }

    @Test
    public void testChangeForWhenPoundsAreNotAvailableBut50PencesAre() throws Exception {
        setupAvailableCoins(
                new Object[][]{{Coin.POUND, 0}, {Coin.FIFTY_PENCE, 2}, {Coin.TWENTY_PENCE, 0}, {Coin.TEN_PENCE, 0}, {Coin.FIVE_PENCE, 0}, {Coin.TWO_PENCE, 0}, {Coin.ONE_PENNY, 0}});

        testCoinChange(new Object[][]{{Coin.FIFTY_PENCE, 2}}, 100);
        validateMockitoUsage();
    }

    @Test
    public void testChangeWhenOnly20AreAvailable() throws Exception {
        setupAvailableCoins(
                new Object[][]{{Coin.POUND, 0}, {Coin.FIFTY_PENCE, 0}, {Coin.TWENTY_PENCE, 5}, {Coin.TEN_PENCE, 0}, {Coin.FIVE_PENCE, 0}, {Coin.TWO_PENCE, 0}, {Coin.ONE_PENNY, 0}});

        testCoinChange(new Object[][]{{Coin.TWENTY_PENCE, 5}}, 100);
        validateMockitoUsage();
    }

    @Test
    public void testChangeWhenOnly10AreAvailable() throws Exception {
        setupAvailableCoins(
                new Object[][]{{Coin.POUND, 0}, {Coin.FIFTY_PENCE, 0}, {Coin.TWENTY_PENCE, 0}, {Coin.TEN_PENCE, 10}, {Coin.FIVE_PENCE, 0}, {Coin.TWO_PENCE, 0}, {Coin.ONE_PENNY, 0}});

        testCoinChange(new Object[][]{{Coin.TEN_PENCE, 10}}, 100);
        validateMockitoUsage();
    }

    @Test
    public void testChangeWhenOnly5AreAvailable() throws Exception {
        setupAvailableCoins(
                new Object[][]{{Coin.POUND, 0}, {Coin.FIFTY_PENCE, 0}, {Coin.TWENTY_PENCE, 0}, {Coin.TEN_PENCE, 0}, {Coin.FIVE_PENCE, 20}, {Coin.TWO_PENCE, 0}, {Coin.ONE_PENNY, 0}});

        testCoinChange(new Object[][]{{Coin.FIVE_PENCE, 20}}, 100);
        validateMockitoUsage();
    }

    @Test
    public void testChangeWhenOnly2AreAvailable() throws Exception {
        setupAvailableCoins(
                new Object[][]{{Coin.POUND, 0}, {Coin.FIFTY_PENCE, 0}, {Coin.TWENTY_PENCE, 0}, {Coin.TEN_PENCE, 0}, {Coin.FIVE_PENCE, 0}, {Coin.TWO_PENCE, 50}, {Coin.ONE_PENNY, 0}});

        testCoinChange(new Object[][]{{Coin.TWO_PENCE, 50}}, 100);
        validateMockitoUsage();
    }

    @Test
    public void testChangeWhenOnly1AreAvailable() throws Exception {
        setupAvailableCoins(
                new Object[][]{{Coin.POUND, 0}, {Coin.FIFTY_PENCE, 0}, {Coin.TWENTY_PENCE, 0}, {Coin.TEN_PENCE, 0}, {Coin.FIVE_PENCE, 0}, {Coin.TWO_PENCE, 0}, {Coin.ONE_PENNY, 100}});

        testCoinChange(new Object[][]{{Coin.ONE_PENNY, 100}}, 100);
        validateMockitoUsage();
    }

    @Test
    public void testChangeWhen10and5And1AreAvailable() throws Exception {
        setupAvailableCoins(
                new Object[][]{{Coin.POUND, 0}, {Coin.FIFTY_PENCE, 0}, {Coin.TWENTY_PENCE, 0}, {Coin.TEN_PENCE, 5}, {Coin.FIVE_PENCE, 0}, {Coin.TWO_PENCE, 25}, {Coin.ONE_PENNY, 100}});

        testCoinChange(new Object[][]{{Coin.TEN_PENCE, 5}, {Coin.TWO_PENCE, 25}}, 100);
        validateMockitoUsage();
    }

    @Test
    public void testChangeWhen10and5And1AreAvailableException() throws Exception {
        setupAvailableCoins(new Object[][]{{Coin.TEN_PENCE, 1}, {Coin.TWO_PENCE, 3}});

        testCoinChange(new Object[][]{{Coin.TEN_PENCE, 1}, {Coin.TWO_PENCE, 3}}, 16);
        validateMockitoUsage();
    }

    @Test
    public void testChangeWhen10and5And3Of2Pence() throws Exception {
        setupAvailableCoins(new Object[][]{{Coin.TEN_PENCE, 1}, {Coin.FIVE_PENCE, 1}, {Coin.TWO_PENCE, 3}});

        testCoinChange(new Object[][]{{Coin.TEN_PENCE, 1}, {Coin.TWO_PENCE, 3}}, 16);
        validateMockitoUsage();
    }

    @Override
    protected Atm getAtm() {
        return atm;
    }

    @Override
    protected CoinStore getCoinStore() {
        return coinStore;
    }

    private void testMockSingleCoinChangeReceivedWhenStoreDoesNotHaveIt(Coin coin, int numberOfCoins) throws Exception {
        when(coinStore.hasCoins(any(), anyInt())).thenReturn(false);
        validateMockitoUsage();
        coinChangeTest(new HashMap(), getAtm().widthdraw(coin.getPence() * numberOfCoins));
    }

    private void testMockSingleCoinChangeReceived(Coin coin, int numberOfCoins) throws Exception {
        setupAvailableCoins(new Object[][]{{coin, numberOfCoins}});
        validateMockitoUsage();
        testSingleCoinChangeReceived(coin, numberOfCoins);
    }
}
