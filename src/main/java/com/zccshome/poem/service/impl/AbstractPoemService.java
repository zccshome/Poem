package com.zccshome.poem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zccshome.poem.bean.poem.AbstractPoem;
import com.zccshome.poem.bean.poem.Poem;
import com.zccshome.poem.dao.core.IAbstractPoemDao;
import com.zccshome.poem.service.core.IAbstractPoemService;

/**
 * 
 * @author zccshome
 *
 */
@Service
public class AbstractPoemService implements IAbstractPoemService {
	@Resource
	private IAbstractPoemDao abstractPoemDao;
	
	private Logger logger = Logger.getLogger(Poem.class.getName());
	
	public List<AbstractPoem> getAllPoems() {
		logger.info("Get all poems");
		return abstractPoemDao.getAllPoems();
	}
	
	public List<AbstractPoem> getPoemByAuthor(String author) {
		logger.info("Get poem by author: " + author);
		return abstractPoemDao.getPoemByAuthor(author);
	}
	
	public List<AbstractPoem> getPoemByAuthorOfPage(String author, int page) {
		return abstractPoemDao.getPoemByAuthorOfPage(author, page);
	}
	
	public List<AbstractPoem> getPoemOfPage(int page) {
		return abstractPoemDao.getPoemOfPage(page);
	}
	
	public int countPoem() {
		return abstractPoemDao.countPoem();
	}
	
	public int countPoemOfAuthor(String author) {
		return abstractPoemDao.countPoemOfAuthor(author);
	}
	
	public List<AbstractPoem> getPoemOfMatchPattern(String pattern) {
		return abstractPoemDao.getPoemOfMatchPattern(pattern);
	}
	
	public int countPoemOfMatchPattern(String pattern) {
		return abstractPoemDao.countPoemOfMatchPattern(pattern);
	}
	
	public List<AbstractPoem> getPoemOfMatchPatternOfPage(String pattern, int page) {
		return abstractPoemDao.getPoemOfMatchPatternOfPage(pattern, page);
	}
}
