package com.zccshome.poem.service.core;

import java.util.List;

import com.zccshome.poem.bean.poem.Poem;

public interface IPoemService {
	public Poem getPoemById(int id);
	
	public List<Poem> getAllPoems();
}
