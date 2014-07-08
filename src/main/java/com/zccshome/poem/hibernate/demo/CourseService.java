package com.zccshome.poem.hibernate.demo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zccshome.poem.hibernate.common.IPersistenceManager;

@Service
@Transactional
public class CourseService implements ICourseService {

	@Autowired
	IPersistenceManager persistenceManager;

	@Override
	public Collection<Course> getAllCourses() {
		return persistenceManager.all(Course.class);
	}

}
