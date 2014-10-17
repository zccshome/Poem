package com.zccshome.poem.service.core;

import java.util.List;

import com.zccshome.poem.bean.poem.AbstractPoem;

/**
 * 
 * @author zccshome
 *
 */
public interface IAbstractPoemService {
	
	/**
	 * Get all poems.
	 * @return
	 */
	public List<AbstractPoem> getAllPoems();
	
	/**
	 * Get poems of a certain author.
	 * @param author
	 * @return
	 */
	public List<AbstractPoem> getPoemByAuthor(String author);
	
	/**
	 * Get poems of a certain author of a certain page number.
	 * @param author
	 * @param page
	 * @return
	 */
	public List<AbstractPoem> getPoemByAuthorOfPage(String author, int page);
	
	/**
	 * Get poems of a certain page number.
	 * @param page
	 * @return
	 */
	public List<AbstractPoem> getPoemOfPage(int page);
	
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
	
	/**
	 * Get poems of a certain matching pattern.
	 * @param pattern
	 * @return
	 */
	public List<AbstractPoem> getPoemOfMatchPattern(String pattern);
	
	/**
	 * Get poems of a certain matching pattern of a certain page.
	 * @param pattern
	 * @return
	 */
	public List<AbstractPoem> getPoemOfMatchPatternOfPage(String pattern, int page);
	
	/**
	 * Count the number of poems of a certain matching pattern.
	 * @param pattern
	 * @return
	 */
	public int countPoemOfMatchPattern(String pattern);
}
