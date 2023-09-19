<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Curso</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet" href="registerCourse.css" type="text/css">
</head>
<% String message = (String) request.getAttribute("message"); %>
<body onload="initRegister()">
	<div class="login-box">
		<h2>Crear Nuevo Curso</h2>
		<form action="RegisterCourse" method="post">
			<div class="user-box">
				<input id="nameCourse" type="text" name="name" required> <label
					for="nameCourse">Nombre del Curso</label>
			</div>
			<div class="date">
				<input class="form-control" id="startDate" type="date" name="startDate" required>
				<label for="starDate">Fecha Inicio</label>
			</div>
			<div class="contenedor">
				<select class="form-select" id="select" name="select">
					<option value="">Todos los cursos</option>
				</select>
			</div>
			<div id="buttonContainer">
				<input type="submit" class="btn btn-outline-light" value="CREAR">
			</div>
			
		</form>
		<% if (message != null) { %>
		<div class="messageError"><%=message %></div>
		<% } %>
	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="registerCourse.js"></script>
</html>