package hackerRank;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import org.junit.Test;

public class StringWeight {

	@Test
	public void testContiguous() {
		allContiguousSubStrings("abc", System.out::println);
	}

	@Test
	public void weightT() {
		assertEquals(Integer.valueOf(1), Integer.valueOf(weight("a")));
		assertEquals(Integer.valueOf(26), Integer.valueOf(weight("z")));
		assertEquals(Integer.valueOf(27), Integer.valueOf(weight("az")));
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		int n = in.nextInt();

		Set<Integer> weights = new HashSet<>();
		char current=str.charAt(0);
		int count=1;
		weights.add(count * charWeight(current));
		
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) != current){
				count = 1;
				current = str.charAt(i);
			}else{
				count++;
			}
			weights.add(count * charWeight(current));
		}
		
		for (int i = 0; i < n; i++) {
			int x = in.nextInt();
			if (weights.contains(x)){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}
	}

	private static int charWeight(char c) {
		return c - 97 + 1;
	}

	private static void allContiguousSubStrings(String string, Consumer<String> consumer) {
		IntStream.rangeClosed(1, string.length()).forEach(substringLength -> {
			IntStream.rangeClosed(0, string.length() - substringLength).forEach(startAt -> {
				String sub = string.substring(startAt, startAt + substringLength);
				consumer.accept(sub);
			});
		});
	}

	int weight(String str) {
		int weight = 0;
		for (int i = 0; i < str.length(); i++) {
			weight += charWeight(str.charAt(i));
		}
		return weight;
	}

}
