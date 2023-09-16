package com.nervidper.courses.online.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.nervidper.courses.online.model.Enrollment;
import com.nervidper.courses.online.model.Student;

import jakarta.persistence.TypedQuery;

public class StudentHibernateDAO implements StudentDAO {

	@Override
	public Student findStudentByEmail(String email) {
		Student student = null;
		Session sesion = DaoUtility.getSession();
		Transaction transaccion = sesion.beginTransaction();
		try {
			TypedQuery<Student> query = sesion.createQuery("from Student where email = :email" , Student.class);
			query.setParameter("email",email);
			student = query.getSingleResult();
			transaccion.commit();
		}  catch (HibernateException e) {
			e.printStackTrace();
			transaccion.rollback();
		}
		sesion.close();
		return student;
	}

	@Override
	public Student createStudent(String name, String surname, String email, String password) {
		Student student = new Student();
		student.setName(name);
		student.setSurname(surname);
		student.setEmail(email);
		student.setPassword(password);
		Session sesion = DaoUtility.getSession();
		Transaction transaccion = sesion.beginTransaction();
		try {
			sesion.persist(student);
			transaccion.commit();
			sesion.close();	
		} catch(HibernateException e){
			e.printStackTrace();
			transaccion.rollback();
			return null; 
		}
		sesion.close();
		return student;
	}
	

	@Override
	public List<Student> findStudentsByCourse(int courseId) {
		List<Student> studentList = new ArrayList<Student>();
		Session session = DaoUtility.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			TypedQuery<Student> query = session.createQuery("select S.* from Student S join Enrollment E on S.studentID = E.studentID join Courses C on E.courseID = C.courseID where C.courseID = :courseID", Student.class);
			query.setParameter("courseID", courseId);
			System.out.println(query);
			studentList = query.getResultList();
			System.out.println(studentList);
			transaction.commit();
		} catch (HibernateException e){
			e.printStackTrace();
			transaction.rollback();
		}
		session.close();
		return studentList;
	}

	@Override
	public boolean enrollInCourse(Enrollment enrollment) {
		boolean enrollCourse = false;
		Session sesion = DaoUtility.getSession();
		Transaction transaccion = sesion.beginTransaction();
		try {
			sesion.persist(enrollment);
			transaccion.commit();
			sesion.close();	
		} catch(HibernateException e){
			e.printStackTrace();
			transaccion.rollback();
			enrollCourse = false;
		}
		sesion.close();
		return enrollCourse;
		
	}


}
