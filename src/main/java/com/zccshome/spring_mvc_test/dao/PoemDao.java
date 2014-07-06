package com.zccshome.spring_mvc_test.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zccshome.spring_mvc_test.bean.poem.Poem;
import com.zccshome.spring_mvc_test.hibernate.common.IPersistenceManager;

@Service
@Transactional
public class PoemDao {
	
	@Autowired
	IPersistenceManager persistenceManager;
	
	public void getPoem() {
		//Query query = persistenceManager.createQuery("from Poem");
		Collection<Poem> ansList = persistenceManager.all(Poem.class);
		//List<Object> ansList = query.list();
		System.out.println(ansList.size());
		/*
		Query query = sessionFactory.getCurrentSession().createQuery("from Poem");
		if(query == null)
			System.out.println("aaaa");
			*/
		//List<Object> ansList = query.list();
		/*for (Poem e: ansList) {
			System.out.println(e);
		}*/
	}
}
