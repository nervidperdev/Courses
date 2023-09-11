package com.nervidper.courses.online.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.nervidper.courses.online.model.Student;

import jakarta.persistence.TypedQuery;

public class StudentHibernateDAO implements StudentDAO {

	@Override
	public Student findStudentByEmail(String email) {
		Student student = null;
		Session sesion = DaoUtility.getSession();
		Transaction transaccion = sesion.beginTransaction();
		System.out.println(sesion);
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
			return null; //devolveria una exception
		}
		sesion.close();
		return student;
	}
	

	@Override
	public List<Student> findStudentsByCourse(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean enrollInCourse(int courseId) {
		// TODO Auto-generated method stub
		return false;
	}


}
