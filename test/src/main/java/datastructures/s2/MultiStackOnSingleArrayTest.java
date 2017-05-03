package datastructures.s2;

import static org.junit.Assert.assertEquals;

import java.util.stream.IntStream;

import org.junit.Test;

public class MultiStackOnSingleArrayTest {

	@Test
	public void testStacks() {
		MultiStackOnSingleArray<Integer> ss = new MultiStackOnSingleArray<>(100, 5);
		IntStream.rangeClosed(0, 4).forEach(stackNo -> {
			IntStream.rangeClosed(0, 99).forEach(e -> {
				ss.push(stackNo, e);
			});
		});

		IntStream.rangeClosed(0, 4).forEach(stackNo -> {
			IntStream.range(0, 99).forEach(i -> {
				assertEquals(Integer.valueOf(99 - i), ss.pop(stackNo));
			});
		});
	}
}
