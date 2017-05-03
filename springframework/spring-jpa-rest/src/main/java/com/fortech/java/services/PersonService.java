package com.fortech.java.services;

import java.util.List;

import com.fortech.java.entities.Person;

public interface PersonService {
	Person get(Long byId);
	List<Person> list();
	void save(Person person);
	void delete(Person person);
}
