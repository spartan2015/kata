package hackerRank.bitwise;

import java.math.BigInteger;
import java.util.Scanner;

public class SumVsXor {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		
		int count = 0;
		for(long i = 0; i <= n; i++){
			
			if ( n+i == (n^i) ){
				count++;
			}
		}
		System.out.println(count);
		
		/**
		 * this solution is interesting
		 * 
		 * how many numbers - so not bruteforcing but doing something different here
		 * 
		 * 
		 */
		 int empty = 64 - Long.numberOfLeadingZeros(n) - Long.bitCount(n);
		 System.out.println(new BigInteger("2").pow(empty));
		
	}
}
