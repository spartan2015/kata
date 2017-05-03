package com.java.training.comparable;

import static org.junit.Assert.*;

import org.junit.Test;

public class EqualsComparableConsistency {

	public static class Person implements Comparable<Person> {
		int age;
		String name;

		Person(int age, String name) {
			this.age = age;
			this.name = name;
		}

		public boolean equals(Object other) {
			if (!(other instanceof Person)) {
				return false;
			}
			Person otherPerson = (Person) other;
			return otherPerson.name.equals(name);
		}

		public int compareTo(Person otherPerson) {
			return age - otherPerson.age;
		}

	}

	/**
	 * if equals return true then compareTo must return 0 consistence rule
	 * broken. This could affect usage of this object within collection. Move
	 * comparator to another class
	 */
	@Test
	public void equalsAndComparableShouldBeConsistent() {
		Person person1 = new Person(21, "George");

		Person person2 = new Person(21, "Cosmin");

		assertTrue(0 == person1.compareTo(person2));

		assertTrue(person1.equals(person2)); // broken
	}
}
