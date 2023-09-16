<%@page import="com.nervidper.courses.online.model.Course"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mis Cursos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet" href="indexPrincipal.css" type="text/css">
</head>
<body>

	<h2 class="myCoursesTitle">Mis Cursos</h2>
	<% List<Course> courses = (List<Course>) request.getAttribute("myCourses"); %>
	<% if (courses != null && courses.size() > 0) { %>
	<div class="courseContainer">
	<% for (Course course : courses) { %>

	<div class="card" style="width: 18rem;">
		<img class="card-img-top" alt="<%= course.getName() %>_image"
			src="<%= course.getImageUrl() %>" />
		<div class="card-body cardBody">
			<h5 class="card-title cardTitle"><%= course.getName() %></h5>
		</div>
	</div>
	<% }%>
	</div>
	<% } else { %>
	<div class="container">
			<div class="h-50 p-5 bg-body-tertiary border rounded-3 emptyResult">
	          <h2>No hay cursos que mostrar</h2>
	          <p>No tenemos resultados para mostrar, inténtalo con otra búsqueda</p>
	        </div>
		</div>
	<% }%>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
</html>