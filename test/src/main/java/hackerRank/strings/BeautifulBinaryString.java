package hackerRank.strings;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class BeautifulBinaryString {

	@Test
	public void t() {
		assertEquals(Integer.valueOf(2), Integer.valueOf(counter("0101010")));
		assertEquals(Integer.valueOf(0), Integer.valueOf(counter("01100")));
		assertEquals(Integer.valueOf(3), Integer.valueOf(counter("0100101010")));
		
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();

		String str = in.next();
		
		System.out.println(counter(str));
	}

	private static int counter(String str) {
		int count = 0;
		for (int i = 0; i < str.length() - 2;) {
			if (match(i, str)) {
				count++;
				i+=3;
			}else{
				i++;
			}
		}
		return count;
	}

	private static boolean match(int i, String str) {
		return str.charAt(i) == '0' && str.charAt(i + 1) == '1' && str.charAt(i + 2) == '0';
	}
}
