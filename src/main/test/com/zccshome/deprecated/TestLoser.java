package com.zccshome.deprecated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.zccshome.poem.deprecated.bean.loser.Loser;
import com.zccshome.poem.deprecated.bean.loser.LoserGroup;
import com.zccshome.poem.deprecated.client.LoserClient;


public class TestLoser {

	@Test
	public void postJsonTest() {
		Loser loser = new Loser("Wang Xin", "704");
		LoserClient<Loser> client = new LoserClient<Loser>();
		System.out.println(client.postJson(loser, "loser/", "json"));
	}

	@Test
	public void postJosnTest2() {
		Map<String, String> map = new HashMap<String,String>();
		map.put("name", "Li Jin");
		map.put("room", "702");
		LoserClient<Map<String, String>> client = new LoserClient<Map<String, String>>();
		System.out.println(client.postJson(map, "loser/", "json"));
	}
	
	@Test
	public void getJsonTest() {
		LoserClient<Loser> client = new LoserClient<Loser>();
		Loser loser = client.getjson("loser/", "Wang Tianyi", "json", Loser.class);
		System.out.println(loser);
	}

	@Test
	public void getJsonTest2() {
		LoserClient<LoserGroup> client = new LoserClient<LoserGroup>();
		LoserGroup loserGroup = client.getjson("loser/", "", "json", LoserGroup.class);
		System.out.println(loserGroup);
	}
	@Test
	public void putJsonTest() {
		Loser loser = new Loser("Wang Xin", "705");
		LoserClient<Loser> client = new LoserClient<Loser>();
		System.out.println(client.postJson(loser, "loser/", "json"));
	}

	@Test
	public void deleteJsonTest() {
		System.out.println(LoserClient.deleteJson("loser/", "Wang Xin"));
	}

	/**
	 * Remove the information of the metaclass NodeServer.
	 */
	@Test
	public void deleteJsonTest2() {
		System.out.println(LoserClient.deleteJson("loser/", ""));
	}
}
