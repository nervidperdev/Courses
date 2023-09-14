package com.nervidper.courses.online.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.nervidper.courses.online.facade.CoursesDelegate;
import com.nervidper.courses.online.facade.CoursesFacade;
import com.nervidper.courses.online.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/FindStudentByCourse")
public class FindStudentByCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int search = Integer.parseInt(request.getParameter("searchId"));
		CoursesDelegate facade = new CoursesFacade();
		
		try {
			
			List<Student> studentList = facade.findStudentsByCourse(search);
			ObjectMapper mapper = JsonMapper.builder().build();
			String jsonResponse = mapper.writeValueAsString(studentList);
			response.setContentType("application/json;charset=utf-8");
			PrintWriter output = response.getWriter();
			output.write(jsonResponse);
			output.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
