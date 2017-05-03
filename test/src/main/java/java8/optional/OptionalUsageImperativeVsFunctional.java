package java8.optional;

import java.util.Optional;

public class OptionalUsageImperativeVsFunctional {
	void threeDigit(Optional<Integer> optional) {
		if (optional.isPresent()) { // Outer if
			Integer num = optional.get();
			String string = "" + num;
			if (string.length() == 3) // inner if
				System.out.println(string);
		}
	}

	void threeDigitFunctional(Optional<Integer> optional) {
		optional.map(i -> i.toString())
		.filter(s -> s.length() > 3)
		.ifPresent(System.out::println);
	}
}
