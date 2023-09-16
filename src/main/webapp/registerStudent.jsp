<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet" href="registerStudent.css" type="text/css">
</head>
<body>
<div class="login-box">
  <h2>Registro Alumno</h2>
  <form action = "Register" method="post">
    <div class="user-box">
      <input id="userName" type="text" name="name" required>
      <label id="userName">Nombre</label>
    </div>
    <div class="user-box">
      <input id="userName" type="text" name="surname" required>
      <label id="userName">Apellido</label>
    </div>
    <div class="user-box">
      <input id="userName" type="text" name="email" required>
      <label id="userName">Email</label>
    </div>
    <div class="user-box">
      <input id="userName" type="text" name="email" required>
      <label id="userName">Repita email</label>
    </div>
    <div class="user-box">
      <input type="password" name="password" required>
      <label>Contraseña</label>
    </div>
    <div class="user-box">
      <input type="password" name="password" required>
      <label>Repita Contraseña</label>
    </div>
    <input type ="submit" class="btn btn-outline-light" value="REGISTRAR">
  </form>
</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
</html>