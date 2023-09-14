package com.nervidper.courses.online.dao;

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
		try {
			TypedQuery<Course> query = session.createQuery("from Course where name like :name", Course.class);
			query.setParameter("name", "%" + name + "%");
			System.out.println(query);
			courseList = query.getResultList();
			System.out.println(courseList);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		session.close();
		return courseList;
	}

	@Override
	public List<Course> findCoursesByCategory(int categoryId) {
		List<Course> coursesCategory = new ArrayList<Course>();
		Session session = DaoUtility.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			TypedQuery<Course> query = session.createQuery("from Course where category.categoryId = :categoryId",
					Course.class);
			query.setParameter("categoryId", categoryId);
			coursesCategory = query.getResultList();
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		session.close();
		return coursesCategory;
	}

	@Override
	public List<Course> findAllCoursesByTeacher(int teacherID) {
		List<Course> listCoursesTeacher = new ArrayList<Course>();
		Session session = DaoUtility.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			TypedQuery<Course> query = session.createQuery("from Course where teacher.teacherId = :teacherID",
					Course.class);
			query.setParameter("teacherId", teacherID);
			listCoursesTeacher = query.getResultList();
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		session.close();
		return listCoursesTeacher;

	}

	@Override
	public List<Course> findAllCoursesByStudent(int studentID) {
		List<Course> listCoursesStudent = new ArrayList<Course>();
		Session session = DaoUtility.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			TypedQuery<Course> query = session.createQuery("from Course where student,studentId =:studentID",
					Course.class);
			listCoursesStudent = query.getResultList();
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		session.close();
		return listCoursesStudent;
	}



	@Override
	public List<Course> findAllCourses() {
		List<Course> listCourses = null;
		Session sesion = DaoUtility.getSession();
		Transaction transaccion = sesion.beginTransaction();
		try {
			TypedQuery<Course> query = sesion.createQuery("from Course", Course.class);
			listCourses = query.getResultList();
			transaccion.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaccion.rollback();
		}
		sesion.close();
		return listCourses;
	}

	@Override
	public Course createCourse(Course course) {
		Course courseInsert = null;
		Session session = DaoUtility.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.merge(course);
			transaction.commit();
			courseInsert = course;
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		session.close();
		return courseInsert;

	}

	@Override
	public List<Course> findTeacherCoursesByName(int teacherID, String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Course> findCoursesByEnrollment(int studentID) {
		// TODO Auto-generated method stub
				return null;
	}
	
	@Override
	public boolean finishCourse(int courseId) {
		// TODO Auto-generated method stub
		// PAra crear la fecha de finalizacion con dia actual usar LocalDate.now() y
		// pasarla a la bd para el campo endDate
		// query.setParameter("endDate", LocalDate.now());
		return false;
	}

}
