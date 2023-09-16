<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TUS CURSOS</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet" href="indexPrincipal.css" type="text/css">
</head>
<body onload="initPageStudent()">
	<% String name = (String) session.getAttribute("name");%>
	<% String surname = (String) session.getAttribute("surname");%>
	
	<header class="container-fluid w-100 fixed-top mt-3">
		<nav class="navbar h-100">

			<div class="row w-100 h-100">
				<div class="d-flex">
					<div id="nav-icon3" data-bs-toggle="offcanvas"
						data-bs-target="#menuOptions">
						<div class="">
							<span></span> <span></span> <span></span> <span></span>
						</div>
					</div>
				</div>


				<div class="offcanvas offcanvas-start menu" id="menuOptions"
					aria-labelledby="offcanvasExampleLabel">
					<div class="offcanvas-body menuBody">
						<ul>
							<li><a class="option" href="FindCoursesByStudent">Mis Cursos</a></li>
							<li><a class="option" href="Logout">Cerrar Sesión</a></li>
						</ul>
					</div>
				</div>
			</div>
		</nav>
	</header>

	<main>

		<% if(name != null && surname != null) { %>
		<h1 class="helloMessage">
			Hola, 
			<%= name %>
			<%= surname %></h1>
		<% } %>

		<div id="searchResult"></div>
	</main>



</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="indexStudent.js"></script>
</html>