package com.nervidper.courses.online.controller;

import java.io.IOException;
import com.nervidper.courses.online.exception.LoginException;
import com.nervidper.courses.online.exception.WrongPasswordException;
import com.nervidper.courses.online.facade.CoursesDelegate;
import com.nervidper.courses.online.facade.CoursesFacade;
import com.nervidper.courses.online.model.Student;
import com.nervidper.courses.online.model.Teacher;
import com.nervidper.courses.online.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



public class LoginServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        CoursesDelegate facade = new CoursesFacade();
        
        try {
        	User loggedUser = facade.login(type, email, password);
        	HttpSession session = request.getSession();
            session.setAttribute("email", email);
            session.setAttribute("type", type);
            
        	if (loggedUser instanceof Teacher) {
        		Teacher teacher = (Teacher) loggedUser;
        		session.setAttribute("userId", teacher.getTeacherId());
        		response.sendRedirect("indexTeacher.jsp");
        	} else {
        		Student student = (Student) loggedUser;
        		session.setAttribute("userId", student.getStudentId());
        		response.sendRedirect("indexStudent.jsp");
        	}
        } catch(WrongPasswordException e) {
        	e.printStackTrace();
        	request.setAttribute("error", "Los valores introducidos son incorrectos");
        } catch (LoginException e) {
        	e.printStackTrace();
        	request.setAttribute("error", "No se pudo iniciar sesión");
        }
    }
}
