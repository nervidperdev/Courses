<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio Sesion</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet" href="login.css" type="text/css">
</head>
<body>
	<div class="login-box">
		<h2>Inicio de Sesion</h2>
		<form action="Login" method="post">
			<div class="user-box">
				<input id="userName" type="text" name="email" required> <label
					id="userName">Email</label>
			</div>
			<div class="user-box">
				<input type="password" name="password" required> <label>Contraseña</label>
			</div>

			<div class="bottomContainer">
				<div class="radioGroup">
					<label class="inputTeacher">Profesor</label> <input id="inputTeacher"
						class="form-check-input" type="radio" value="teacher" name="type" /> <label class="inputTeacher"
						>Alumno</label> <input id="inputStudent" class="form-check-input"
						type="radio" value="student" name="type" checked />
				</div>
				<input type="submit" class="btn btn-outline-light" value="ACCEDER" />
			</div>

		</form>
		<div id="registerStudent" class="visibility">
			<p>
				¿Eres nuevo? <a id="enlace" href="registerStudent.jsp">Registrate</a>
			</p>
		</div>
		
		<% String error = (String) request.getAttribute("error");%>
		<div id="loginError">
			<%
			if (error != null) {
			%>
			<span><%=error%></span>
			<%
			}
			%>
		</div>
	</div>
		
		
		
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="login.js"></script>
</html>