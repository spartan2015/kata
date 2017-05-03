package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Test;

public class Java8Session3Example {

	static class Coffee {
		String name;
		long price;
		boolean isStrong;
		int size;

		Coffee() {
		}

		Coffee(String name, long price, boolean isStrong,
				int size) {
			this.name = name;
			this.price = price;
			this.isStrong = isStrong;
			this.size = size;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public long getPrice() {
			return price;
		}

		public void setPrice(long price) {
			this.price = price;
		}

		public boolean isStrong() {
			return isStrong;
		}

		public void setStrong(boolean isStrong) {
			this.isStrong = isStrong;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

	}

	static List<Coffee> coffeeInventory = new ArrayList<>();
	static {
		coffeeInventory
				.add(new Coffee("Americana", 100, true, 3));
		coffeeInventory.add(new Coffee("Americana Latte",
				150, false, 5));
		coffeeInventory
				.add(new Coffee("Expresso", 110, true, 1));
	}

	@Test
	public void test() {

		List<Integer> nameSize = coffeeInventory.stream()
				.map(Coffee::getName).map(String::length)
				.collect(Collectors.toList());
		System.out.println(nameSize);

	}

	@Test
	public void test2() {
		coffeeInventory.stream().map(Coffee::getName)
				.map(word -> word.split(""))
				.flatMap(strArr -> Arrays.asList(strArr)
						.stream())
				.distinct().forEach(System.out::println);

	}

	@Test
	public void squareNumbers() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4,
				5);
		numbers.stream().map(i -> i * i)
				.forEach(System.out::println);
	}

	@Test
	public void allPairs() {
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);
		List<int[]> allPairs = numbers1.stream()
				.flatMap(
						i -> numbers2.stream()
								.filter(j -> i + j % 3 == 0)
								.map(j -> new int[] { i,
										j }))
				.filter(ints -> ints[0] + ints[1] % 3 == 0)
				.collect(Collectors.toList());

		allPairs.stream().forEach(ints -> {
			System.out.println(Arrays.toString(ints));
		});
	}

	@Test
	public void collectors() {
		long countCoffees = coffeeInventory.stream()
				.count();

		long count = coffeeInventory.stream()
				.mapToLong(c -> 1l).reduce(0l, Long::sum);

		long totalValue = coffeeInventory.stream().collect(
				Collectors.summingLong(Coffee::getPrice));

		LongSummaryStatistics statistics = coffeeInventory
				.stream().collect(Collectors
						.summarizingLong(Coffee::getPrice));

		Optional<Coffee> minSizeCoffee = coffeeInventory
				.stream()
				.collect(Collectors.minBy(Comparator
						.comparing(Coffee::getSize)));

		Coffee minSize = minSizeCoffee.get();

		List<Coffee> asList = coffeeInventory.stream()
				.collect(Collectors.toList());

		ArrayList<Coffee> asList2 = coffeeInventory.stream()
				.collect(Collectors
						.reducing(new ArrayList<Coffee>(),
								c -> (ArrayList) Arrays
										.asList(c),
								(list1, list2) -> {
									list1.addAll(list2);
									return list1;
								}));

	}

}
