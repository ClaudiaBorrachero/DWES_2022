<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	
	<% if (request.getMethod().equals("POST")){%>
	
		<% 
		if((request.getParameter("user")).equals("admin") 
			&& (request.getParameter("pass")).equals("admin")){
	%>
	
	<jsp:forward page="Admin.jsp"/>
	
	<%
		}
	if((request.getParameter("user")).equals("usuario") 
			&& (request.getParameter("pass")).equals("usuario")){
	%>
	
	<jsp:forward page="Usuario.jsp"/>
	
	<% } else { %>
		
		<p style="color:red">Login incorrecto</p>
	
	<% } %>
		
	<% } %>

	<form method="post">
		<label>Usuario:</label>
		<input type="text" name="user" id="user" required>
		<br>
		<label>Contraseña:</label>
		<input type="text" name="pass" id="pass" required>
		<br>
		<input type="submit" value="Enviar">
	</form>	
</body>
</html>