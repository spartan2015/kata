package com.vasileirimia.coinchange.domain;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * LimitedBillsCoinStore
 */
public class LimitedBillsCoinStore implements CoinStore {

    public static final int LIMIT_OF_BILLS = 100_000;
    private final ConcurrentHashMap<Coin, Integer> store = new ConcurrentHashMap<>();
    private int noOfBills;

    @Override
    public synchronized int get(Coin coin) {
        return store.getOrDefault(coin, 0);
    }

    @Override
    public synchronized int substract(Coin coin, int requiredNumberOfCoins) {
        final AtomicLong extractedRef = new AtomicLong();
        store.compute(coin, (key, value) -> {
            if (value != null) {
                int extracted = Math.min(requiredNumberOfCoins, value);
                extractedRef.set(extracted);
                noOfBills -= extracted;
                return value - extracted;
            } else {
                return null;
            }
        });

        return (int) extractedRef.get();
    }

    @Override
    public synchronized boolean hasCoins(Coin coin, int count) {
        return store.getOrDefault(coin,0 ) >= count;
    }

    @Override
    public synchronized void put(Coin coin, int numberOfCoins) {
        if (noOfBills + numberOfCoins > LIMIT_OF_BILLS) {
            throw new InputContraintException(String.format("Cannot add all the bills. Capacity exceeded by %d",
                    Math.abs(LIMIT_OF_BILLS - (noOfBills + numberOfCoins))));
        }
        noOfBills += numberOfCoins;
        store.merge(coin, numberOfCoins, Integer::sum);
    }

}
