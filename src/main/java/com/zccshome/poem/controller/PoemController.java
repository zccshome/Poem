package com.zccshome.poem.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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
	@ResponseStatus(value = HttpStatus.OK)
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
	@Deprecated
	public @ResponseBody List<Poem> getPoemByAuthor(@PathVariable String author) {
//		return poemService.getPoemByAuthor(author);
		return null;
	}
	
	/**
	 * Get poems of a certain author of a certain page number.
	 * @param author
	 * @param page front part: page start from 1; back part: page start from 0
	 * @return
	 */
	@RequestMapping(value = "/author/{author}/{page}", method=RequestMethod.GET, headers="Accept=application/xml, application/json")
	public @ResponseBody List<Poem> getPoemByAuthorOfPage(@PathVariable String author, @PathVariable int page) {
		return poemService.getPoemByAuthorOfPage(author, page-1);
	}
	
	/**
	 * Get poems of a certain page number.
	 * @param page front part: page start from 1; back part: page start from 0
	 * @return
	 */
	@RequestMapping(value = "/all/{page}", method=RequestMethod.GET, headers="Accept=application/xml, application/json")
	public @ResponseBody List<Poem> getPoemOfPage(@PathVariable int page) {
		return poemService.getPoemOfPage(page-1);
	}
	
	/**
	 * Count the number of poems.
	 * @return
	 */
	@RequestMapping(value = "/count", method=RequestMethod.GET, headers="Accept=application/xml, application/json")
	public int countPoem() {
		return poemService.countPoem();
	}
}
