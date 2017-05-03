package com.fortech.java.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fortech.java.entities.Person;
import com.fortech.java.services.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("persons", personService.list());
		return "list";
	}

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String getForDay(@PathVariable("id") Long personId, Model model) {
		Person person = personId != 0 ? personService.get(personId) : new Person();
		model.addAttribute("person", person);
		return "view";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@RequestParam Long id, @RequestParam String name, @RequestParam Date birthDate, @RequestParam Integer height,
			@RequestParam Integer weight) {
		Person person = new Person();
		person.setId(id);
		person.setName(name);
		person.setBirthDate(birthDate);
		person.setHeight(height);
		person.setWeight(weight);
		personService.save(person);
		return "redirect:list";
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
