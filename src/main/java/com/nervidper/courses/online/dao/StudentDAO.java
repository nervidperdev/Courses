package com.nervidper.courses.online.dao;

import java.util.List;
import com.nervidper.courses.online.model.Enrollment;
import com.nervidper.courses.online.model.Student;

public interface StudentDAO {
	
	public boolean enrollInCourse(Enrollment enrollment);
	
	public List<Student> findStudentsByCourse(int courseId); 

	public Student findStudentByEmail(String email);
	
	public Student createStudent(String name, String surname, String email, String password);

}
