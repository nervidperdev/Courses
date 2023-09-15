<%@page import="com.nervidper.courses.online.model.Course"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="indexPrincipal.css" type="text/css">
</head>
<body>

	<h2>Mis Cursos</h2>

	<% List<Course> courses = (List<Course>) request.getAttribute("myCourses"); %>
	<% if (courses != null && courses.size() > 0) { %>
		<% for (Course course : courses) { %>
			<div class="courseContainer">
				<div class="courseCard">
					<img
						src="https://images.unsplash.com/photo-1501504905252-473c47e087f8?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=320&q=80" />
					<h4><%= course.getName() %></h4>
				</div>
			</div>
		<% }%>
	<% } else { %>
		<!-- Show empty screen -->
		<div class="emptyCoursesContainer">
			<h1>No tienes cursos</h1>
			<p>Puedes matricularte en todos los cursos que lo desees.</p>
		</div>
	<% }%>
</body>
</html>