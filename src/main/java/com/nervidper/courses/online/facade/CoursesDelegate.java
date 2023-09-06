package com.nervidper.courses.online.facade;

import java.time.LocalDate;
import java.util.List;

import com.nervidper.courses.online.exception.LoginException;
import com.nervidper.courses.online.exception.RegistrationException;
import com.nervidper.courses.online.exception.WrongPasswordException;
import com.nervidper.courses.online.model.Category;
import com.nervidper.courses.online.model.Course;
import com.nervidper.courses.online.model.Enrollment;
import com.nervidper.courses.online.model.Student;
import com.nervidper.courses.online.model.User;

public interface CoursesDelegate {
	
	public User login(String type, String email, String password) throws LoginException;
	
	public Student register(String name, String surname, String email, String password) throws RegistrationException;
	
	public boolean enrollInCourse(int courseId);
	
	public List<Enrollment> findAllCourses();
	
	public List<Course> getLatestCourses();

	public List<Course> findCoursesByName(String name);
	
	public List<Course> findCoursesByDate(LocalDate startDate);
	
	/*public Category findCategoryByName(String categoryName);*/
	
	public List<Category> findAllCategory();


}