package com.zccshome.spring_mvc_test.util;

import org.springframework.http.MediaType;

public class CommonsUtil {
	public static MediaType converDataType(String dataType) {
		return dataType.equals("json")? MediaType.APPLICATION_JSON: MediaType.APPLICATION_XML;
    }
   
}
