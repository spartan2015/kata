package com.fortech.java.services;

import java.util.Date;
import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fortech.java.dao.PersonDAO;
import com.fortech.java.entities.Person;

public class DefaultPersonService implements PersonService{

	@Autowired
	private PersonDAO personDAO;
	
	public Person get(Long byId) {
		return personDAO.get(byId);
	}

	public List<Person> list() {
		return personDAO.list();
	}

	public void save(Person person) throws ValidationException	{
		if (!person.getBirthDate().before(getCurrentDate())){
			throw new ValidationException("birth date must be before current date");
		}else{
			personDAO.save(person);
		}
	}

	public void delete(Person person) {
		personDAO.delete(person);
	}

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}
	
	private Date getCurrentDate(){
		return new Date();
	}
}
