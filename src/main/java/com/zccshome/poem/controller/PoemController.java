package com.zccshome.poem.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zccshome.poem.bean.poem.Poem;
import com.zccshome.poem.service.impl.PoemService;

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
