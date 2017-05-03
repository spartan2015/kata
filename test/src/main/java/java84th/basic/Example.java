package java84th.basic;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import org.junit.Test;

class Apple {
	private int weight;

	public Apple() {
	}

	public Apple(int weight) {
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}

class CityBreak {
	long price;
	String location;

	public CityBreak(String location, long price) {
		this.location = location;
		this.price = price;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}

public class Example {

	@Test
	public void t() {

		Comparator<Apple> byWeight = new Comparator<Apple>() {
			@Override
			public int compare(Apple apple1, Apple apple2) {
				return Integer.compare(apple1.getWeight(), apple2.getWeight());
			}
		};

		List<CityBreak> cityBreaks = Arrays.asList(new CityBreak("Viena", 210), new CityBreak("Viena", 190),
				new CityBreak("Viena", 140), new CityBreak("Berlin", 130), new CityBreak("London", 230));

		Map<String, List<CityBreak>> groupByCity = new HashMap<>();
		for (CityBreak cityBreak : cityBreaks) {
			if (cityBreak.getPrice() < 200) {
				List<CityBreak> group = groupByCity.get(cityBreak.getLocation());
				if (group == null) {
					group = new ArrayList<>();
					groupByCity.put(cityBreak.getLocation(), group);
				}
				group.add(cityBreak);
			}
		}

		Map<String, List<CityBreak>> groupByCity1 = cityBreaks.parallelStream().filter(c -> c.getPrice() < 200)
				.collect(groupingBy(CityBreak::getLocation));

		cityBreaks.sort(comparing(CityBreak::getLocation));
	}

	static String format(int i) {
		if (i % 3 == 0) {
			return "Fizz";
		} else if (i % 5 == 0) {
			return "Buzz";
		} else if (i % 7 == 0) {
			return "Buzz7";
		} else {
			return Integer.toString(i);
		}
	}

	static void print(int start, int end) {

		IntFunction<String> mapper = i -> Integer.toString(i);
		mapper = Example::format;

		IntStream.rangeClosed(1, 150).mapToObj(mapper).forEach(System.out::println);
		;

	}

	static <T> void forEach(List<T> list, Consumer<T> c) {
		for (T t : list) {
			c.accept(t);
		}
	}

	static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> result = new ArrayList<>();
		for (T t : list)
			result.add(f.apply(t));
		return result;
	}

	void t123() {
		List<String> list = null;
		// Predicate has a boolean return
		Predicate<String> p = s -> list.add(s);
		// Consumer has a void return
		Consumer<String> b = s -> list.add(s);

	}

	interface FormatNumber {
		String formatNumber(int i);
	}

	static class FormatNumberFizzBuzz implements FormatNumber {
		public String formatNumber(int i) {
			if (i % 3 == 0) {
				return "Fizz";
			} else if (i % 5 == 0) {
				return "Buzz";
			} else if (i % 7 == 0) {
				return "FizzBuzz";
			} else {
				return Integer.toString(i);
			}
		}
	}

	// FizzBuzz
	void printNumber(int i1, int i2, FormatNumber formatter) {
		for (int i = i1; i < i2; i++) {
			String result = formatter.formatNumber(i);
			System.out.println(result);
		}
	}

	void testPrintNumber() {
		printNumber(1, 10, new FormatNumberFizzBuzz());

		printNumber(1, 10, i -> i * 2 + "");

		printNumber(1, 10, i -> Integer.toString(i * i));

		printApples(null, a -> "Apple");
		printApples(null, a -> "Hello");
		printApples(null, Apple::getWeight);

	}

	void printApples(List<Apple> inventory, Function<Apple, String> formatter) {

		inventory.parallelStream().map(formatter).forEach(System.out::println);

		Predicate<Apple> weightGt100 = a -> a.getWeight() > 100;
		Predicate<Apple> weightGt100Lt200 = weightGt100.and(a -> a.getWeight() < 200);
		Predicate notWeightGt100 = weightGt100.negate();
		Predicate<Apple> weightGt100OrLt200 = weightGt100.or(a -> a.getWeight() < 200);

		inventory.parallelStream().filter(weightGt100Lt200);

		Consumer<Apple> action = System.out::println;
		Consumer<Apple> action2 = a -> {
			System.out.println(a);
		};
		inventory.parallelStream()
			.filter(weightGt100Lt200)
			.forEach(action);
		
		Function<Apple, Integer> mapper = a->a.getWeight();
		inventory.stream().map(mapper).forEach(System.out::println);

	}

}
