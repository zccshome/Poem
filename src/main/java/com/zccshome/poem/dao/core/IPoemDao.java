package com.zccshome.poem.dao.core;

import java.util.List;

import com.zccshome.poem.bean.poem.Poem;

/**
 * Operations on poem object.
 * @author zccshome
 *
 */
public interface IPoemDao {
	/**
	 * Get a poem by its poem ID.
	 * @param id
	 * @return
	 */
	public Poem getPoemById(int id);
	
	/**
	 * Get all poems.
	 * @return
	 */
	public List<Poem> getAllPoems();
	
	/**
	 * Get a poem by its book number and poem number.
	 * @param bookNum
	 * @param poemNum
	 * @return
	 */
	public Poem getPoemByBookAndPoemNum(String bookNum, String poemNum);
	
	/**
	 * Get poems of a certain author.
	 * @param author
	 * @return
	 */
	public List<Poem> getPoemByAuthor(String author);
	
	/**
	 * Get poems of a certain author of a certain page number.
	 * @param author
	 * @param page
	 * @return
	 */
	public List<Poem> getPoemByAuthorOfPage(String author, int page);
	
	/**
	 * Get poems of a certain page number.
	 * @param author
	 * @param page
	 * @return
	 */
	public List<Poem> getPoemOfPage(int page);
	
	/**
	 * Count the number of poems.
	 * @return
	 */
	public int countPoem();
	
	/**
	 * Count the number of poems of a certain author.
	 * @return
	 */
	public int countPoemOfAuthor(String author);
}
