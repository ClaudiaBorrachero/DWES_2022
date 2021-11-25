<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Seleccionar</title>
</head>
<body>

	<form method="post" style="padding:30px">
		<label>Nombre: </label><br>
		<input type="text" name="nombre" required><br>
		<label>Apellido: </label><br>
		<input type="text" name="apellido" required><br>
		<label>Correo electrónico: </label><br>
		<input type="email" name="correo" required><br><br>
		<label>Curso:</label><br>
		<input type="radio" name="radio" value="1ºDAW">1ºDAW<br>
		<input type="radio" name="radio" value="2ºDAW">2ºDAW<br><br>
		<label>Selecciona:</label><br>
		<select name="select" size="3" MULTIPLE>
			<option value="DWES">DWES</option>
			<option value="DWEC">DWEC</option>
			<option value="DAW">DAW</option>
		</select>
		<br><br>
		<input type="submit" value="Matricularme" name="matricularme">
	</form>

</body>
</html>