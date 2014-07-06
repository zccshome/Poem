package com.zccshome.spring_mvc_test.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zccshome.spring_mvc_test.dao.PoemDao;


@Service
public class PoemService {
	@Resource
	PoemDao poemDao;
	
	public void getPoemService() {
		poemDao.getPoem();
		System.out.println("Get poems.");
	}
}
