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
@Table(name = TableConstants.STUDENT_TABLE_NAME)
public class Student extends User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String name;
	private String surname;
	private String email;
	private String password;
	@OneToMany(mappedBy = "student")
	private List<Enrollment> enrollmentList;
	
	
	public Student(int studentId, String name, String surname, String email, String password,
	List<Enrollment> enrollmentList) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.enrollmentList = enrollmentList;
	}


	public Student() {
		super();
	}


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
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


	public List<Enrollment> getEnrollmentList() {
		return enrollmentList;
	}


	public void setEnrollmentList(List<Enrollment> enrollmentList) {
		this.enrollmentList = enrollmentList;
	}


	@Override
	public int hashCode() {
		return Objects.hash(studentId);
	}


	@Override
	public boolean equals(Object obj) {
		boolean equals = false;
		if(obj != null && obj instanceof Student) {
			Student student = (Student)obj;
			equals = this.studentId == student.studentId;
		}
		return equals;
	}


	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", surname=" + surname + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	

}
