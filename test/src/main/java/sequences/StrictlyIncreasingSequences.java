package sequences;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.junit.Test;

/**
 * 
 * Results so far: 0 9 20 21
 * 
 * works
 * 
 * 1 runtime errors
 * 
 * timeout: 10 failed: 8
 * 
 * thinking - how many actual integer change so what is a change - a swap ? 12 -
 * goest to 12 - I just changed the position not the actual values
 * 
 * what if we reduce change count due to actual swapping... thinking like -
 * sorting then comparing... sort compare swap dilema
 * 
 * 
 * Limitation: permutations - too much to process - same old problem for dynamic programming
 * would bottom-up work ? not sure...too advanced for a market price job
 * 
 * test with input01.txt - expected 25940
 * 
 * @author vasil
 *
 */
public class StrictlyIncreasingSequences {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try (Scanner scan = new Scanner(System.in)) {
			int no = scan.nextInt();
			if (no == 0) {
				System.out.println("0");
				return;
			}
			System.out.println("Number: " + no);
			int limit = no;
			no = limit;
			long[] arr = new long[no];
			for (int i = 0; no - i > 0 & i < limit; i++) {
				arr[i] = scan.nextInt();
			}
			
			long[] cl = arr.clone();
			Arrays.sort(cl);
			
			
			
			//System.out.println(Arrays.toString(arr));
			System.out.println("Processing..." + limit);
			System.out.println(new StrictlyIncreasingSequences().howMany(cl, cl.clone(), 0));
		}
		System.out.println("time: " + TimeUnit.MILLISECONDS.toSeconds((System.currentTimeMillis() - start)));
		System.out.println("Finished");
	}

	@Test
	public void test1() {
		assertEquals(1, howMany(new long[] { 1, 2, 5, 4 }, 0));
	}

	@Test
	public void test11() {
		assertEquals(0, howMany(new long[] { 4, 10, 20 }, 0));
	}

	@Test
	public void test2() {
		assertEquals(3, howMany(new long[] { 1, 2, 2, 3, 4 }, 0));
	}

	@Test
	public void test3() {
		assertEquals(1, howMany(new long[] { 1, 7, 10, 2, 20, 22 }, 0));
	}

	@Test
	public void test4() {
		assertEquals(1, howMany(new long[] { 8, 1 }, 0));
	}

	@Test
	public void test5() {
		assertEquals(3, howMany(new long[] { 18, 19, 13, 11, 12, 13 }, 0));
	}

	@Test
	public void test6() {
		assertEquals(5, howMany(new long[] { 6, 5, 4, 3, 2, 1 }, 0));
	}

	@Test
	public void test7() {
		assertEquals(0, howMany(new long[] { 1, 2, 3, 4, 5, 6 }, 0));
	}

	@Test
	public void test8() {
		assertEquals(2, howMany(new long[] { 8, 2, 3, 4, 5, 6, 1 }, 0));
	}

	@Test
	public void test9() {
		assertEquals(6, howMany(new long[] { 1, 2, 3, 1, 2, 3, 1, 2, 3 }, 0));
	}

	@Test
	public void test10() {
		assertEquals(5, howMany(new long[] { 1, 2, 2, 2, 2, 2, 2 }, 0));
	}

	@Test
	public void test12() {
		long[] big = new long[1_000_000];
		assertEquals(1_000_000 - 1, howMany(big, 0));
	}

	@Test
	public void test13() {
		long[] big = new long[1_000_000];
		assertEquals(1, howMany(new long[] { 3, 1_000_000_000, 5 }, 0));
	}

	@Test
	public void test14() {
		long[] big = new long[1_000_000];
		assertEquals(1, howMany(new long[] { 1_000_000_000, 2, 3 }, 0));
	}

	@Test
	public void test15() {
		long[] big = new long[1_000_000];
		assertEquals(0, howMany(new long[] { 1_000_000_000 }, 0));
	}

	@Test
	public void test16() {
		long[] big = new long[1_000_000];
		assertEquals(0, howMany(new long[] { 1, 1_000_000_000 }, 0));
	}

	public long howMany(long[] orig, int startAt) {
		return howMany(orig, orig.clone(), startAt);
	}

	public long howMany(long[] orig, long[] value, int startAt) {
		int index = startAt;

		if (index + 1 > value.length - 1) {
			return compare(value, orig);
		}

		while (index + 1 < value.length && value[index] < value[index + 1]) {
			index++;
		}
		boolean mismatch = index + 1 <= value.length - 1 && value[index] >= value[index + 1];
		if (index + 1 == value.length - 1 && !mismatch) {
			return compare(value, orig);
		} else {
			long[] first = value.clone();
			long firstValue = Long.MAX_VALUE;
			int ret = -1;
//			if ((ret = adapt(first, index, false)) != -1) {
//				firstValue = howMany(orig, first, ret);
//			}
			// System.out.println(Arrays.toString(first) + " - " + " - false");
			long[] second = value.clone();
			long secondValue = Long.MAX_VALUE;
			if ((ret = adapt(second, index, true)) != -1) {
				secondValue = howMany(orig, second, ret);
			}
			// System.out.println(Arrays.toString(second) + " - " + " - true");
			if (firstValue == -1)
				firstValue = Long.MAX_VALUE;
			if (secondValue == -1)
				secondValue = Long.MAX_VALUE;
			return Math.min(firstValue, secondValue);
		}
	}

	private static long compare(long[] value, long[] orig) {
		long changes = 0;
		for (int i = 0; i < orig.length; i++) {
			if (value[i] != orig[i]) {
				changes++;
			}
		}
		return changes;
	}

	public int adapt(long[] value, int index, boolean forwards) {
		// in place 1 integer - current index change - if dif
		if (index + 1 < value.length && index - 1 >= 0 && value[index + 1] - value[index - 1] > 1) {
			value[index] = Math.min(value[index - 1], value[index + 1]) + 1;
			return index + 1;
		}
		if (forwards) {
			while (index + 1 < value.length && value[index + 1] <= value[index]) {
				if (value[index] + 1 > 1_000_000_000) {
					return -1;
				} else {
					value[index + 1] = value[index] + 1;
					index++;
				}
			}
			return index;
		} else {
			index++; // 12[3]{356} would need to go to 012{356}
			int copyIndex = index;
			while (index < value.length && index - 1 >= 0 && value[index] <= value[index - 1]) {
				if (value[index] - 1 <= 0) {
					return -1;
				} else {
					value[index - 1] = value[index] - 1;
					index--;
				}
			}

			return copyIndex;
		}

	}
}
