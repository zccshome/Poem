package com.zccshome.poem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zccshome.poem.bean.poem.Verse;
import com.zccshome.poem.dao.core.IVerseDao;
import com.zccshome.poem.service.core.IVerseService;

/**
 * 
 * @author zccshome
 *
 */
@Service
public class VerseService implements IVerseService {
	@Resource
	private IVerseDao verseDao;
	
	private Logger logger = Logger.getLogger(Verse.class.getName());
	
	@Override
	public Verse getVerseById(int id) {
		logger.info("Get verse by id: " + id);
		return verseDao.getVerseById(id);
	}

	@Override
	public List<Verse> getAllVerseS() {
		logger.info("Get all verses");
		return verseDao.getAllVerses();
	}

	@Override
	public List<Verse> getVerseByAuthor(String author) {
		logger.info("Get verse by author: " + author);
		return verseDao.getVerseByAuthor(author);
	}

	@Override
	public List<Verse> getVerseByAuthorOfPage(String author, int page) {
		return verseDao.getVerseByAuthorOfPage(author, page);
	}

	@Override
	public List<Verse> getVerseOfPage(int page) {
		return verseDao.getVerseOfPage(page);
	}

	@Override
	public int countVerse() {
		return verseDao.countVerse();
	}

	@Override
	public int countVerseOfAuthor(String author) {
		return verseDao.countVerseOfAuthor(author);
	}

	@Override
	public List<Verse> getVerseOfMatchPattern(String pattern) {
		return verseDao.getVerseOfMatchPattern(pattern);
	}

	@Override
	public List<Verse> getVerseOfMatchPatternOfPage(String pattern, int page) {
		return verseDao.getVerseOfMatchPatternOfPage(pattern, page);
	}

	@Override
	public int countVerseOfMatchPattern(String pattern) {
		return verseDao.countVerseOfMatchPattern(pattern);
	}

}
