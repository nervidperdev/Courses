<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio Sesion</title>
<link rel="stylesheet" href="login.css" type="text/css">
</head>
<body>
<div class="login-box">
  <h2>Inicio de Sesion</h2>
  <form action="Login" method="post">
    <div class="user-box">
      <input id="userName" type="text" name="email" required>
      <label id="userName">Email</label>
    </div>
    <div class="user-box">
      <input type="password" name="password" required>
      <label>Contraseña</label>
    </div>
    <div>
    	<label class="inputTeacher" id="inputTeacher">Profesor</label>
    	<input type="radio" value="teacher" name="type" onclick="visibility();">
	    <label class="inputTeacher" id="inputStudent">Alumno</label>
	    <input type="radio" value="student" name="type" onclick="visibility();" checked="checked">
    	<input type ="submit" value="ACCEDER">
    </div>
 
   
  </form> 
  
  <div id="registerStudent" class="visibility">
   <p>Eres nuevo?<a id="enlace" href="registerStudent.jsp">Registrate</a></p>
  </div>
   <% String error = (String)request.getAttribute("error"); %>
          <div>
          		<% if (error != null) { %>
          			<span><%=error %></span>
          		<% } %>
          </div>
  
</div>

</body>
<script type="text/javascript" src="login.js"></script>
</html>