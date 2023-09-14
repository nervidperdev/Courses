<%@page import="com.nervidper.courses.online.model.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TUS CURSOS</title>
<link rel="stylesheet" href="indexPrincipal.css" type="text/css">
</head>
<body onload="initPage()">
	<% String userType = (String) session.getAttribute("type");%>
	<% String userEmail = (String) session.getAttribute("email");%>
	<% String name = (String) session.getAttribute("name");%>
	<% String surname = (String) session.getAttribute("surname");%>

	<header>
		<nav role="navigation">
			<div id="menuToggle">
				<input type="checkbox" /> <span></span> <span></span> <span></span>

				<ul id="menu">
					<li><a href="login.jsp">Inicia Sesion</a></li>
					<li><a href="registerStudent.jsp">Nuevo Alumn@</a></li>
				</ul>
			</div>
		</nav>
	</header>

	<main>
		<div class="contenedor">
			<input class="inputText" id="findCourse" type="text"
				placeholder="Buscar curso"> <select id="select">
				<option value="">Todos los cursos</option>
			</select>
		</div>


		<div id="searchResult"></div>
	</main>



</body>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="indexPrincipal.js"></script>
</html>
