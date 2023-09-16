package com.nervidper.courses.online.controller;

import java.io.IOException;
import java.time.LocalDate;
import com.nervidper.courses.online.facade.CoursesDelegate;
import com.nervidper.courses.online.facade.CoursesFacade;
import com.nervidper.courses.online.model.Course;
import com.nervidper.courses.online.model.Enrollment;
import com.nervidper.courses.online.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EnrollCourseServlet
 */
@WebServlet("/EnrollCourse")
public class EnrollCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int studentId = (Integer) request.getSession().getAttribute("userId");
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		CoursesDelegate facade = new CoursesFacade();
		Student student = new Student(studentId);
		Course course = new Course(courseId);
		Enrollment enrollment = new Enrollment(course,student,LocalDate.now(),false);
		boolean isEnrolled = facade.enrollInCourse(enrollment);
		
		if(isEnrolled) {
			request.setAttribute("message", "Te has inscrito al curso");
		} else {
			request.setAttribute("message", "No te has podido inscribir, intentalo de nuevo más tarde");
		}
		request.getRequestDispatcher("indexStudent.jsp");
		
		
	}

}
