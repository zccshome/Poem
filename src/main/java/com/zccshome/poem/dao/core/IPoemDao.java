package com.zccshome.poem.dao.core;

import java.util.List;

import com.zccshome.poem.bean.poem.Poem;

public interface IPoemDao {
	public Poem getPoemById(int id);
	public List<Poem> getAllPoems();
	public Poem getPoemByBookAndPoemNum(String bookNum, String poemNum);
}
