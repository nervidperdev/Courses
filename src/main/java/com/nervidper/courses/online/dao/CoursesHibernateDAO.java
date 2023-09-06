package com.nervidper.courses.online.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.nervidper.courses.online.model.Course;

import jakarta.persistence.TypedQuery;




public class CoursesHibernateDAO implements CoursesDAO {
	
	public CoursesHibernateDAO() {
		
	}

	@Override
	public List<Course> findCoursesByName(String name) {
		List<Course> courseList = new ArrayList<Course>();
		Session session = DaoUtility.getSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("ESTOY EN EL DAOOOOOOO");
		try {
			TypedQuery<Course> query = session.createQuery("from Course where name like :name", Course.class);
			query.setParameter("name", "%" + name + "%");
			System.out.println(query);
			courseList = query.getResultList();
			System.out.println(courseList);
			transaction.commit();
		} catch (HibernateException e){
			e.printStackTrace();
			transaction.rollback();
		}
		session.close();
		return courseList;
	}

	@Override
	public List<Course> findCoursesByDate(LocalDate startDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findCoursesByCategory(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getLastestCourses() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean finishCourse(int courseId) {
		// TODO Auto-generated method stub
		// PAra crear la fecha de finalizacion con dia actual usar LocalDate.now() y pasarla a la bd para el campo endDate
		//query.setParameter("endDate", LocalDate.now());
		return false;
	}

	@Override
	public List<Course> findAllCourses() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Course createCourse(String name, LocalDate startDate) {
		return null;
		
	} 
}
