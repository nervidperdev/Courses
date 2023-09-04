package com.nervidper.courses.online.dao;

import java.util.List;

import com.nervidper.courses.online.model.Course;
import com.nervidper.courses.online.model.Enrollment;
import com.nervidper.courses.online.model.Student;

public class StudentHibernateDAO implements StudentDAO {

	@Override
	public boolean enrollInCourse(int courseId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Student findStudentByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student createStudent(String name, String surname, String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findAllCourses(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
