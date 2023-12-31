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



@WebServlet("/SearchCoursesForTeacherByName")
public class SearchCoursesForTeacherByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String search = request.getParameter("searchName");
		int teacherId = (Integer) request.getSession().getAttribute("userId");
		CoursesDelegate facade = new CoursesFacade();
		
		List<Course> courses = facade.findTeacherCoursesByName(teacherId, search);
		ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
		String json = mapper.writeValueAsString(courses);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter output = response.getWriter();
		output.write(json);
		output.close();
	}

}
