package com.zccshome.poem.dao.core;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T> {
	public T getById(Class<T> c, Serializable id);
	public void save(T object);
	public void update(T object);
	public void saveOrUpdate(T object);
	public void delete(T object);
	public List<T> getAll(Class<T> c);
}
