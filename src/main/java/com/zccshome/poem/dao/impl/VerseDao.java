package com.zccshome.poem.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zccshome.poem.bean.poem.Verse;
import com.zccshome.poem.dao.core.IVerseDao;
import com.zccshome.poem.utils.Constants;

@Service
@Transactional
public class VerseDao extends BaseDao<Verse> implements IVerseDao {

	@Override
	public Verse getVerseById(int id) {
		return getById(Verse.class, id);
	}

	@Override
	public List<Verse> getAllVerses() {
		return getAll(Verse.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Verse> getVerseByAuthor(String author) {
		Query query = createQuery("from Verse where author = ?");
		query.setString(0, author);
		return query.list().size() > 0 ? (List<Verse>)query.list() : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Verse> getVerseByAuthorOfPage(String author, int page) {
		Query query = createQuery("select count(*) from Verse where author = ?");
		query.setString(0, author);
		int size = ((Long)query.list().get(0)).intValue();
		
		page = (size > page * Constants.PAGE_SIZE) ? page : size / Constants.PAGE_SIZE;
		query = createQuery("from Verse where author = ?");
		query.setString(0, author);
		query.setFirstResult(page * Constants.PAGE_SIZE);
		query.setMaxResults(Constants.PAGE_SIZE);
		return query.list().size() > 0 ? (List<Verse>)query.list() : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Verse> getVerseOfPage(int page) {
		Query query = createQuery("select count(*) from Verse");
		int size = ((Long)query.list().get(0)).intValue();
		
		page = (size > page * Constants.PAGE_SIZE) ? page : size / Constants.PAGE_SIZE;
		query = createQuery("from Verse");
		query.setFirstResult(page * Constants.PAGE_SIZE);
		query.setMaxResults(Constants.PAGE_SIZE);
		return query.list().size() > 0 ? (List<Verse>)query.list() : null;
	}

	@Override
	public int countVerse() {
		return count(Verse.class);
	}

	@Override
	public int countVerseOfAuthor(String author) {
		Query query = createQuery("select count(*) from Verse where author = ?");
		query.setString(0, author);
		return ((Long)query.list().get(0)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Verse> getVerseOfMatchPattern(String pattern) {
		Query query = getSession().createSQLQuery("select * from verse where content1 REGEXP '"+pattern+"' or content2 REGEXP '"+pattern+"'");
		List<Verse> verseList = new ArrayList<Verse>();
		List<Object[]> ansList = query.list();
		for(int i = 0; i < ansList.size(); i++) {
			Object[] temp = ansList.get(i);
			Verse verse = new Verse(Integer.parseInt(String.valueOf(temp[0])),
					String.valueOf(temp[1]), 
					String.valueOf(temp[2]),
					String.valueOf(temp[3]),
					String.valueOf(temp[4]),
					String.valueOf(temp[5]));
			verseList.add(verse);
		}
		return verseList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Verse> getVerseOfMatchPatternOfPage(String pattern, int page) {
		int size = countVerseOfMatchPattern(pattern);
		page = (size > page * Constants.PAGE_SIZE) ? page : size / Constants.PAGE_SIZE;
		
		Query query = getSession().createSQLQuery("select * from verse where content1 REGEXP '"+pattern+"' or content2 REGEXP '"+pattern+
				"' limit "+page * Constants.PAGE_SIZE + ", " + Constants.PAGE_SIZE);
		List<Verse> verseList = new ArrayList<Verse>();
		List<Object[]> ansList = query.list();
		for(int i = 0; i < ansList.size(); i++) {
			Object[] temp = ansList.get(i);
			Verse verse = new Verse(Integer.parseInt(String.valueOf(temp[0])),
					String.valueOf(temp[1]), 
					String.valueOf(temp[2]),
					String.valueOf(temp[3]),
					String.valueOf(temp[4]),
					String.valueOf(temp[5]));
			verseList.add(verse);
		}
		return verseList;
	}

	@Override
	public int countVerseOfMatchPattern(String pattern) {
		Query query = getSession().createSQLQuery("select count(*) from verse where content1 REGEXP '"+pattern+"' or content2 REGEXP '"+pattern+"'");
		return Integer.parseInt(String.valueOf(query.list().get(0)));
	}

}
