<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Curso</title>
<link rel="stylesheet" href="registerCourse.css" type="text/css">
</head>
<body>
	<form action = "RegisterCourse" method="post">
    <div class="user-box">
      <input id="nameCourse" type="text" name="name" required>
      <label id="nameCourse">Nombre del Curso</label>
    </div>
    <div class="user-box">
      <input id="startDate" type="date" name="startDate" required>
      <label id="userName">Fecha de Inicio</label>
    </div>
    <div class="user-box">
      <input id="userName" type="date" name="email" required>
      <label id="userName">Fecha de Fin</label>
    </div>
    <input type ="submit" value="REGISTRAR">
   
  </form> 

</body>
</html>