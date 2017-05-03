package test;

import java.util.Random;

public class TestMathRandom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println((int) (Math.random() * 10000));			
		}
		
	}

}
