package java8.third;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class Java8InAction {

	static class Apple {
		private int weight;
		private String color;

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}
	}

	@Test
	public void methodReferences() {
		List<Apple> list = new LinkedList<>();

		Function<Apple, Integer> f1 = Apple::getWeight;
		f1 = (a) -> a.getWeight();
		// reference to an instance method
		ToIntFunction<Apple> f2 = Apple::getWeight;

		// reference to a static method
		Runnable r = () -> Thread.dumpStack();
		r = Thread::dumpStack;

		// reference to an instance method of an existing object
		Consumer<String> con = System.out::println;

		list.sort(Comparator.comparing(Apple::getWeight));

		BiFunction<String, Integer, String> f3 = String::substring;
		f3 = (str, i) -> str.substring(i);

		// method reference ToInBiFunction
		new ArrayList<String>().sort(String::compareToIgnoreCase);
		new ArrayList<String>().sort((s1,s2) -> s1.compareToIgnoreCase(s2));
		ToIntBiFunction<String, String> bf = String::compareToIgnoreCase;

		Function<String, Integer> si = Integer::parseInt;
		ToIntFunction<String> si2 = Integer::parseInt;

		BiPredicate<List<String>, String> bp = List::contains;

		// contructor references
		Supplier<List> ls = ArrayList::new;
		ls = () -> new ArrayList();
		List l = ls.get();

		// constructor with parameters
		class Pie {
			int weight;
			int height;
			String color;

			Pie(int w) {
				weight = w;
			}

			Pie(int w, int h) {
				weight = w;
				height = h;
			}

			Pie(int w, int h, String color) {
				weight = w;
				height = h;
			}
		}
		Function<Integer, Pie> pieConstructor = Pie::new;
		Pie pie = pieConstructor.apply(10);

		BiFunction<Integer, Integer, Pie> biPie = Pie::new;
		Pie pie2 = biPie.apply(10, 20);

		// tri function does not exist but you can create one

		TriFunction<Integer, Integer, String, Pie> triPie = Pie::new;
		triPie.apply(1, 2, "red");

	}

	interface TriFunction<T1, T2, T3, R> {
		R apply(T1 t1, T2 t2, T3 t3);
	}

	@Test
	public void composingComparators() {

		Comparator<Apple> byWeight = Comparator.comparing(Apple::getWeight);

		Comparator<Apple> byWeightThenColor = byWeight.thenComparing(Apple::getColor);

		// reverse
		byWeightThenColor.reversed();

	}

	@Test
	public void composingPredicates() {

		Predicate<Apple> greaterThan100g = (a) -> a.getWeight() > 100;
		Predicate<Apple> red = (a) -> "red".equalsIgnoreCase(a.getColor());

		Predicate<Apple> notRed = red.negate();

		Predicate<Apple> greaterThan100gAndRed = greaterThan100g.and(red);

		Predicate<Apple> greaterThan100gOrRed = greaterThan100g.or(red);

		// preceden - from left to right: (a || b) && c
	}

	@Test
	public void composingFunction() {
		IntFunction add1 = (x) -> x + 1;
		IntFunction doubleIt = (x) -> 2 * x;
		// UNABLE TO COMPOSE IntFunction - has only 1 method - apply

		Function<Integer, Integer> fadd1 = (x) -> x + 1;
		Function<Integer, Integer> fdoubleIt = (x) -> 2 * x;

		Function<Integer, Integer> fadd1AndThenDoubleIt = fadd1.andThen(fdoubleIt);
		assertEquals(Integer.valueOf(4), fadd1AndThenDoubleIt.apply(1));

		Function<Integer, Integer> fDoubleItThenFAdd1 = fadd1.compose(fdoubleIt);
		assertEquals(Integer.valueOf(3), fDoubleItThenFAdd1.apply(1));

	}

	@Test
	public void newCollectionMethods() {
		List<Apple> apples = new LinkedList<>();
		List<Integer> appleWeightsAbove100g = apples.stream().filter((a) -> a.getWeight() > 100).map(Apple::getWeight)
				.sorted().limit(3).collect(java.util.stream.Collectors.toList());

		java.util.stream.Stream<Apple> applesStream = apples.stream();
		applesStream = apples.parallelStream();

		Map<Integer, List<Apple>> result = applesStream
				.collect(java.util.stream.Collectors.groupingBy(Apple::getWeight));

	}

	public static class Dish {
		private final String name;
		private final boolean vegetarian;
		private final int calories;
		private final Type type;

		enum Type {
			FISH, MEAT, OTHER
		}

		public Dish(String name, boolean vegetarian, int calories, Type type) {
						
			this.name = name;
			this.vegetarian = vegetarian;
			this.calories = calories;
			this.type = type;
		}

		public String getName() {
			return name;
		}

		public int getCalories() {
			return calories;
		}

		public boolean isVegetarian() {
			return vegetarian;
		}

		public Type getType() {
			return type;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));

	@Test
	public void simpleQueries() {

		List<String> threeHighCaloricDishNames = menu.stream().filter(d -> d.getCalories() > 300).map(Dish::getName)
				.sorted().limit(3).collect(Collectors.toList());
		System.out.println(threeHighCaloricDishNames);
	}

	@Test(expected = IllegalStateException.class)
	public void streamsAreConsumedOnlyOnceAndThrowExceptionIfYouTryThisAgain() {

		Stream<String> stream = Arrays.asList("a").stream();

		stream.forEach(System.out::println);

		// again ? nooooo....
		stream.forEach(System.out::println);
	}

	@Test
	public void filterWithPredicate() {

		menu.stream().filter(Dish::isVegetarian).count();

		menu.stream().distinct(); // USES EQUALS AND HASCODE TO COMPARE

		menu.stream().limit(3);

		menu.stream().skip(3);

	}

	@Test
	public void mapping() {
		menu.stream().map(Dish::getName).map(String::length).forEach(System.out::println);

		menu.stream().map(Dish::getName).mapToInt(String::length).forEach(System.out::println);

		Arrays.asList("Hello", "World").stream().map(s -> s.split(""))
				.flatMap(stringArray -> Arrays.asList(stringArray).stream()).forEach(System.out::println);

		// a simple map would return a Stream<Stream<String>>
		Arrays.stream(new String[] { "Hello", "World" }).map(s -> s.split("")).map(Arrays::stream)
				.forEach(System.out::println);

		// so flat map - keeps only one stream
		Arrays.stream(new String[] { "Hello", "World" }).map(s -> s.split(""))
				.flatMap(stringArray -> Arrays.stream(stringArray)).forEach(System.out::println);

		Arrays.stream(new String[] { "Hello", "World" }).map(s -> s.split("")).flatMap(Arrays::stream)
				.forEach(System.out::println);

	}

	@Test
	public void quizCombinators() {
		Arrays.asList(1, 2).stream().map((a) -> Arrays.asList(3, 4).stream().map((b) -> new int[] { a, b }))
				.flatMap((x) -> x).forEach((ints) -> System.out.println(Arrays.toString(ints)));
		;

		Arrays.asList(1, 2).stream()
				.map((a) -> Arrays.asList(3, 4).stream().filter((b) -> a * b % 3 == 0).map((b) -> new int[] { a, b }))
				.flatMap((x) -> x).forEach((ints) -> System.out.println(Arrays.toString(ints)));
		;

	}

	@Test
	public void findingAndMatching() {
		// findFirst, findAny
		Optional<Dish> optionalDish = menu.stream().findFirst(); // less
																	// performance
																	// than
																	// findAny -
																	// cause of
																	// constraint
		optionalDish = menu.stream().findAny(); // max performance in parallel
												// operations

		// anyMactch, allMatch, noneMatch
		boolean isTrue = menu.stream().anyMatch(Dish::isVegetarian);
		isTrue = menu.stream().allMatch(Dish::isVegetarian);
		menu.stream().noneMatch(Dish::isVegetarian);
	}

	@Test
	public void basicOptional() { // optional.ifPresent(Consumer);
									// optional.isPresent();
									// optional.orElse(default)
		Optional<Dish> optionalDish = menu.stream().findFirst();

		boolean is = optionalDish.isPresent();
		Dish defaultDish = optionalDish.orElse(menu.get(0));
		optionalDish.ifPresent(System.out::println);
	}

	@Test
	public void reducingBasics() {

		//
		IntStream.range(0, 100).count();
		
		int sumAsInt = IntStream.range(0, 100).sum();
		
		//T reduce(T identity, BinaryOperator<T> accumulator)
		//Optional<T> reduce(BinaryOperator<T> accumulator);
		
		// optional
		OptionalInt maxOptionalInt = IntStream.range(0, 100).max();
		Optional<Integer> maxI = Arrays.asList(1,2,3).stream().max(Comparator.naturalOrder());
		OptionalInt maxI2 = Arrays.asList(1,2,3).stream().mapToInt(i->i).max();
		Optional<Integer> maxI3 = Arrays.asList(1,2,3).stream().reduce(Integer::max);
		Optional<Integer> maxI4 = Stream.of(1,2,3).reduce((a,b)->Integer.max(a, b));
				
		OptionalInt minOptionalInt = IntStream.range(0, 100).min();
		Optional<Integer> minI =  Arrays.asList(1,2,3).stream().min(Comparator.naturalOrder());
		OptionalInt minI2 = Arrays.asList(1,2,3).stream().mapToInt(s->s).min();
		Optional<Integer> minI3 = Arrays.asList(1,2,3).stream().reduce(Integer::min);
		Optional<Integer> minI4 = Stream.of(1,2,3).reduce((a,b)->Integer.min(a,b));
		Integer minI5 = Stream.of(1,2,3).reduce(Integer.MAX_VALUE, Integer::min);
				
		IntBinaryOperator intFunction = Integer::min;
		IntBinaryOperator intFunction2 = Integer::max;
		IntBinaryOperator intFunction3 = Integer::sum;
				
		OptionalDouble averageIsOptionalDouble = IntStream.range(0, 100).average();
		
		System.out.println("reduce with BiOperator");
		IntBinaryOperator op = (prev, current) -> {
			System.out.println(prev + " + " + current);
			return prev + current;
		};
		
		IntBinaryOperator op2 = Integer::sum; // WOW
		
		OptionalInt optionalInt1 = IntStream.range(0, 100).reduce(op);
		
		int noOptionalIfDefaultPassed = IntStream.range(0, 3).reduce(0, op);
		
		IntStream.range(0, 3).reduce(Integer::max);
		IntStream.range(0, 3).reduce(Integer::min);
		IntStream.range(0, 3).reduce(Integer::sum);
		IntStream.range(0, 3).reduce((prev,current)->prev+1);
		
		OptionalInt optionalInt = IntStream.range(0, 100).max();
		optionalInt.getAsInt();
		optionalInt.ifPresent(new IntConsumer() {

			@Override
			public void accept(int value) {
				// TODO Auto-generated method stub

			}
		});
		
		boolean is = optionalInt.isPresent();
		
		//orElse, orElseGet(Supplier), orElseThrow(Supplier)
		int requiredInt = optionalInt.orElse(1);
		optionalInt.orElseGet(new IntSupplier() {
			
			@Override
			public int getAsInt() {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		
		int orElseThrow = optionalInt.orElseThrow(new Supplier(){

			@Override
			public Object get() {
				// TODO Auto-generated method stub
				return null;
			}});
	}

}
