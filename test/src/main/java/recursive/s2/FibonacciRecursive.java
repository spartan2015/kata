package recursive.s2;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciRecursive {

	@Test
	public void test(){
		assertEquals(Integer.valueOf(-1), Integer.valueOf(fibonacci(0)));
		assertEquals(Integer.valueOf(0), Integer.valueOf(fibonacci(1)));
		assertEquals(Integer.valueOf(1), Integer.valueOf(fibonacci(2)));
		assertEquals(Integer.valueOf(1), Integer.valueOf(fibonacci(3)));
		assertEquals(Integer.valueOf(2), Integer.valueOf(fibonacci(4)));
		assertEquals(Integer.valueOf(3), Integer.valueOf(fibonacci(5)));
		assertEquals(Integer.valueOf(5), Integer.valueOf(fibonacci(6)));
		assertEquals(Integer.valueOf(8), Integer.valueOf(fibonacci(7)));
	}
	
	@Test
	public void iterative(){
		assertEquals(Integer.valueOf(-1), Integer.valueOf(iterativeFibonacci(0)));
		assertEquals(Integer.valueOf(0), Integer.valueOf(iterativeFibonacci(1)));
		assertEquals(Integer.valueOf(1), Integer.valueOf(iterativeFibonacci(2)));
		assertEquals(Integer.valueOf(1), Integer.valueOf(iterativeFibonacci(3)));
		assertEquals(Integer.valueOf(2), Integer.valueOf(iterativeFibonacci(4)));
		assertEquals(Integer.valueOf(3), Integer.valueOf(iterativeFibonacci(5)));
		assertEquals(Integer.valueOf(5), Integer.valueOf(iterativeFibonacci(6)));
		assertEquals(Integer.valueOf(8), Integer.valueOf(iterativeFibonacci(7)));
	}
	
	public int fibonacci(int nth){
		if (nth < 1) return -1;
		if(nth == 1) return 0;
		if(nth == 2) return 1;
		return fibonacci(nth-1) + fibonacci(nth-2);
	}
	
	public int iterativeFibonacci(int nth){
		if (nth <= 0) return -1;
		if (nth == 1) return 0;
		if (nth == 2) return 1;
		int[] a = {0,1};
		int current = 2;
		while(current < nth){
			int tmp = a[1]; 
			a[1] = a[0]+a[1];
			a[0]=tmp;
			current++;
		}
		return a[1];
	}
}
