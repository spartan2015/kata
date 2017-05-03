package org.model.dao;

import java.util.Map;

public interface GenericDao<E,K extends Number> {
	/**
	 * Method that returns the number of entries from a table that meet some
	 * criteria (where clause params)
	 *
	 * @param params
	 *            sql parameters
	 * @return the number of records meeting the criteria
	 */
	long countAll();

	E create(E t);

	void delete(K id);

	E find(K id);

	E update(E t);
}