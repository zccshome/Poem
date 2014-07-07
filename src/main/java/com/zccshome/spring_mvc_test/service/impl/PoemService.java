package com.zccshome.spring_mvc_test.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zccshome.spring_mvc_test.dao.core.IPoemDao;
import com.zccshome.spring_mvc_test.dao.impl.PoemDao;
import com.zccshome.spring_mvc_test.service.core.IPoemService;


@Service
public class PoemService implements IPoemService {
	@Resource
	private IPoemDao poemDao;
	
	public void setPoemDao(IPoemDao poemDao) {
		this.poemDao = poemDao;
	}
	
	public void getPoemService() {
		poemDao.getPoem();
		System.out.println("Get poems.");
	}
}
