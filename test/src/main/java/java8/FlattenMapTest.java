package java8;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FlattenMapTest {

	@Test
	public void t() {

		List<String> words = Arrays.asList("Hello", "World");
		words.stream().flatMap(word -> Arrays.asList(word.split("")).stream()).distinct().forEach(System.out::println);

		words.stream().map(word -> word.split("")).map(Arrays::stream).distinct().forEach(System.out::println);

	}

}
