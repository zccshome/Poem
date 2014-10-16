package com.zccshome.poem.dao.core;

import java.util.List;

import com.zccshome.poem.bean.poem.Verse;

/**
 * Operations on verse object.
 * @author zccshome
 *
 */
public interface IVerseDao {
	/**
	 * Get a verse by its verse ID.
	 * @param id
	 * @return
	 */
	public Verse getVerseById(int id);
	
	/**
	 * Get all verses.
	 * @return
	 */
	public List<Verse> getAllVerses();
	
	/**
	 * Get versess of a certain author.
	 * @param author
	 * @return
	 */
	public List<Verse> getVerseByAuthor(String author);
	
	/**
	 * Get versess of a certain author of a certain page number.
	 * @param author
	 * @param page
	 * @return
	 */
	public List<Verse> getVerseByAuthorOfPage(String author, int page);
	
	/**
	 * Get verses of a certain page number.
	 * @param author
	 * @param page
	 * @return
	 */
	public List<Verse> getVerseOfPage(int page);
	
	/**
	 * Count the number of verses.
	 * @return
	 */
	public int countVerse();
	
	/**
	 * Count the number of verses of a certain author.
	 * @return
	 */
	public int countVerseOfAuthor(String author);
	
	/**
	 * Get verses of a certain matching pattern.
	 * @param pattern
	 * @return
	 */
	public List<Verse> getVerseOfMatchPattern(String pattern);
	
	/**
	 * Get verses of a certain matching pattern of a certain page.
	 * @param pattern
	 * @return
	 */
	public List<Verse> getVerseOfMatchPatternOfPage(String pattern, int page);
	
	/**
	 * Count the number of verses of a certain matching pattern.
	 * @param pattern
	 * @return
	 */
	public int countVerseOfMatchPattern(String pattern);
}
