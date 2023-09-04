package com.nervidper.courses.online.dao;

import java.util.List;
import com.nervidper.courses.online.model.Course;
import com.nervidper.courses.online.model.Student;

public interface StudentDAO {
	
	
	public boolean enrollInCourse(int courseId);
	
	public List<Course> findAllCourses(int studentId);
	
	// For login
	public Student findStudentByEmail(String email);
	
	// For registration
	public Student createStudent(String name, String surname, String email, String password);

}
