<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forward</title>
</head>
<body>
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
		
	<%-- <%@include file = "Login.jsp"--%> 
	
	<jsp:forward page="Login.jsp">
		<jsp:param name="error" value="Login incorrecto"/>
	</jsp:forward>
	
	<!-- <div style="color:red">Usuario y/o Contraseña incorrectos</div> --> 
	<% } %>
</body>
</html>