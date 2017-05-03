package com.java.training;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class StringBuilderDoesNotOverrideEquals {

	@Test
	public void stringBuilderDoesNotOverrideEquals() {

		StringBuilder sb1 = new StringBuilder("a");
		StringBuilder sb2 = new StringBuilder("b");

		assertFalse(sb1.equals(sb2));
	}

	enum A {
		A
	}

	@Test
	public void enumValueOfMustMatchExactly() {

		expectException(() -> {
			A.valueOf("a");
		});

	}

	public void expectException(Runnable run) {
		expectException(run,Exception.class);
	}

	public void expectException(Runnable run, Class<?> exceptionClazz) {
		try {
			run.run();
			throw new RuntimeException("Exception was expected");
		} catch (Exception ex) {
			// ignore - was expecting this
			if (!(exceptionClazz.isAssignableFrom(ex.getClass()))) {
				throw new RuntimeException("expecting: " + exceptionClazz + " but got " + ex.getClass());
			}
			System.out.println("expected exception");
		}
	}

}
