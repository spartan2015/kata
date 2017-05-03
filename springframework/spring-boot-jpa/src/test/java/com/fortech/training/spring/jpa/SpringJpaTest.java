package com.fortech.training.spring.jpa;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fortech.training.spring.jpa.AppConfiguration;
import com.fortech.training.spring.jpa.model.Customer;
import com.fortech.training.spring.jpa.repository.CustomerRepository;

public class SpringJpaTest {

	@Test
	public void init(){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
		CustomerRepository repo = ctx.getBean(CustomerRepository.class);
		Customer entity = new Customer("John","Doe");		
		repo.save(entity);
	}
	
}
