package com.fortech.training.spring.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fortech.training.spring.jpa.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);
}
