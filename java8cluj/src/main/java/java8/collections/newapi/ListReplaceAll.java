package java8.collections.newapi;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

import org.junit.Test;

public class ListReplaceAll {

	@Test
	public void applyUnaryOperatorToListWithReplaceAll() {

		List<Integer> ints = Arrays.asList(1, 2, 3);

		UnaryOperator<Integer> unaryOperator = i -> i * 2;

		ints.replaceAll(unaryOperator);

		ints.replaceAll(i -> i * 2);

		assertEquals(Integer.valueOf(4), ints.get(0));

		assertEquals(Arrays.asList(4, 8, 12), ints);
	}

	@Test
	public void replaceAll() {

		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");

		list.replaceAll((string) -> string + string);

		assertEquals(Arrays.asList("aa", "bb", "cc"), list);

	}
}
