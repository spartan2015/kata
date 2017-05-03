package hackerRank;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class CamelCase {
	@Test
	public void test() {
		assertEquals(Integer.valueOf(5), Integer.valueOf(howMany("saveChangesInTheEditor")));
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		System.out.println(howMany("saveChangesInTheEditor"));
	}

	private static int howMany(String string) {
		int count = string.length() > 0 ? 1 : 0;
		for (int i = 1; i < string.length(); i++) {
			if (65 <=string.charAt(i) && string.charAt(i)<=90) {
				count++;
			}
		}
		return count;
	}
}
