package com.fortech.java.dao;

import java.util.List;

import com.fortech.java.entities.Person;

public interface PersonDAO {

	Person get(Long byId);
	List<Person> list();
	void save(Person person);
	void delete(Person person);
		
}
