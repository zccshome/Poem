package com.zccshome.poem.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zccshome.poem.bean.poem.Poem;
import com.zccshome.poem.service.impl.PoemService;

/**
 * 
 * @author zccshome
 *
 */
@Controller
@RequestMapping("/tang")
public class PoemController {
	@Resource
	PoemService poemService;
	
	/**
	 * Get a poem by its poem ID.
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/id/{id}", method=RequestMethod.GET, headers="Accept=application/xml, application/json")
	public @ResponseBody Poem getPoemById(@PathVariable int id) {
		return poemService.getPoemById(id);
	}
	
	/**
	 * Get all poems.
	 * @return
	 */
	@Deprecated
	@RequestMapping(value="/all", method=RequestMethod.GET, headers="Accept=application/xml, application/json")
	public @ResponseBody List<Poem> getAllPoems() {
//		return poemService.getAllPoems();
		return null;
	}
	
	/**
	 * Get a poem by its book number and poem number.
	 * @param bookNum
	 * @param poemNum
	 * @return
	 */
	@RequestMapping(value = "/num/{bookNum}/{poemNum}", method=RequestMethod.GET, headers="Accept=application/xml, application/json")
	public @ResponseBody Poem getPoemByBookAndPoemNum(@PathVariable String bookNum, @PathVariable String poemNum) {
		return poemService.getPoemByBookAndPoemNum(bookNum, poemNum);
	}
	
	/**
	 * Get poems of a certain author.
	 * tomcat conf/server.xml: add "URIEnciding: UTF-8" to support utf8 path variables.
	 * @param author
	 * @return
	 */
	@RequestMapping(value = "/author/{author}", method=RequestMethod.GET, headers="Accept=application/xml, application/json")
	public @ResponseBody List<Poem> getPoemByAuthor(@PathVariable String author) {
		return poemService.getPoemByAuthor(author);
	}
	
	/**
	 * Get poems of a certain author of a certain page number.
	 * @param author
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/author/{author}/{page}", method=RequestMethod.GET, headers="Accept=application/xml, application/json")
	public @ResponseBody List<Poem> getPoemByAuthorOfPage(@PathVariable String author, @PathVariable int page) {
		return poemService.getPoemByAuthorOfPage(author, page);
	}
	/**
	 * Get poems of a certain page number.
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/page/{page}", method=RequestMethod.GET, headers="Accept=application/xml, application/json")
	public @ResponseBody List<Poem> getPoemOfPage(@PathVariable int page) {
		return poemService.getPoemOfPage(page);
	}
}
