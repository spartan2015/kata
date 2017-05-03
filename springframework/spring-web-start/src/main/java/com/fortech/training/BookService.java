package com.fortech.training;

import org.springframework.beans.factory.annotation.Autowired;

public class BookService {

	@Autowired
	BookRepository repo;
	
	void save(Book book){
		repo.save(book);
	
	}
	
}
