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


@WebServlet("/FindCoursesByTeacher")
public class FindCoursesByTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int teacherID = (Integer) request.getSession().getAttribute("userId");
		System.out.println(teacherID);
		CoursesDelegate facade = new CoursesFacade();
		
		try {
			
			List<Course> coursesListTeacher = facade.findAllCoursesByTeacher(teacherID);
			ObjectMapper mapper = JsonMapper.builder()
	                .addModule(new JavaTimeModule())
	                .build();
			String jsonResponse = mapper.writeValueAsString(coursesListTeacher);
			response.setContentType("application/json;charset=utf-8");
			PrintWriter output = response.getWriter();
			output.write(jsonResponse);
			output.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
