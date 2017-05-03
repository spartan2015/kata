package hackerRank.recursive;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class PowerSum {

	@Test
	public void t(){
		assertEquals(Long.valueOf(1),Long.valueOf(max(100,1, 3)));
		assertEquals(Long.valueOf(3),Long.valueOf(max(100,1, 2)));
		assertEquals(Long.valueOf(1),Long.valueOf(max(10,1, 2)));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long X = in.nextLong();
		long N = in.nextLong();
		
		System.out.println(max(X,1, N));
	}

	private static long max(long x, int index, long n) {
		if (x ==0) return 1;
		
		long count = 0;
		
		for(int i = index; ; i++){
			double powe = Math.pow(i,n);
			if (powe > x) break;
			
			if (powe <= x) 
				count+= max((long)(x-powe),i+1, n);
		}
		
		return count;
	}
	
}
