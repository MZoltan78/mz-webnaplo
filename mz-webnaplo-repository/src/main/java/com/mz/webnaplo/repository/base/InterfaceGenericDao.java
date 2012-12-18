package com.mz.webnaplo.repository.base;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

public interface InterfaceGenericDao<T> {

	public T persist(T t);

	public T merge(T t);

	public T remove(T t);
	
	public T findById(Object id);

	public List<T> findAll();
	
	public T findByCustomField(String key, String value) throws NoResultException;
    
    public List<T> runCustomQuery(Query query);

}
