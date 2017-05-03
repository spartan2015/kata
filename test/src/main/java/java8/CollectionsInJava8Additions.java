package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import org.junit.Test;

public class CollectionsInJava8Additions {
	static class Duck {
		int height;
		int weight;

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

	}

	static class DuckHelper {
		static int byWeight(Duck d1, Duck d2) {
			return d1.weight - d2.weight;
		}

		static int byHeight(Duck d1, Duck d2) {
			return d1.height - d2.height;
		}
	}

	@Test
	public void methodReferences() {
		Collections.sort(Arrays.asList(new Duck(), new Duck()), DuckHelper::byHeight);
		Collections.sort(Arrays.asList(new Duck(), new Duck()), DuckHelper::byWeight);

		Collections.sort(Arrays.asList(new Duck(), new Duck()), Comparator.comparing(Duck::getHeight));
		Collections.sort(Arrays.asList(new Duck(), new Duck()), Comparator.comparing(Duck::getWeight));
	}

	@Test
	public void removeIf() {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");

		Predicate<String> sizeIsZero = s -> s.length() == 0;
		list.removeIf(sizeIsZero);

	}

	@Test
	public void replaceAll() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);

		UnaryOperator<Integer> operator = i -> i * 2;
		list.replaceAll(operator);
	}

	@Test
	public void forEach() {
		List<Duck> ducks = new ArrayList<>();

		ducks.forEach(System.out::println);
	}

	@Test
	public void mapMerge() {
		Map<String, String> cats = new HashMap<>();

		cats.merge("newCat", "Lala", (oldValue, newValue) -> {
			return newValue;
		});
	}
	
	@Test
	public void computeIfPresetComputeIfAbsent(){
		Map<String, List> cats = new HashMap<>();
		
		cats.computeIfAbsent("newCat", k -> { return new ArrayList(); });
		cats.computeIfPresent("newCat", (k,v) -> { return v; });
		
		cats.putIfAbsent("newCat", new ArrayList());
	}
}
