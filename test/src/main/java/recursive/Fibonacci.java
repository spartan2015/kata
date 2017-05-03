package recursive;

import static org.junit.Assert.*;

import org.junit.Test;

public class Fibonacci {

	@Test
	public void testRecursive(){
		generateFibonacci(10); // 1 1 2 3 5 8 13 21 34 55
		
		assertTrue(1 == generatedNthFibonaciRecursive(3));
		assertTrue(2 == generatedNthFibonaciRecursive(4));
		assertTrue(3 == generatedNthFibonaciRecursive(5));
		assertTrue(5 == generatedNthFibonaciRecursive(6));
		assertTrue(8 == generatedNthFibonaciRecursive(7));
	}
	
	@Test
	public void testRecursiveIterative(){
		generateFibonacci(10); // 1 1 2 3 5 8 13 21 34 55
		
		assertTrue(1 == generateFibonacciIterative(3));
		assertTrue(2 == generateFibonacciIterative(4));
		assertTrue(3 == generateFibonacciIterative(5));
		assertTrue(5 == generateFibonacciIterative(6));
		assertTrue(8 == generateFibonacciIterative(7));
	}
	
	public int generatedNthFibonaciRecursive(int nth) {
		if (nth == 1) return 0;
		if (nth == 2) return 1;
		return generatedNthFibonaciRecursive(nth-1)+ generatedNthFibonaciRecursive(nth-2);
	}
	
	public int generateFibonacciIterative(int nth) {
		int[] fibo = {0,1};
		int count = 2;
		while(count++ < nth){			
			fibo = new int[]{fibo[1], fibo[0]+fibo[1]};
		}
		return fibo[1];
	}

	private void generateFibonacci(int howMany) {
		int[] fibo = {0,1};
		while(howMany-- > 0){
			System.out.println(fibo[1]);
			fibo = new int[]{fibo[1], fibo[0]+fibo[1]};
		}
	}
}
