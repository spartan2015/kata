package hackerRank;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

public class TwoCharacters {
	

	@Test
	public void test() {
		assertEquals(Integer.valueOf(5), Integer.valueOf(maxNonRepetitive("beabeefeab")));
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = in.nextInt();
		String s = in.next();

		System.out.println(new TwoCharacters().maxNonRepetitive(s));
	}


	private int maxNonRepetitive(String string) {
		Set<String> chars = Arrays.stream(string.split("")).filter(s -> s.length() == 1).collect(Collectors.toSet());
		String[] charsArray = (String[]) chars.toArray(new String[chars.size()]);

		combinations(2, charsArray);

		int max = 0;
		for (CombinationInfo combination : combinations) {
			String result = string.replaceAll("[^" + combination.list.get(0) + combination.list.get(1) + "]+", "");
			int i = 1;
			for (; i < result.length(); i++) {
				if (result.charAt(i - 1) == result.charAt(i)) {
					break;
				}
			}
			if (i == result.length()) {
				max = Math.max(max, result.length());
			}
		}

		return max;
	}

	List<CombinationInfo> combinations;

	private void combinations(int seqLength, String[] data) {
		if (seqLength == 1) {
			combinations = new ArrayList<>();
			for (byte i = 0; i < data.length; i++) {
				CombinationInfo ci = new CombinationInfo();
				ci.list = Arrays.asList(data[i]);
				ci.lastIndex = i;
				combinations.add(ci);
			}
		} else {
			if (combinations == null)
				combinations(seqLength - 1, data);
			List<CombinationInfo> prevCombs = combinations;
			combinations = new ArrayList<>();
			for (CombinationInfo combination : prevCombs) {
				for (int i = (combination.lastIndex + 1); i < data.length; i++) {
					CombinationInfo newComb = new CombinationInfo();
					newComb.lastIndex = i;
					newComb.list = new ArrayList(combination.list);
					newComb.list.add(data[i]);
					combinations.add(newComb);
				}
			}
		}
	}

	static class CombinationInfo {
		int lastIndex;
		List<String> list;
	}

}
