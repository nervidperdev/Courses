package com.nervidper.courses.online.dao;

import java.util.List;

import com.nervidper.courses.online.model.Course;

public interface CoursesDAO {
	
	public List<Course> findCoursesByName(String name);
	
	public List<Course> findCoursesByCategory(int categoryId);
	
	public List<Course> findAllCoursesByTeacher(int teacherID);
	
	public List<Course> findTeacherCoursesByName(int teacherID, String name);
	
	public List<Course> findAllCoursesByStudent(int studentID);
	
	public List<Course> findAllCourses();
	
	public boolean finishCourse(int courseId);
	
	public Course createCourse(Course course);
	
	public List<Course> findAllCoursesByEnrollment(int studentID);

	
}
