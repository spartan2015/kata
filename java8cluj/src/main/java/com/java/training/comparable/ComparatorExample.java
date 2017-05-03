package com.java.training.comparable;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

class Person implements Comparable<Person> {
	int age;
	String name;

	Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	
	@Override
	public int compareTo(Person o) {			
		return name.compareTo(o.name);
	}
}

class PersonAgeComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		return o1.age - o2.age;
	}
	
}

public class ComparatorExample {
		
	@Test
	public void sortByAge(){
		
		Person person1 = new Person(21,"A");
		Person person2 = new Person(20,"B");
		
		List<Person> persons = Arrays.asList(person1, person2);
		
		Collections.sort(persons);		
		assertTrue(persons.get(0) == person1);
		
		Collections.sort(persons, new PersonAgeComparator());
		assertTrue(persons.get(0) == person2);
		
	}

}
