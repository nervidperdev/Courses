package com.nervidper.courses.online.model;

import java.util.List;
import java.util.Objects;

import com.nervidper.courses.online.constants.TableConstants;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = TableConstants.TEACHER_TABLE_NAME)
public class Teacher extends User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacherId;
	private String name;
	private String surname;
	private String email;
	private String password;
	@OneToMany(mappedBy = "teacher")
	private List<Course> coursesList;
	
	
	public Teacher(int teacherId, String name, String surname, String email, String password,
	List<Course> coursesList) {
		super();
		this.teacherId = teacherId;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.coursesList = coursesList;
	}


	public Teacher() {
		super();
	}



	public int getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Course> getCoursesList() {
		return coursesList;
	}


	public void setCoursesList(List<Course> coursesList) {
		this.coursesList = coursesList;
	}


	@Override
	public int hashCode() {
		return Objects.hash(teacherId);
	}


	@Override
	public boolean equals(Object obj) {
		boolean equals = false;
		if(obj != null && obj instanceof Teacher) {
			Teacher teacher = (Teacher)obj;
			equals = this.teacherId == teacher.teacherId;
		}
		return equals;
	}


	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", name=" + name + ", surname=" + surname + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	
	
	

}
