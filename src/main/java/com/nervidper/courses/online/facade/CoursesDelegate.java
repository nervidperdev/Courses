package com.nervidper.courses.online.facade;

import java.util.List;
import com.nervidper.courses.online.exception.LoginException;
import com.nervidper.courses.online.exception.RegistrationException;
import com.nervidper.courses.online.model.Category;
import com.nervidper.courses.online.model.Course;
import com.nervidper.courses.online.model.Enrollment;
import com.nervidper.courses.online.model.Student;
import com.nervidper.courses.online.model.User;

public interface CoursesDelegate {
	
	public User login(String type, String email, String password) throws LoginException;
	
	public Student register(String name, String surname, String email, String password) throws RegistrationException;
	
	public boolean enrollInCourse(Enrollment enrollment);
	
	public List<Course> findAllCourses();
	
	public List<Course> findCoursesByName(String name);
	
	public List<Course> findCoursesByCategory(int categoryId);
	
	public List<Category> findAllCategory();
	
	public List<Course> findAllCoursesByTeacher(int teacherID);
	
	public List<Course> findAllCoursesByStudent(int studentId);
	
	public Course createCourse(Course course);
	
	public List<Student> findStudentsByCourse(int courseId);
	
	public List<Course> findTeacherCoursesByName(int teacherID, String name);
	
	public boolean finishCourse(int courseId);
}