<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TUS CURSOS</title>
<link rel="stylesheet" href="indexPrincipal.css" type="text/css">
</head>
<body onload="initPageStudent()">
	<% String name = (String) session.getAttribute("name");%>
	<% String surname = (String) session.getAttribute("surname");%>
	<header>
		<nav role="navigation">
			<div id="menuToggle">
				<input type="checkbox" /> 
				<span></span> 
				<span></span> 
				<span></span>
				<ul id="menu">
					<li><a href="FindCoursesByStudent">Mis Cursos</a></li>
					<li><a href="Logout">Cerrar Sesión</a></li>
				</ul>
			</div>
		</nav>
	</header>

	<main>

		<% if(name != null && surname != null) { %>
		<h1>
			Hola, 
			<%= name %>
			<%= surname %></h1>
		<% } %>

		<div id="searchResult"></div>
	</main>



</body>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="indexStudent.js"></script>
</html>


</body>
</html>