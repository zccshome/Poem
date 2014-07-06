package com.zccshome.spring_mvc_test.hibernate.demo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import com.zccshome.spring_mvc_test.hibernate.common.BaseModelObject;

@Entity
public class Teacher extends BaseModelObject {
	private String name;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Embedded
	private Address address = new Address();

	@OneToMany(mappedBy="teacher",cascade= CascadeType.ALL)
	private Collection<Course> courses = new ArrayList<Course>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Collection<Course> getCourses() {
		return courses;
	}

	public void setCourses(Collection<Course> courses) {
		this.courses = courses;
	}

}
