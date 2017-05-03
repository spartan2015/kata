package algos2;

import static org.junit.Assert.*;

import org.junit.Test;

public class EuclidGcd {

	@Test
	public void t(){
		assertTrue(1 == gcd(24,11));
		assertTrue(2 == gcd(4,2));
	}
	
	private int gcd(int p, int q){
		if (q == 0){
			return p;
		}
		return gcd(q, p % q);		
	}
	
}
