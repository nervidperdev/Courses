package com.nervidper.courses.online.controller;

import java.io.IOException;
import java.util.List;
import com.nervidper.courses.online.facade.CoursesDelegate;
import com.nervidper.courses.online.facade.CoursesFacade;
import com.nervidper.courses.online.model.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/index.jsp")
public class CoursesCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CoursesDelegate facade = new CoursesFacade();
		
		try {
			List<Category> categoryList = facade.findAllCategory();
			request.setAttribute("categoryList", categoryList);
			request.getRequestDispatcher("indexPrincipal.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	}

	