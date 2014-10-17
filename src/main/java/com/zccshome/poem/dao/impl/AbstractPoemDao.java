package com.zccshome.poem.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zccshome.poem.bean.poem.AbstractPoem;
import com.zccshome.poem.dao.core.IAbstractPoemDao;
import com.zccshome.poem.utils.Constants;

@Service
@Transactional
public class AbstractPoemDao extends BaseDao<AbstractPoem> implements IAbstractPoemDao {

	@Override
	public List<AbstractPoem> getAllPoems() {
		Query query = createQuery("from AbstractPoem");
		List<AbstractPoem> poemList = new ArrayList<AbstractPoem>();
		@SuppressWarnings("unchecked")
		List<Object[]> ansList = query.list();
		for(int i = 0; i < ansList.size(); i++) {
			Object[] temp = ansList.get(i);
			AbstractPoem poem = new AbstractPoem(
					String.valueOf(temp[0]), 
					String.valueOf(temp[1]),
					String.valueOf(temp[2]));
			poemList.add(poem);
		}
		return poemList;
	}

	@Override
	public List<AbstractPoem> getPoemByAuthor(String author) {
		Query query = createQuery("from AbstractPoem where poemAuthor = ?");
		query.setString(0, author);
		List<AbstractPoem> poemList = new ArrayList<AbstractPoem>();
		@SuppressWarnings("unchecked")
		List<Object[]> ansList = query.list();
		for(int i = 0; i < ansList.size(); i++) {
			Object[] temp = ansList.get(i);
			AbstractPoem poem = new AbstractPoem(
					String.valueOf(temp[0]), 
					String.valueOf(temp[1]),
					String.valueOf(temp[2]));
			poemList.add(poem);
		}
		return poemList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractPoem> getPoemByAuthorOfPage(String author, int page) {
		Query query = createQuery("select count(*) from AbstractPoem where author = ?");
		query.setString(0, author);
		int size = ((Long)query.list().get(0)).intValue();
		
		page = (size > page * Constants.PAGE_SIZE) ? page : size / Constants.PAGE_SIZE;
		query = createQuery("from AbstractPoem where poemAuthor = ?");
		query.setString(0, author);
		query.setFirstResult(page * Constants.PAGE_SIZE);
		query.setMaxResults(Constants.PAGE_SIZE);
		return query.list().size() > 0 ? (List<AbstractPoem>)query.list() : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractPoem> getPoemOfPage(int page) {
		Query query = createQuery("select count(*) from AbstractPoem");
		int size = ((Long)query.list().get(0)).intValue();
		
		page = (size > page * Constants.PAGE_SIZE) ? page : size / Constants.PAGE_SIZE;
		query = createQuery("from AbstractPoem");
		query.setFirstResult(page * Constants.PAGE_SIZE);
		query.setMaxResults(Constants.PAGE_SIZE);
		return query.list().size() > 0 ? (List<AbstractPoem>)query.list() : null;
	}

	@Override
	public int countPoem() {
		Query query = createQuery("select count(*) from AbstractPoem");
		int size = ((Long)query.list().get(0)).intValue();
		return size;
	}

	@Override
	public int countPoemOfAuthor(String author) {
		Query query = createQuery("select count(*) from AbstractPoem where poemAuthor = ?");
		query.setString(0, author);
		return ((Long)query.list().get(0)).intValue();
	}

	@Override
	public List<AbstractPoem> getPoemOfMatchPattern(String pattern) {
		Query query = getSession().createSQLQuery("from AbstractPoem where poemContent REGEXP '"+pattern+"'");
		List<AbstractPoem> poemList = new ArrayList<AbstractPoem>();
		@SuppressWarnings("unchecked")
		List<Object[]> ansList = query.list();
		for(int i = 0; i < ansList.size(); i++) {
			Object[] temp = ansList.get(i);
			AbstractPoem poem = new AbstractPoem(
					String.valueOf(temp[0]),
					String.valueOf(temp[1]),
					String.valueOf(temp[2]));
			poemList.add(poem);
		}
		return poemList;
	}

	@Override
	public List<AbstractPoem> getPoemOfMatchPatternOfPage(String pattern, int page) {
		int size = countPoemOfMatchPattern(pattern);
		page = (size > page * Constants.PAGE_SIZE) ? page : size / Constants.PAGE_SIZE;
		
		Query query = getSession().createSQLQuery("from AbstractPoem where poemContent REGEXP '"+pattern+
				"' limit "+page * Constants.PAGE_SIZE + ", " + Constants.PAGE_SIZE);
		List<AbstractPoem> poemList = new ArrayList<AbstractPoem>();
		@SuppressWarnings("unchecked")
		List<Object[]> ansList = query.list();
		for(int i = 0; i < ansList.size(); i++) {
			Object[] temp = ansList.get(i);
			AbstractPoem poem = new AbstractPoem(
					String.valueOf(temp[0]), 
					String.valueOf(temp[1]),
					String.valueOf(temp[2]));
			poemList.add(poem);
		}
		return poemList;
	}

	@Override
	public int countPoemOfMatchPattern(String pattern) {
		Query query = getSession().createSQLQuery("select count(*) from AbstractPoem where poemContent REGEXP '"+pattern+"'");
		return Integer.parseInt(String.valueOf(query.list().get(0)));
	}

}
