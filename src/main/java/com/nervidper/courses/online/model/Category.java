package com.nervidper.courses.online.model;

import java.util.Objects;

import com.nervidper.courses.online.constants.TableConstants;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = TableConstants.CATEGORY_TABLE_NAME)
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	private String nameCategory;
	
	
	public Category(int categoryId, String nameCategory) {
		this.categoryId = categoryId;
		this.nameCategory = nameCategory;
	}


	public Category() {}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public String getNameCategory() {
		return nameCategory;
	}


	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}


	@Override
	public int hashCode() {
		return Objects.hash(categoryId);
	}


	@Override
	public boolean equals(Object obj) {
		boolean equals = false;
		if(obj != null && obj instanceof Category) {
			Category category = (Category)obj;
			equals = this.categoryId == category.categoryId;
		}
		return equals;
	}


	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", nameCategory=" + nameCategory + "]";
	}
	
	
	
	
	
	

}