package com.zccshome.poem.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zccshome.poem.bean.poem.Poem;
import com.zccshome.poem.dao.core.IPoemDao;

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
