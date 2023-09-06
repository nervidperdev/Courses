package com.nervidper.courses.online.controller;

import java.io.IOException;

import com.nervidper.courses.online.exception.RegistrationException;
import com.nervidper.courses.online.facade.CoursesDelegate;
import com.nervidper.courses.online.facade.CoursesFacade;
import com.nervidper.courses.online.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        CoursesDelegate facade = new CoursesFacade();
        
        try {
        	Student student = facade.register(name, surname, email, password);
        	HttpSession session = request.getSession();
            session.setAttribute("email", email);
            session.setAttribute("type", "student");
            session.setAttribute("userId", student.getStudentId());
            response.sendRedirect("indexStudent.jsp");
        } catch (RegistrationException e) {
        	e.printStackTrace();
        	request.setAttribute("error", "Usuario no registrado");
        }
        
	}

}
