package com.nervidper.courses.online.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.nervidper.courses.online.facade.CoursesDelegate;
import com.nervidper.courses.online.facade.CoursesFacade;
import com.nervidper.courses.online.model.Category;
import com.nervidper.courses.online.model.Course;
import com.nervidper.courses.online.model.Teacher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterCourseServlet
 */
@WebServlet("/RegisterCourse")
public class RegisterCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int teacherID = (Integer) request.getSession().getAttribute("userId");
		int categoryID = Integer.parseInt(request.getParameter("select"));
		String nameCourse = request.getParameter("name");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		LocalDate startDate1 = LocalDate.parse(startDate);
		LocalDate endDate1 = LocalDate.parse(endDate);
		Category category = new Category(categoryID);
		Teacher teacher = new Teacher(teacherID);
		Course course = new Course(nameCourse, startDate1, endDate1, teacher, category, null);
		CoursesDelegate facade = new CoursesFacade();
		course = facade.createCourse(course);

		if (course != null) {
			request.setAttribute("message", "El curso se ha creado correctamente");

		} else {
			request.setAttribute("message", "No se ha creado");

		}
		request.getRequestDispatcher("registerCourse.jsp").forward(request, response);
	}

}
