<%@page import="com.nervidper.courses.online.model.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TUS CURSOS</title>
</head>
<header>
	<nav>
	 	<a href="login.jsp">INICIAR SESION </a>
	 	<a href="registerStudent.jsp">¿NUEVO ALUMNO?REGISTRATE</a>	
	 </nav>
</header>
<body>
	<label for="findCourse"></label>
	<input id="findCourse" type="text" placeholder="Buscar curso">
	

	<div> 
	<% List<Category> list=(List<Category>)request.getAttribute("categoryList");%>
        <fieldset id="busqueda">
          <form  method="get">
        	  <select id="select">
				 <% for (Category category:list){ %>
					 <option value="<%=category.getCategoryId()%>"><%=category.getNameCategory()%></option>
				<% } %>
				</select>
          	</form>
          </fieldset>
      </div>
      
    <div id="listResultCourses"></div>
       
</body>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="findCourseByName.js"></script>
</html>
