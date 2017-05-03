package org.model.dao.impl;

import org.model.Book;
import org.model.dao.BookDao;
import org.springframework.stereotype.Component;

@Component("bookDao")
public class BookDaoImpl extends GenericDaoImpl<Book, Long> implements BookDao {
}
