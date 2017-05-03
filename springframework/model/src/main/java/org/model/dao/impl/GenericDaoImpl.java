package org.model.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.model.dao.GenericDao;

public abstract class GenericDaoImpl<E,K extends Number> implements GenericDao<E,K> {

    @PersistenceContext
    protected EntityManager em;

    private Class<E> type;

    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public long countAll() {

        final StringBuffer queryString = new StringBuffer(
                "SELECT count(o) from ");

        queryString.append(type.getSimpleName()).append(" o ");

        final Query query = this.em.createQuery(queryString.toString());

        return (Long) query.getSingleResult();

    }

    @Override
    public E create(final E t) {
        this.em.persist(t);
        return t;
    }

    @Override
    public void delete(final K id) {
        this.em.remove(this.em.getReference(type, id));
    }

    @Override
    public E find(final K id) {
        return (E) this.em.find(type, id);
    }

    @Override
    public E update(final E t) {
        return this.em.merge(t);    
    }
}
