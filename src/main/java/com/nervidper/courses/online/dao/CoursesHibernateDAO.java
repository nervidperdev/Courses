package com.nervidper.courses.online.dao;

import java.time.LocalDate;
import java.util.List;

import com.nervidper.courses.online.model.Course;


public class CoursesHibernateDAO implements CoursesDAO {
	
	public CoursesHibernateDAO() {
		
	}

	@Override
	public List<Course> findCoursesByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findCoursesByDate(LocalDate startDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findCoursesByCategory(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getLastestCourses() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean finishCourse(int courseId) {
		// TODO Auto-generated method stub
		// PAra crear la fecha de finalizacion con dia actual usar LocalDate.now() y pasarla a la bd para el campo endDate
		//query.setParameter("endDate", LocalDate.now());
		return false;
	}
}
