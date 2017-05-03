package test.coinchange;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Test;

import test.coinchange.domain.Coin;
import test.coinchange.domain.CoinStore;
import test.coinchange.domain.impl.CoinStoreFactory;

public class CointStoreFactoryTest {
	private static final Path COIN_STORE_FILE_PATH = Paths.get("coin-inventory.properties");
	
	@After
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
		assertEquals(Integer.valueOf(0), (Integer)CoinStoreFactory.getInstance().getDefaultCoinStore().get(Coin.POUND));
	}	
	
	@Test
	public void canPutPoundValue() {
		CoinStore defaultCoinStore = CoinStoreFactory.getInstance().getDefaultCoinStore();
		
		defaultCoinStore.put(Coin.POUND, 100);
		
		assertEquals(Integer.valueOf(100), (Integer)defaultCoinStore.get(Coin.POUND));
	}
	
	@Test
	public void canSubstractPoundValue() {
		CoinStore defaultCoinStore = CoinStoreFactory.getInstance().getDefaultCoinStore();
		defaultCoinStore.put(Coin.POUND, 100);
		
		defaultCoinStore.substract(Coin.POUND, 51);
		
		assertEquals(Integer.valueOf(49), (Integer)defaultCoinStore.get(Coin.POUND));
	}
}
