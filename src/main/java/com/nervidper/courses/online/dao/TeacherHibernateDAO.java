package com.nervidper.courses.online.dao;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.nervidper.courses.online.model.Teacher;

import jakarta.persistence.TypedQuery;

public class TeacherHibernateDAO implements TeacherDAO {


	@Override
	public Teacher findTeacherByEmail(String email) {
		Teacher teacher = null;
		Session sesion = DaoUtility.getSession();
		Transaction transaccion = sesion.beginTransaction();
		try {
			TypedQuery<Teacher> query = sesion.createQuery("from Teacher where email = :email" , Teacher.class);
			query.setParameter("email",email);
			teacher = query.getSingleResult();
			transaccion.commit();
		}  catch (HibernateException e) {
			e.printStackTrace();
			transaccion.rollback();
		}
		sesion.close();
		return teacher;
	}


}
