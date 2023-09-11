package com.nervidper.courses.online.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.nervidper.courses.online.facade.CoursesDelegate;
import com.nervidper.courses.online.facade.CoursesFacade;
import com.nervidper.courses.online.model.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CoursesCategory")
public class CoursesCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CoursesDelegate facade = new CoursesFacade();

		try {
			
			List<Category> categoryList = facade.findAllCategory();
			ObjectMapper mapper = JsonMapper.builder().build();
			String jsonResponse = mapper.writeValueAsString(categoryList);
			response.setContentType("application/json;charset=utf-8");
			PrintWriter output = response.getWriter();
			output.write(jsonResponse);
			System.out.println(jsonResponse);
			output.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
