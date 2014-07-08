package com.zccshome.poem.deprecated.hibernate.demo;

import javax.persistence.Entity;

@Entity
public class OnlineCourse extends Course {

	public OnlineCourse(Teacher teacher) {
		super(teacher);
	}

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
