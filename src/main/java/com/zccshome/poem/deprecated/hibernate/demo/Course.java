package com.zccshome.poem.deprecated.hibernate.demo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.zccshome.poem.deprecated.hibernate.common.BaseModelObject;

@Entity
public abstract class Course extends BaseModelObject {

	private String name;
	private Integer totalStudents;

	@ManyToOne
	private Teacher teacher;

	public Course(Teacher teacher) {
		this.teacher = teacher;
		if (teacher != null)
			teacher.getCourses().add(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTotalStudents() {
		return totalStudents;
	}

	public void setTotalStudents(Integer totalStudents) {
		this.totalStudents = totalStudents;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
