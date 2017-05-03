package com.fortech.java.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.fortech.java.entities.Person;

public class JpaPersonDAO implements PersonDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	public Person get(Long byId) {
		return entityManager.find(Person.class, byId);
	}

	public List<Person> list() {
		return entityManager.createQuery("select p from Person p", Person.class).getResultList();
	}

	public void save(Person person) {
		entityManager.merge(person);
	}

	public void delete(Person person) {
		person = entityManager.find(Person.class, person.getId());
		entityManager.remove(person);
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
