package java8.stream.collect;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * collect is a special case of reduce, a mutable reduction (using Consumer now
 * instead of BiFunction for reducing)
 */
public class CollectTest {

	@Test
	public void collect() {
		List<String> list = Stream.of("w", "o", "l", "f").collect(Collectors.toList());

		Stream.of("w", "o", "l", "f").collect(Collectors.toSet());

		Stream.of("w", "o", "l", "f").collect(Collectors.toCollection(TreeSet::new));
	}

	@Test
	public void collectToMap() {
		Function<? super Person, ? extends String> keyMapper = Person::getName;
		Function<? super Person, ? extends Person> valueMapper = p -> p;
		Map<String, Person> nameToPerson = persons.collect(Collectors.toMap(keyMapper, valueMapper));

		
		Function<String, String> keyMapper2 = s -> s.substring(0, 1);
		Function<String, String> valueMapper2 = s -> s;
		BinaryOperator<String> mergeFunction = (s1, s2) -> s1 + ";" + s2;
		
		Map<String,String> firstLetterToFullName = Stream.of("John", "Joe", "Mary", "Martin")
				.collect(Collectors.toMap(keyMapper2, valueMapper2, mergeFunction));
		
		Supplier<Map<String, String>> mapSupplier = HashMap::new;
		firstLetterToFullName = Stream.of("John", "Joe", "Mary", "Martin")
				.collect(Collectors.toMap(keyMapper2, valueMapper2, mergeFunction, mapSupplier));

	}

	@Test
	public void collect2() {
		Supplier<ArrayList<String>> supplier = ArrayList::new;
		BiConsumer<ArrayList<String>, ? super String> accumulator = (list, element) -> list.add(element);
		accumulator = List::add;
		BiConsumer<ArrayList<String>, ArrayList<String>> combiner = (list1, list2) -> list1.addAll(list2);
		combiner = List::addAll;
		List<String> result = Stream.of("w", "o", "l", "f").collect(supplier, accumulator, combiner);

		BiConsumer<StringBuilder, String> biConsumer = StringBuilder::append;
		BiConsumer<StringBuilder, StringBuilder> biConsumer2 = StringBuilder::append;

		Stream.of("w", "o", "l", "f").collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);

	}

	@Test
	public void collectors() {
		ToDoubleFunction<? super Integer> toDoubleFunction = d -> d;
		Stream.of(1, 1).collect(Collectors.averagingDouble(toDoubleFunction));

		ToIntFunction<? super Integer> toIntFunction = d -> (int) d;
		Stream.of(1, 1).collect(Collectors.averagingInt(toIntFunction));

		ToLongFunction<? super Integer> toLongFunction = d -> d;
		Stream.of(1, 1).collect(Collectors.averagingLong(toLongFunction));

		Long l = Stream.of(1, 1).collect(Collectors.counting());

	}

	@Test
	public void groupingBy() {

		String result1 = Stream.of("w", "o", "l", "f").collect(Collectors.joining());
		assertEquals("wolf", result1);
		String result2 = Stream.of("w", "o", "l", "f").collect(Collectors.joining(";"));
		assertEquals("w;o;l;f", result2);

		Map<Integer, List<String>> mapResult = Stream.of("John", "Mary", "Livia")
				.collect(Collectors.groupingBy(String::length));

		Map<Integer, Long> groupByNameLengthAndThenAgainByGroupSize = Stream.of("John", "Mary", "Livia")
				.collect(Collectors.groupingBy(String::length, Collectors.counting()));

		Map<Integer, Long> groupByNameLengthAndThenAgainByGroupSize1 = Stream.of("John", "Mary", "Livia")
				.collect(Collectors.groupingBy(String::length, HashMap::new, Collectors.counting()));
	}

	@Test
	public void collectorsMinMax() {
		Optional<String> min = Stream.of("John", "Mary", "Livia")
				.collect(Collectors.minBy(Comparator.comparing(String::length)));
		assertEquals("John", min.get());
		Optional<String> max = Stream.of("John", "Mary", "Livia")
				.collect(Collectors.maxBy(Comparator.comparing(String::length)));
		assertEquals("Livia", max.get());
	}

	static class Person {
		String name;
		String city;

		Person(String name, String city) {
			this.name = name;
			this.city = city;
		}

		public String getName() {
			return name;
		}

		public String getCity() {
			return city;
		}

	}

	Stream<Person> persons = Stream.of(new Person("John", "Boston"), new Person("Mary", "Los Angeles"));

	@Test
	public void mappingVsSecondGroup() {
		Collector<Person, ?, Set<String>> mapping = Collectors.mapping(Person::getName, Collectors.toSet());

		Map<String, Set<String>> groupByCityAndExtractJustNamesInSet = persons
				.collect(Collectors.groupingBy(Person::getCity, mapping));

		Map<String, Map<String, List<Person>>> a = persons
				.collect(Collectors.groupingBy(Person::getCity, Collectors.groupingBy(Person::getName)));
	}

	@Test
	public void paritioningVsGrouping() {
		Map<Boolean, List<Person>> partitions1 = persons
				.collect(Collectors.partitioningBy(p -> p.getName().length() > 4));

		Map<Boolean, List<Person>> partitions2 = persons
				.collect(Collectors.partitioningBy(p -> p.getName().length() > 4, Collectors.toList()));

		Map<Boolean, List<Person>> partitions3 = persons.collect(Collectors.groupingBy(p -> p.getName().length() > 4));
	}

	@Test
	public void collectStatistics() {

		ToIntFunction<? super Person> toIntFunction = person -> person.getName().length();
		IntSummaryStatistics iss = persons.collect(Collectors.summarizingInt(toIntFunction));

		ToLongFunction<? super Person> toLongFunction = person -> person.getName().length();
		LongSummaryStatistics lss = persons.collect(Collectors.summarizingLong(toLongFunction));

		ToDoubleFunction<? super Person> toDoubleFunction = person -> person.getName().length();
		DoubleSummaryStatistics dss = persons.collect(Collectors.summarizingDouble(toDoubleFunction));

		int isum = persons.collect(Collectors.summingInt(toIntFunction));
		long lsum = persons.collect(Collectors.summingLong(toLongFunction));
		double dsum = persons.collect(Collectors.summingDouble(toDoubleFunction));
		
		Double average1 = persons.collect(Collectors.averagingInt(toIntFunction));
		Double average2 = persons.collect(Collectors.averagingLong(toLongFunction));
		Double average3 = persons.collect(Collectors.averagingDouble(toDoubleFunction));
	}
}
