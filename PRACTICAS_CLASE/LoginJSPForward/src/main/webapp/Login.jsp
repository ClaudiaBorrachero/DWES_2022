<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<% 
	if(request.getParameter("error")!=null){
	%>
		
	<p style="color:red">
	
	<%= request.getParameter("error") %>
	
	<% } %>

	<form action="Forward.jsp" method="post">
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