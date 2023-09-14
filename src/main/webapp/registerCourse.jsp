<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Curso</title>
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
				<input id="startDate" type="date" name="startDate" required>
				<label for="starDate">Fecha Inicio</label>
			</div>
			<div class="date">
				<input id="endDate" type="date" name="endDate" required> <label
					for="endDate">Fecha Fin</label>
			</div>
			<div class="contenedor">
				<select id="select" name="select">
					<option value="">Todos los cursos</option>
				</select>
			</div>
			<input type="submit" value="CREAR">
		</form>
		<% if (message != null) { %>
		<div><%=message %></div>
		<% } %>
	</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="registerCourse.js"></script>
</html>