package com.nervidper.courses.online.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.nervidper.courses.online.model.Category;
import jakarta.persistence.TypedQuery;

public class CategoryHibernateDAO implements CategoryDAO {
	


	public Category findCategoryByName(String categoryName) {
		Category category = null;
		Session sesion = DaoUtility.getSession();
		Transaction transaccion = sesion.beginTransaction();
		try {
			TypedQuery<Category> busqueda = sesion.createQuery("from Category where categoryName like :categoryName", Category.class);
			busqueda.setParameter("categoryname", "%" + categoryName + "%");
			transaccion.commit();
		} catch(HibernateException e) {			
			e.printStackTrace();
			transaccion.rollback();
		}
		sesion.close();
		return category;
	}

	public List<Category> findAllCategory() {
		List<Category> listCategory = new ArrayList<Category>();
		Session sesion = DaoUtility.getSession();
		Transaction transaccion = sesion.beginTransaction();
		try {
			TypedQuery<Category> busqueda = sesion.createQuery("from Category", Category.class);
			listCategory = busqueda.getResultList();
			transaccion.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			transaccion.rollback();
		}
		sesion.close();
		return listCategory;
	}

	


}
