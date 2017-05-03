package org.model.service;

import java.util.List;

public interface GenericService<E, K extends Number> {

	E get(K key);
	
	List<E> findAll();
	
	K save(E entity);
	
	void delete(K key);
}
