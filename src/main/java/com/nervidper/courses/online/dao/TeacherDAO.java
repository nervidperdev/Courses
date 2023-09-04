package com.nervidper.courses.online.dao;

import java.util.List;

import com.nervidper.courses.online.model.Course;
import com.nervidper.courses.online.model.Student;
import com.nervidper.courses.online.model.Teacher;

public interface TeacherDAO {
	
	public List<Course> findAllCourses();
	
	public List<Student> findStudentsByCourse(int courseId);
	
	// For login
	public Teacher findTeacherByEmail(String email);

}
