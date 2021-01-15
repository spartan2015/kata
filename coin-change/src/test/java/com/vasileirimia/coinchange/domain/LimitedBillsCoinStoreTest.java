package com.vasileirimia.coinchange.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * LimitedBillsCoinStoreTest
 */
public class LimitedBillsCoinStoreTest {

    @Test
    public void shouldBeAbleToPutCoins() {
        LimitedBillsCoinStore store = new LimitedBillsCoinStore();
        int expectedNoOfCoins = 1000;
        Coin denomination = Coin.FIFTY_PENCE;
        store.put(denomination, expectedNoOfCoins);
        assertEquals(expectedNoOfCoins, store.get(denomination));
    }

    @Test
    public void shouldBeAbleToTellHowMuchCoinsItHas() {
        LimitedBillsCoinStore store = new LimitedBillsCoinStore();
        int expectedNoOfCoins = 1000;
        Coin denomination = Coin.FIFTY_PENCE;
        store.put(denomination, expectedNoOfCoins);
        assertTrue(store.hasCoins(denomination, expectedNoOfCoins));
    }

    @Test
    public void shouldRejectAddingCoinsAboveLimit() {
        Coin denomination = Coin.FIFTY_PENCE;
        LimitedBillsCoinStore store = new LimitedBillsCoinStore();
        Assertions.assertThrows(InputContraintException.class, () -> {
            store.put(denomination, 100001);
        });
    }

}
