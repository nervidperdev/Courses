package com.nervidper.courses.online.dao;

import java.time.LocalDate;
import java.util.List;

import com.nervidper.courses.online.model.Course;

public interface CoursesDAO {
	
	public List<Course> findCoursesByName(String name);
	
	public List<Course> findCoursesByDate(LocalDate startDate);
	
	public List<Course> findCoursesByCategory(int categoryId);
	
	public List<Course> getLastestCourses();
	
	public List<Course> findAllCourses();
	
	public boolean finishCourse(int courseId);
	
	public Course createCourse(String name, LocalDate startDate);

	
}
