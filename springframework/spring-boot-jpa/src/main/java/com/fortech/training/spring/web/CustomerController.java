package com.fortech.training.spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fortech.training.spring.jpa.model.Customer;
import com.fortech.training.spring.jpa.repository.CustomerRepository;

@Controller
@RequestMapping("/person")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("customers", customerRepository.findAll());
		return "list";
	}

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String getForDay(@PathVariable("id") Long id, Model model) {
		Customer customer = id != 0 ? customerRepository.findOne(id) : new Customer();		
		model.addAttribute("customer", customer);
		return "view";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@RequestParam Long id, @RequestParam String firstName, @RequestParam String lastName) {
		Customer customer = new Customer(firstName,lastName);
		customerRepository.save(customer);
		return "redirect:list";
	}
	
}
