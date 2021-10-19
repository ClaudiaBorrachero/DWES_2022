<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario</title>
</head>
<body>

	<form method="post" action="<%= request.getContextPath() %>/FormServlet">
		<label for="simple">Campo de formulario simple: </label>
		<input type="text" name="simple" id="name"><br><br>
		<label>Selecciona: </label>
		<select name="select1" size="3" multiple>
			<option>Citröen</option>
			<option>Audi</option>
			<option>Mercedes</option>
		</select><br><br>
		<label>Checkea algo guapi :</label><br>
		<input type="checkbox" name="checkbox" value="Blanco">Blanco<br>
		<input type="checkbox" name="checkbox" value="Negro">Negro<br><br>
		<input type="submit" name="submit" value="Enviar">
	</form>

</body>
</html>