package sorting.solving;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class ShorterAndLighter {

	static class Person {
		int weight;
		int height;

		public Person(int height, int weight) {
			this.height = height;
			this.weight = weight;
		}

		public int getHeight() {
			return height;
		}

		public int getWeight() {
			return weight;
		}

		public String toString() {
			return "Person[height=" + height + ",weight=" + weight + "]";
		}
	}

	@Test
	public void test() {
		List<Person> people = Arrays.asList(new Person(65, 100), new Person(70, 150), new Person(56, 90),
				new Person(75, 190), new Person(60, 95), new Person(68, 110));

		people.sort(Comparator.comparing(Person::getHeight).thenComparing(Person::getWeight));

		people.forEach(System.out::println);
	}

}
