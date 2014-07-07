package com.zccshome.spring_mvc_test.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zccshome.spring_mvc_test.bean.poem.Poem;
import com.zccshome.spring_mvc_test.dao.core.IPoemDao;
import com.zccshome.spring_mvc_test.hibernate.common.IPersistenceManager;
import com.zccshome.spring_mvc_test.hibernate.common.PMHibernateImpl;

@Service
@Transactional
public class PoemDao extends HibernateDaoSupport implements IPoemDao {
	
    @Resource  
    public void setSessionFacotry(SessionFactory sessionFacotry) {  
        super.setSessionFactory(sessionFacotry);  
    }  
	
	public void getPoem() {
		Poem ansList = this.getHibernateTemplate().get(Poem.class, 3);
		//Collection<Poem> ansList = persistenceManager.all(Poem.class);
		System.out.println(ansList.getBookNum());
	}
}
