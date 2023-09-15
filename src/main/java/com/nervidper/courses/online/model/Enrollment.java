package com.nervidper.courses.online.model;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nervidper.courses.online.constants.TableConstants;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = TableConstants.ENROLLMENT_TABLE_NAME)
public class Enrollment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enrollmentId;
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "courseID")
	private Course course;
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "studentID")
	private Student student;
	private LocalDate enrollmentDate;
	private boolean completed;
	
	public Enrollment(int enrollmentId, Course course, Student student, LocalDate enrrollmentDate, boolean completed) {
		this.enrollmentId = enrollmentId;
		this.course = course;
		this.student = student;
		this.enrollmentDate = enrrollmentDate;
		this.completed = completed;
	}
	
	public Enrollment() {
		
	}

	public int getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public LocalDate getEnrrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrrollmentDate(LocalDate enrrollmentDate) {
		this.enrollmentDate = enrrollmentDate;
	}

	public boolean isCompleted() {
		return completed;
	}
	
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(enrollmentId);
	}

	@Override
	public boolean equals(Object obj) {
		boolean equals = false;
		if(obj != null && obj instanceof Enrollment) {
			Enrollment enrollment = (Enrollment) obj;
			equals = this.enrollmentId == enrollment.enrollmentId;
		}
		return equals;
	}

	@Override
	public String toString() {
		return "Enrollment [enrollmentId=" + enrollmentId + ", courseId=" + course.getCourseId() + ", studentId=" + student.getStudentId()
				+ ", enrollmentDate=" + enrollmentDate + ", completed=" + completed + "]";
	}
	
}
