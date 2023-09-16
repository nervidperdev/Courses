package com.nervidper.courses.online.controller;

import java.io.IOException;
import java.time.LocalDate;
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int teacherID = (Integer) request.getSession().getAttribute("userId");
		int categoryID = Integer.parseInt(request.getParameter("select"));
		String nameCourse = request.getParameter("name");
		String startDate = request.getParameter("startDate");
		LocalDate startDate1 = LocalDate.parse(startDate);
		Category category = new Category(categoryID);
		Teacher teacher = new Teacher(teacherID);
		Course course = new Course(nameCourse, startDate1, null, teacher, category, null, "https://images.unsplash.com/photo-1504868584819-f8e8b4b6d7e3?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8Y3Vyc298ZW58MHx8MHx8fDA%3D&auto=format&fit=crop&w=320&q=60");
		CoursesDelegate facade = new CoursesFacade();
		course = facade.createCourse(course);

		if (course != null) {
			request.getRequestDispatcher("indexTeacher.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "No se ha creado");

		}
	}

}
