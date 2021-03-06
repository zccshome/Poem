package com.zccshome.poem.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.zccshome.poem.dao.core.IBaseDao;

/**
 * 
 * @author zccshome
 *
 * @param <T>
 */
@Service
@Transactional
public class BaseDao<T> extends HibernateDaoSupport implements IBaseDao<T> {
	
	@Resource  
    public void setSessionFacotry(SessionFactory sessionFacotry) {  
        super.setSessionFactory(sessionFacotry);  
    }  
	
	@Override
	public T getById(Class<T> c, Serializable id) {
		return this.getHibernateTemplate().get(c, id);
	}
	
	@Override
	public void save(T object) {
		this.getHibernateTemplate().save(object);
	}
	
	@Override
	public void update(T object) {
		this.getHibernateTemplate().update(object);
	}
	
	@Override
	public void saveOrUpdate(T object) {
		this.getHibernateTemplate().saveOrUpdate(object);
	}
	
	@Override
	public void delete(T object) {
		this.getHibernateTemplate().delete(object);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Class<T> c) {
		return this.getHibernateTemplate().find("from " + c.getName());
	}
	
	public Query createQuery(String hql) {
		return getSession().createQuery(hql);
	}
	
	public int count(Class<T> c) {
		Query query = createQuery("select count(*) from " + c.getName());
		return ((Long)query.list().get(0)).intValue();
	}
}
