package java8.optional;

import java.util.Optional;

import org.junit.Test;

public class OptionalOfOptionalTest {

	static Optional<Integer> calculator(Integer i) {
		return Optional.of(i);
	}

	@Test
	public void t() {
		Optional<Integer> optionalInteger = Optional.of(1);

		// optional.map
		Optional<Optional<Integer>> optionalOfOptional = optionalInteger.map(OptionalOfOptionalTest::calculator);
		//vs optional.flatMap
		Optional<Integer> op = optionalInteger.flatMap(OptionalOfOptionalTest::calculator);

	}

}
