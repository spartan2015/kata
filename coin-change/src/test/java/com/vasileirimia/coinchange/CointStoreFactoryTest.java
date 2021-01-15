package com.vasileirimia.coinchange;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.vasileirimia.coinchange.domain.Coin;
import com.vasileirimia.coinchange.domain.CoinStore;
import com.vasileirimia.coinchange.domain.impl.CoinStoreFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CointStoreFactoryTest {
	private static final Path COIN_STORE_FILE_PATH = Paths.get("coin-inventory.properties");
	
	@AfterEach
	public void after(){
		CoinStoreFactory.getInstance().delete();
	}

	@Test
	public void ableToCreateCoinStore() {
		CoinStore coinStore = CoinStoreFactory.getInstance().getDefaultCoinStore();
		assertNotNull(coinStore);
	}
	
	@Test
	public void coinStoreFileIsCreated() {
		CoinStoreFactory.getInstance().getDefaultCoinStore().put(Coin.POUND, 1);
		assertTrue(Files.exists(COIN_STORE_FILE_PATH));
	}
	@Test
	public void ableToDeleteCoinStore() {
		CoinStoreFactory.getInstance().getDefaultCoinStore();
		
		CoinStoreFactory.getInstance().delete();
		
		assertFalse(Files.exists(COIN_STORE_FILE_PATH));
	}
	
	@Test
	public void initialPoundValueIsZero() {
		assertEquals(java.lang.Integer.valueOf(0), (java.lang.Integer)CoinStoreFactory.getInstance().getDefaultCoinStore().get(
				Coin.POUND));
	}	
	
	@Test
	public void canPutPoundValue() {
		CoinStore defaultCoinStore = CoinStoreFactory.getInstance().getDefaultCoinStore();
		
		defaultCoinStore.put(Coin.POUND, 100);
		
		assertEquals(java.lang.Integer.valueOf(100), (java.lang.Integer)defaultCoinStore.get(Coin.POUND));
	}
	
	@Test
	public void canSubstractPoundValue() {
		CoinStore defaultCoinStore = CoinStoreFactory.getInstance().getDefaultCoinStore();
		defaultCoinStore.put(Coin.POUND, 100);
		
		defaultCoinStore.substract(Coin.POUND, 51);
		
		assertEquals(java.lang.Integer.valueOf(49), (java.lang.Integer)defaultCoinStore.get(Coin.POUND));
	}
}
