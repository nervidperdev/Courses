package com.nervidper.courses.online.facade;

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
	public boolean enrollInCourse(Enrollment enrollment) {
		StudentDAO dao = new StudentHibernateDAO();
		return dao.enrollInCourse(enrollment);
	}

	@Override
	public List<Course> findAllCourses() {
		CoursesDAO dao = new CoursesHibernateDAO();
		return dao.findAllCourses();
	}


	@Override
	public List<Course> findCoursesByName(String name) {	
		CoursesDAO dao = new CoursesHibernateDAO();
		return dao.findCoursesByName(name);
		
	}

	
	public List<Course> findCoursesByCategory(int categoryId) {
		CoursesDAO dao = new CoursesHibernateDAO();
		return dao.findCoursesByCategory(categoryId);
	}


	@Override
	public List<Category> findAllCategory() {
		CategoryDAO dao = new CategoryHibernateDAO();
		return dao.findAllCategory();
	}

	@Override
	public Course createCourse(Course course) {
		CoursesDAO dao = new CoursesHibernateDAO();
		return dao.createCourse(course);
	}


	@Override
	public List<Course> findAllCoursesByTeacher(int teacherID) {
		CoursesDAO dao = new CoursesHibernateDAO();
		return dao.findAllCoursesByTeacher(teacherID);
	}

	@Override
	public List<Course> findAllCoursesByStudent(int studentId) {
		CoursesDAO dao = new CoursesHibernateDAO();
		return dao.findAllCoursesByStudent(studentId);
	}

	@Override
	public List<Student> findStudentsByCourse(int courseId) {
		StudentDAO dao = new StudentHibernateDAO();
		return dao.findStudentsByCourse(courseId);
		
	}

	@Override
	public List<Course> findTeacherCoursesByName(int teacherID, String name) {
		CoursesDAO dao = new CoursesHibernateDAO();
		return dao.findTeacherCoursesByName(teacherID, name);
	}

	@Override
	public boolean finishCourse(int courseId) {
		CoursesDAO dao = new CoursesHibernateDAO();
		return dao.finishCourse(courseId);
	}

	@Override
	public List<Course> searchAllCoursesPageStudent(int studentId) {
		CoursesDAO dao = new CoursesHibernateDAO();
		return dao.searchAllCoursesPageStudent(studentId);
	}
	
	
}
