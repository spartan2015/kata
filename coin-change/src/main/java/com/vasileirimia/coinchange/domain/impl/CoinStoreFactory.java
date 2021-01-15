package com.vasileirimia.coinchange.domain.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.vasileirimia.coinchange.domain.Coin;
import com.vasileirimia.coinchange.domain.CoinStore;

public class CoinStoreFactory {

	private static final Path COIN_INVENTORY_FILE = Paths.get("coin-inventory.properties");

	static class CoinStoreFactoryHolder {
		private static final CoinStoreFactory INSTANCE = new CoinStoreFactory();
	}

	private class DefaultCoinStore implements CoinStore {
		private ConcurrentHashMap<Coin, Integer> store = new ConcurrentHashMap<>();

		private DefaultCoinStore() {

		}

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
					return value - extracted;
				} else {
					return null;
				}
			});
			save(this);
			return (int) extractedRef.get();
		}

		@Override
		public synchronized boolean hasCoins(Coin coin, int count) {
			return store.get(coin) >= count;
		}

		@Override
		public synchronized void put(Coin coin, int numberOfCoins) {
			store.merge(coin, numberOfCoins, Integer::sum);
			save(this);
		}
	}

	private DefaultCoinStore coinStore;

	public static CoinStoreFactory getInstance() {
		return CoinStoreFactoryHolder.INSTANCE;
	}

	public void delete() {
		if (coinStore != null) {
			synchronized (CoinStoreFactory.class) {
				if (coinStore != null) {
					try {
						if (Files.exists(getFileStorePath())) {
							Files.delete(getFileStorePath());
						}
						coinStore = null;
					} catch (IOException e) {
						throw new RuntimeException("Unable to delete coin store file", e);
					}
				}
			}
		}
	}

	public CoinStore getDefaultCoinStore() {
		if (coinStore == null) {
			synchronized (CoinStoreFactory.class) {
				if (coinStore == null) {
					coinStore = new DefaultCoinStore();
					try {
						if (Files.exists(getFileStorePath())) {
							Files.readAllLines(getFileStorePath()).stream().forEach(line -> {
								parseCoinStoreLine(line);
							});
						}
						return coinStore;
					} catch (Exception e) {
						throw new RuntimeException("Failed to parse coint store file", e);
					}
				}
			}
		}
		return coinStore;
	}

	private synchronized void save(CoinStore coinStore) {
		try (PrintWriter pw = new PrintWriter(getFileStorePath().toFile())) {
			for (Coin coin : Coin.values()) {
				pw.write(coin.getPence() + " = " + coinStore.get(coin) + "\n");
			}
			pw.flush();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	private Path getFileStorePath() {
		return COIN_INVENTORY_FILE;
	}

	private void parseCoinStoreLine(String line) {
		String[] parts = line.split("=");
		coinStore.put(Coin.fromPence(java.lang.Integer.valueOf(parts[0].trim())), java.lang.Integer.valueOf(parts[1].trim()));
	}
}
