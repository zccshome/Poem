package com.zccshome.poem.deprecated.util;

import org.springframework.http.MediaType;

public class CommonsUtil {
	public static MediaType converDataType(String dataType) {
		return dataType.equals("json")? MediaType.APPLICATION_JSON: MediaType.APPLICATION_XML;
    }
   
}
