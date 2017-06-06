package hackerRank;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class Sos {

	@Test
	public void t1() {
		assertEquals(Integer.valueOf(0), Integer.valueOf(altered("SOS")));
	}

	@Test
	public void t2() {
		assertEquals(Integer.valueOf(3), Integer.valueOf(altered("SOSSPSSQSSOR")));
	}

	@Test
	public void t3() {
		assertEquals(Integer.valueOf(1), Integer.valueOf(altered("SOSSOT")));
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String S = in.next();
		System.out.println(altered(S));
	}

	private static int altered(String string) {
		char[] expected = { 'S', 'O', 'S' };
		int count = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i)!=expected[i%3]){
				count++;
			}
		}
		return count;
	}
}
