package com.nervidper.courses.online.dao;

import java.util.List;
import com.nervidper.courses.online.model.Category;


public interface CategoryDAO {
	
	public Category findCategoryByName(String categoryName);
	
	public List<Category> findAllCategory();

}
