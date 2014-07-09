package com.zccshome.poem.dao.core;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

/**
 * Base operations in dealing with objects in database
 * @author zccshome
 *
 * @param <T> the name for class
 */
public interface IBaseDao<T> {
	/**
	 * Get an object by its ID
	 * @param c class name
	 * @param id
	 * @return
	 */
	public T getById(Class<T> c, Serializable id);
	
	/**
	 * Save a new object.
	 * @param object
	 */
	public void save(T object);
	
	/**
	 * Update an object.
	 * @param object
	 */
	public void update(T object);
	
	/**
	 * Save or update an object.
	 * @param object
	 */
	public void saveOrUpdate(T object);
	
	/**
	 * Delete an object.
	 * @param object
	 */
	public void delete(T object);
	
	/**
	 * Get all objects of a certain class.
	 * @param c
	 * @return
	 */
	public List<T> getAll(Class<T> c);
	
	/**
	 * Create a hql query.
	 * @param hql
	 * @return
	 */
	public Query createQuery(String hql);
}
