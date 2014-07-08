package com.zccshome.poem.dao.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.zccshome.poem.dao.core.IBaseDao;

@Service
@Transactional
public class BaseDao<T> extends HibernateDaoSupport implements IBaseDao {
	
	@Resource  
    public void setSessionFacotry(SessionFactory sessionFacotry) {  
        super.setSessionFactory(sessionFacotry);  
    }  
	
	public T getById(Class<T> c, Serializable id) {
		return this.getHibernateTemplate().get(c, id);
		
	}
}
