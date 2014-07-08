package com.zccshome.poem.deprecated.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zccshome.poem.deprecated.bean.loser.Loser;
import com.zccshome.poem.deprecated.bean.loser.LoserDS;
import com.zccshome.poem.deprecated.bean.loser.LoserGroup;

@Controller
@RequestMapping("/loser")
public class LoserController {
	@Resource
	private LoserDS loserDS;
	
	public void setMetaclassDS(LoserDS loserDS) {
		this.loserDS = loserDS;
	}
	
	@RequestMapping(method=RequestMethod.GET, headers="Accept=application/xml, application/json")
	public @ResponseBody LoserGroup getAllLosers() {
		return loserDS.getLoserGroup();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{loser_name}", headers="Accept=application/xml, application/json")
	public @ResponseBody Loser getLoserByName(@PathVariable String loser_name) {
		Loser loser = loserDS.getLoserGroup().getItem(loser_name);
		return loser;
	}
	
	@RequestMapping(method=RequestMethod.POST, headers="Accept=application/xml, application/json")
	public @ResponseBody LoserGroup addLoser(@RequestBody Loser loser) {
		loserDS.getLoserGroup().addItem(loser);
		return loserDS.getLoserGroup();
	}
	
	@RequestMapping(method=RequestMethod.PUT, headers="Accept=application/xml, application/json")
	public @ResponseBody LoserGroup updateLoser(@RequestBody Loser loser) {
		loserDS.getLoserGroup().updateItem(loser);
		return loserDS.getLoserGroup();
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{loser_name}", headers="Accept=application/xml, application/json")
    public @ResponseBody LoserGroup removeLoser(@PathVariable String loser_name) {
		loserDS.getLoserGroup().removeItem(loser_name);
		return loserDS.getLoserGroup();
	}
}
