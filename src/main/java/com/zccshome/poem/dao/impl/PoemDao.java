package com.zccshome.poem.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zccshome.poem.bean.poem.Poem;
import com.zccshome.poem.dao.core.IPoemDao;

/**
 * 
 * @author zccshome
 *
 */
@Service
@Transactional
public class PoemDao extends BaseDao<Poem> implements IPoemDao {
	
	public Poem getPoemById(int id) {
//		Poem ansList = this.getHibernateTemplate().get(Poem.class, 3);
		return getById(Poem.class, id);
	}
	
	public List<Poem> getAllPoems() {
		return getAll(Poem.class);
	}
	
	public Poem getPoemByBookAndPoemNum(String bookNum, String poemNum) {
		Query query = createQuery("from Poem where bookNum = ? and poemNum = ?");
		query.setString(0, bookNum);
		query.setString(1, poemNum);
		return query.list().size() > 0 ? (Poem)query.list().get(0) : null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Poem> getPoemByAuthor(String author) {
		Query query = createQuery("from Poem where author = ?");
		query.setString(0, author);
		return query.list().size() > 0 ? (List<Poem>)query.list() : null;
	}
}
