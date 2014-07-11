package com.zccshome.poem;

import org.junit.Test;
import org.springframework.http.MediaType;

import com.zccshome.poem.bean.poem.Poem;
import com.zccshome.poem.utils.RestClient;

public class TestPoem {
	@Test
	public void testGetPoemById() {
		RestClient<Poem> client = new RestClient<Poem>();
		Poem poem = client.getjson("id/", "3", MediaType.APPLICATION_JSON, Poem.class);
		System.out.println(poem);
	}
}
