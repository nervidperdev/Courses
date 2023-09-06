package com.nervidper.courses.online.facade;

import java.time.LocalDate;
import java.util.List;
import com.nervidper.courses.online.dao.CategoryDAO;
import com.nervidper.courses.online.dao.CategoryHibernateDAO;
import com.nervidper.courses.online.dao.CoursesDAO;
import com.nervidper.courses.online.dao.CoursesHibernateDAO;
import com.nervidper.courses.online.dao.StudentDAO;
import com.nervidper.courses.online.dao.StudentHibernateDAO;
import com.nervidper.courses.online.dao.TeacherDAO;
import com.nervidper.courses.online.dao.TeacherHibernateDAO;
import com.nervidper.courses.online.exception.LoginException;
import com.nervidper.courses.online.exception.RegistrationException;
import com.nervidper.courses.online.exception.UserNotLogged;
import com.nervidper.courses.online.exception.WrongPasswordException;
import com.nervidper.courses.online.model.Category;
import com.nervidper.courses.online.model.Course;
import com.nervidper.courses.online.model.Enrollment;
import com.nervidper.courses.online.model.Student;
import com.nervidper.courses.online.model.Teacher;
import com.nervidper.courses.online.model.User;


public class CoursesFacade implements CoursesDelegate {
	
	@Override
	public User login(String tipo, String email, String password) throws LoginException {
		if (tipo.equals("teacher")) {
			TeacherDAO dao = new TeacherHibernateDAO();
			Teacher teacher = dao.findTeacherByEmail(email);
			if (teacher != null) {
				String storedPassword = teacher.getPassword();
				if (password.equals(storedPassword)) {
					return teacher;
				} else {
					throw new WrongPasswordException();
				}
			}
		} else {
			StudentDAO dao = new StudentHibernateDAO();
			Student student = dao.findStudentByEmail(email);
			if (student != null) {
				String storedPassword = student.getPassword();
				if (password.equals(storedPassword)) {
					return student;
				} else {
					throw new WrongPasswordException();
				}
			}
		}
		
		throw new UserNotLogged();
	}
	
	@Override
	public Student register(String name, String surname, String email, String password) throws RegistrationException {
		StudentDAO dao = new StudentHibernateDAO();
		Student student = dao.createStudent(name, surname, email, password);
		if (student == null) {
			throw new RegistrationException();
		}
		return student;
	}

	@Override
	public boolean enrollInCourse(int courseId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Enrollment> findAllCourses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getLatestCourses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findCoursesByName(String name) {	
		CoursesDAO dao = new CoursesHibernateDAO();
		return dao.findCoursesByName(name);
		
	}

	@Override
	public List<Course>  findCoursesByDate(LocalDate startDate) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public Category findCategoryByName(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public List<Category> findAllCategory() {
		CategoryDAO dao = new CategoryHibernateDAO();
		return dao.findAllCategory();
	}
}
