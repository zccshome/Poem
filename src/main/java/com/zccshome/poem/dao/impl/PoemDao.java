package com.zccshome.poem.dao.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zccshome.poem.bean.poem.Poem;
import com.zccshome.poem.dao.core.IPoemDao;

@Service
@Transactional
public class PoemDao extends BaseDao<Poem> implements IPoemDao {
	
	public Poem getPoemById(int id) {
//		Poem ansList = this.getHibernateTemplate().get(Poem.class, 3);
		return getById(Poem.class, id);
	}
}
