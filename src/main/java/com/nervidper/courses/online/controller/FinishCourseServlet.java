package com.nervidper.courses.online.controller;

import java.io.IOException;
import com.nervidper.courses.online.facade.CoursesDelegate;
import com.nervidper.courses.online.facade.CoursesFacade;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FinishCourseServlet
 */
@WebServlet("/FinishCourse")
public class FinishCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		CoursesDelegate facade = new CoursesFacade();
		try {	
			boolean update = facade.finishCourse(courseId);
			
			if(update) {				
				response.setStatus(204);
			} else {
				response.setStatus(500);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
		}
	}

}
