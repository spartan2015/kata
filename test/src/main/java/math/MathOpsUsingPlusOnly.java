package math;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathOpsUsingPlusOnly {

	@Test
	public void test(){
		assertTrue(2 == divide(5, 2));
		
		assertTrue(-20 == multiply(10, -2));
	}
	
	private int negate(int i) {
		int result = 0;
		int using = i < 0 ? 1 : -1;
		while (i != 0) {
			result += using;
			i += using;
		}
		return result;
	}

	int minus(int n, int m){
		return n + negate(m);
	}
	
	int multiply(int n, int m) {
		if (m > n) return multiply(m,n); // optimization
		
		int result = 0;
		
		int absM = abs(m);
		while (absM > 0) {
			result += n;
			absM--;
		}
		return m < 0 ? negate(result) : result;
	}
	
	int divide(int n, int m){
		if (m == 0){
			throw new IllegalArgumentException("division by zero");
		}
		int count = 0;
		int sum = 0;
		while(m < n + negate(sum)){
			count++;
			sum+=m;
		}
		return count;
	}
	
	int abs(int n){
		if (n < 0) return negate(n);
		return n;
	}
	
	boolean differentSigns(int a, int b){
		return (a >0 && b < 0) || (a < 0 && b > 0);
	}
}