package com.zccshome.poem.hibernate.demo;

import javax.persistence.Entity;

@Entity
public class NormalCourse extends Course {

	public NormalCourse(Teacher teacher) {
		super(teacher);
	}

	private String classroom;

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

}
