package com.vasileirimia.coinchange.domain;

public enum Coin {
	/**
	 * enum elements must be ordered by value from highest to lowest value
	 */
	POUND(100), FIFTY_PENCE(50), TWENTY_PENCE(20), TEN_PENCE(10),FIVE_PENCE(5), TWO_PENCE(2), ONE_PENNY(1);
	int pence;

	private Coin(int pence) {
		this.pence = pence;
	}

	public int getPence() {
		return pence;
	}

	public String toString() {
		return "Coin[" + pence + "]";
	}

	public static Coin fromPence(int pence){
		if (pence == 100){
			return Coin.POUND;
		}else if (pence == 50){
			return Coin.FIFTY_PENCE;
		}else if (pence == 20){
			return Coin.TWENTY_PENCE;
		}else if (pence == 10){
			return Coin.TEN_PENCE;
		}else if (pence == 5){
			return Coin.FIVE_PENCE;
		}else if (pence == 2){
			return Coin.TWO_PENCE;
		}else if (pence == 1){
			return Coin.ONE_PENNY;
		}else{
			throw new IllegalArgumentException("Coin not supported: " + pence + "p");
		}
	}
}
