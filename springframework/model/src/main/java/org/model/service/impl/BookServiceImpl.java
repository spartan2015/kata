package org.model.service.impl;

import org.model.Book;
import org.model.service.BookService;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookServiceImpl extends GenericServiceImpl<Book,Long> implements BookService{

}
