package hackerRank;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * 
 * THIS WAS HARD...
 * 
 * @author vasil
 *
 */
public class SherlockValidString {

	@Test
	public void t() {
		assertEquals("NO", isValidSherlock(new Scanner("aabbcd")));
		assertEquals("YES", isValidSherlock(new Scanner("aabbc")));
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(isValidSherlock(in));
	}

	private static String isValidSherlock(Scanner in) {
		String line = in.nextLine();
		if (line.length() == 0)
			return "YES";
		Map<String, Long> map = countLetters(line);

		TreeMap<Long, Long> count = map.values().stream()
				.collect(Collectors.groupingBy(i -> i, TreeMap::new, Collectors.counting()));

		if (count.size() == 0 || count.size() == 1
				|| (count.size() == 2 && count.firstEntry().getKey() - count.lastEntry().getKey() <= 1
						&& (count.firstEntry().getValue() == 1 || count.lastEntry().getValue() == 1))) {
			return "YES";
		} else {
			return "NO";
		}
	}

	private static Map<String, Long> countLetters(String a) {
		return Arrays.stream(a.split("")).filter(s -> s.length() > 0)
				.collect(Collectors.groupingBy(s -> s, Collectors.counting()));
	}
}
