<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
<link rel="stylesheet" href="registerStudent.css" type="text/css">
</head>
<body>
	<div class="login-box">
  <h2>Registro Nuevo Alumno</h2>
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
  
    <input type ="submit" value="REGISTRAR">
   
  </form> 
</body>
</html>