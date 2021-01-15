package com.vasileirimia.coinchange.domain.impl;

public class InsuficientCoinsException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsuficientCoinsException() {
		super("Insuficient coins");
	}

}
