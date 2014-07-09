package com.zccshome.poem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zccshome.poem.bean.poem.Poem;
import com.zccshome.poem.dao.core.IPoemDao;
import com.zccshome.poem.service.core.IPoemService;

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
		return poemDao.getAllPoems();
	}
}
