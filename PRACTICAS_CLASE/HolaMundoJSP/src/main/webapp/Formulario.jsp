<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario</title>
</head>
<body>
	<form action="Bienvenido.jsp" method="post">
		<label>Nombre:</label>
		<input type="text" name="nombre" id="nombre" required>
		<br>
		<label>Apellidos:</label>
		<input type="text" name="apellidos" id="apellidos" required>
		<br>
		<input type="submit" value="Enviar">
	</form>		
</body>
</html>