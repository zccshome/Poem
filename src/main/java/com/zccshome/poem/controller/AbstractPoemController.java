package com.zccshome.poem.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zccshome.poem.bean.poem.AbstractPoem;
import com.zccshome.poem.service.impl.AbstractPoemService;

/**
 * 
 * @author zccshome
 *
 */
@Controller
@RequestMapping("/alldynasty")
public class AbstractPoemController {
	@Resource
	AbstractPoemService abstractPoemService;
	
	/**
	 * Get poems of a certain author of a certain page number.
	 * @param author
	 * @param page front part: page start from 1; back part: page start from 0
	 * @return
	 */
	@RequestMapping(value = "/author/{author}/{page}", method=RequestMethod.GET, headers="Accept=application/xml, application/json")
	public @ResponseBody List<AbstractPoem> getPoemByAuthorOfPage(@PathVariable String author, @PathVariable int page) {
		return abstractPoemService.getPoemByAuthorOfPage(author, page-1);
	}
	
	/**
	 * Get poems of a certain page number.
	 * @param page front part: page start from 1; back part: page start from 0
	 * @return
	 */
	@RequestMapping(value = "/all/{page}", method=RequestMethod.GET, headers="Accept=application/xml, application/json")
	public @ResponseBody List<AbstractPoem> getPoemOfPage(@PathVariable int page) {
		return abstractPoemService.getPoemOfPage(page-1);
	}
	
	/**
	 * Count the number of poems.
	 * @return
	 */
	@RequestMapping(value = "/count/all", method=RequestMethod.GET, headers="Accept=application/xml, application/json")
	public @ResponseBody int countPoem() {
		System.out.println(abstractPoemService.countPoem());
		return abstractPoemService.countPoem();
	}
	
	/**
	 * Count the number of poems of a certain author.
	 * @return
	 */
	@RequestMapping(value = "/count/author/{author}", method=RequestMethod.GET, headers="Accept=application/xml, application/json")
	public @ResponseBody int countPoemOfAuthor(@PathVariable String author) {
		return abstractPoemService.countPoemOfAuthor(author);
	}
	
	/**
	 * Count the number of poems of a certain matching pattern.
	 * @param pattern
	 * @return
	 */
	@RequestMapping(value = "/count/pattern", method=RequestMethod.GET, headers="Accept=application/xml, application/json")
	public @ResponseBody int countPoemOfMatchPattern(@RequestParam String pattern) {
		return abstractPoemService.countPoemOfMatchPattern(pattern);
	}
	
	/**
	 * Get poems of a certain matching pattern of a certain page.
	 * @param pattern
	 * @return
	 */
	@RequestMapping(value = "/pattern/{page}", method=RequestMethod.GET, headers="Accept=application/xml, application/json")
	public @ResponseBody List<AbstractPoem> getPoemOfMatchPatternOfPage(@RequestParam String pattern, @PathVariable int page) {
		return abstractPoemService.getPoemOfMatchPatternOfPage(pattern, page-1);
	}
}
