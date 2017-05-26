package hackerRank.bitwise;

import java.util.Scanner;

import org.junit.Test;

public class MaximizingXor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long L = in.nextLong();
		long R = in.nextLong();
		
		System.out.println(max(L,R));
	}

	@Test
	public void t(){
		System.out.println(max(1,10));;
	}
	
	private static long max(long l, long r) {
		long max = 0;
		for(long i = l; i<=r;i++){
			for(long j = l; j<=r;j++){
				System.out.println(i + " ^ " + j);
				max =Math.max(max,i^j);
			}
		}
		
		return max;
	}
}
