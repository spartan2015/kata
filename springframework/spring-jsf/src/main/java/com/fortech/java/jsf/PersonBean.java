package com.fortech.java.jsf;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

@Named
@Scope("session")
public class PersonBean {

	@Inject
	private PersonService personService;

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public List<Person> getList() {
		return personService.getList();
	}

}