package com.zccshome.poem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zccshome.poem.bean.poem.Poem;
import com.zccshome.poem.dao.core.IPoemDao;
import com.zccshome.poem.service.core.IPoemService;

/**
 * 
 * @author zccshome
 *
 */
@Service
public class PoemService implements IPoemService {
	@Resource
	private IPoemDao poemDao;
	
	private Logger logger = Logger.getLogger(Poem.class.getName());
	
	public Poem getPoemById(int id) {
		logger.info("Get poem by id: " + id);
		return poemDao.getPoemById(id);
	}
	
	public List<Poem> getAllPoems() {
		logger.info("Get all poems");
		return poemDao.getAllPoems();
	}
	
	public Poem getPoemByBookAndPoemNum(String bookNum, String poemNum) {
		logger.info("Get poem by bookNum: " + bookNum + " and poemNum: " + poemNum);
		return poemDao.getPoemByBookAndPoemNum(bookNum, poemNum);
	}
	
	public List<Poem> getPoemByAuthor(String author) {
		logger.info("Get poem by author: " + author);
		return poemDao.getPoemByAuthor(author);
	}
	
	public List<Poem> getPoemByAuthorOfPage(String author, int page) {
		return poemDao.getPoemByAuthorOfPage(author, page);
	}
	
	public List<Poem> getPoemOfPage(int page) {
		return poemDao.getPoemOfPage(page);
	}
	
	public int countPoem() {
		return poemDao.countPoem();
	}
	
	public int countPoemOfAuthor(String author) {
		return poemDao.countPoemOfAuthor(author);
	}
	
	public List<Poem> getPoemOfMatchPattern(String pattern) {
		return poemDao.getPoemOfMatchPattern(pattern);
	}
	
	public int countPoemOfMatchPattern(String pattern) {
		return poemDao.countPoemOfMatchPattern(pattern);
	}
	
	public List<Poem> getPoemOfMatchPatternOfPage(String pattern, int page) {
		return poemDao.getPoemOfMatchPatternOfPage(pattern, page);
	}
}
