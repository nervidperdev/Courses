package com.nervidper.courses.online.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
 * Servlet implementation class FindCoursesByStudentServlet
 */
@WebServlet("/FindCoursesByStudent")
public class FindCoursesByStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentId = (Integer) request.getSession().getAttribute("userId");
		CoursesDelegate facade = new CoursesFacade();
		List<Course> courses = facade.findAllCoursesByStudent(studentId);
		request.setAttribute("myCourses", courses);
		request.getRequestDispatcher("/coursesStudent.jsp").forward(request, response);
	}

}
