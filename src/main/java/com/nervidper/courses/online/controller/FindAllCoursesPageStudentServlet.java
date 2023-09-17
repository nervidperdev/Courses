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
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindAllCoursesPageStudentServlet
 */
@WebServlet("/FindAllCoursesPageStudent")
public class FindAllCoursesPageStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentId = (Integer) request.getSession().getAttribute("userId");
		CoursesDelegate facade = new CoursesFacade();
		List<Course> courses = facade.searchAllCoursesPageStudent(studentId);
		ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
		String json = mapper.writeValueAsString(courses);
		System.out.println(json);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter exit = response.getWriter();
		exit.write(json);
		exit.close();	
	}

}
