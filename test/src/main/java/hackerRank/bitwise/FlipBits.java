package hackerRank.bitwise;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class FlipBits {
	@Test
	public void test(){
		
		assertTrue(flip(0) == 4294967295l);
		assertTrue(flip(1) == 4294967294l);
		assertTrue(flip(4294967294l) == 1);
		assertTrue(flip(4294967295l) == 0);
		
		assertTrue(flip(5) == 0);
		
		//System.out.println(Long.toString(~0l>>>1,2));
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
	
		for(int i =0; i<n;i++){
			long nextInt = in.nextLong();
			System.out.println(flip(nextInt));
		}
		
	}

	private static long flip(long nextInt) {
		long max = ~0l >>> 32; 
		long result = max & (nextInt ^ ~0l>>>1);
		System.out.println(Long.toString(result, 2));
		return result ;
	}
}
