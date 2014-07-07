package com.zccshome.spring_mvc_test.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zccshome.spring_mvc_test.bean.poem.Poem;
import com.zccshome.spring_mvc_test.service.impl.PoemService;

@Controller
@RequestMapping("/poem")
public class PoemController {
	@Resource
	PoemService poemService;
	
	@RequestMapping(method=RequestMethod.GET, headers="Accept=application/xml, application/json")
	public @ResponseBody List<Poem> getPoems() {
		poemService.getPoemService();
		return null;
	}
}
