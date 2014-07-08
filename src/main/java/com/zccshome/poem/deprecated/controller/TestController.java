package com.zccshome.poem.deprecated.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestController {
	@RequestMapping(method=RequestMethod.GET, value="testGet")
	public ModelAndView testGet()
	{
		Map<String, String> getMap = new HashMap<String, String>();
		return new ModelAndView("success");
	}
}
