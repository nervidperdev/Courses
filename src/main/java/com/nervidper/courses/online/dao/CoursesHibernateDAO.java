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
			TypedQuery<Course> query = session.createQuery("from Course where teacher.teacherId = :teacherId",
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
	public List<Course> findAllCoursesByEnrollment(int studentID) {
		List<Course> listCoursesStudent = new ArrayList<Course>();
		Session session = DaoUtility.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			TypedQuery<Course> query = session.createQuery("from Course where student.studentId =:studentId",
					Course.class);
			query.setParameter("studentID", studentID);
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
		List<Course> courseList = new ArrayList<Course>();
		Session session = DaoUtility.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			TypedQuery<Course> query = session.createQuery("from Course where name like :name and teacher.teacherId = :teacherId", Course.class);
			query.setParameter("name", "%" + name + "%");
			query.setParameter("teacherId", teacherID);
			courseList = query.getResultList();
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		session.close();
		return courseList;
	}
	
	
	@Override
	public boolean finishCourse(int courseId) {
		// TODO Auto-generated method stub
		// PAra crear la fecha de finalizacion con dia actual usar LocalDate.now() y
		// pasarla a la bd para el campo endDate
		// query.setParameter("endDate", LocalDate.now());
		return false;
	}

	@Override
	public List<Course> findAllCoursesByStudent(int studentId) {
		List<Course> courseList = new ArrayList<Course>();
		Session session = DaoUtility.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			//TypedQuery<Course> query = session.createQuery("from Student S join enrollment E on S.studentId = E.student.studentId join courses C on E.course.courseId = C.courseId where S.studentId = :studentId", Course.class);
			TypedQuery<Course> query = session.createQuery("from Course as C join Enrollment as E on C.courseId = E.course.courseId join Student as S on E.student.studentId = S.studentId where S.studentId = :studentId", Course.class);
			query.setParameter("studentId", studentId);
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

	
}
