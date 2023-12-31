package com.nervidper.courses.online.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nervidper.courses.online.constants.TableConstants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = TableConstants.COURSES_TABLE_NAME)
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="courseID")
	private int courseId;
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="teacherID")
	private Teacher teacher;
	@ManyToOne
	@JoinColumn(name="categoryID")
	private Category category;
	@OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Enrollment> enrollments;
	private String imageUrl;
	
	public Course(String name, LocalDate startDate, LocalDate endDate, Teacher teacher, Category category,
			List<Enrollment> enrollments, String imageUrl) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.teacher = teacher;
		this.category = category;
		this.enrollments = enrollments;
		this.imageUrl = imageUrl;
	}

	
	public Course(int courseId) {
		this.courseId = courseId;
	}


	public Course() {}
	
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
	

	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	@Override
	public int hashCode() {
		return Objects.hash(courseId);
	}

	@Override
	public boolean equals(Object obj) {
		boolean equals = false;
		if(obj != null && obj instanceof Course) {
			Course course = (Course) obj;
			equals = this.courseId == course.courseId;
		}
		return equals;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + "]";
	}
}