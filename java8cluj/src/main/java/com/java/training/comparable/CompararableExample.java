package com.java.training.comparable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

public class CompararableExample {
	public static class Person implements Comparable<Person> {
		int age;
		String name;

		Person(int age, String name) {
			this.age = age;
			this.name = name;
		}

		public int compareTo(Person otherPerson) {
			return age - otherPerson.age;
		}
	}

	@Test
	public void lessThan() {
		Person person1 = new Person(11, "A");
		Person person2 = new Person(22, "a");

		assertTrue(person1.compareTo(person2) < 0 );
		
		List<Person> list = Arrays.asList(person1,person2);
		Collections.sort(list);
		assertEquals(person1, list.get(0));
		
		TreeSet<Person> sortedSet = new TreeSet<Person>();
		sortedSet.add(person2);
		sortedSet.add(person1);		
		assertEquals(person1, sortedSet.first());
	}

	@Test
	public void equal() {
		Person person1 = new Person(22, "A");
		Person person2 = new Person(22, "a");

		assertTrue(person1.compareTo(person2) == 0 );
	}

	@Test
	public void greaterThan() {
		Person person1 = new Person(22, "A");
		Person person2 = new Person(11, "a");

		assertTrue(person1.compareTo(person2) > 0 );	Comparator.reverseOrder();	
	}
		
}
