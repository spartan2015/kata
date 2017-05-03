package org.model.service.impl;

import java.util.List;

import org.model.dao.GenericDao;
import org.model.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericServiceImpl<E,K extends Number> implements GenericService<E,K> {
	@Autowired
	GenericDao<E,K> dao;

	@Override
	public E get(K key) {		
		return dao.find(key);
	}

	@Override
	public List<E> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public K save(E entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(K key) {
		// TODO Auto-generated method stub
		
	}
	
	
}
