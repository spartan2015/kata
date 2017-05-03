package test;

import org.junit.Test;

public class OverflowIntLong {

	@Test
	public void test(){
		long s = (3838380/2);
		System.out.println(s);
		System.out.println(s*s);
		System.out.println( (s * s) % 1_000_000_007);
		
	}
	
}
