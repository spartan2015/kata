package test.coinchange.domain.impl;

public class InsuficientCoinsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsuficientCoinsException() {
		super("Insuficient coins");
	}

}
