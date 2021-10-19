<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A</title>
</head>
<body>
	<h1>HOLA SOY A</h1>
	
	<jsp:useBean id="usuario" scope="request" class="model.Usuario"/>
	<%= (String)request.getParameter("destino") %>
	
	<p>Usuario: <%= usuario.getUsuario() %> </p>
	<p>Pass: <%= usuario.getPass() %> </p>
	
</body>
</html>