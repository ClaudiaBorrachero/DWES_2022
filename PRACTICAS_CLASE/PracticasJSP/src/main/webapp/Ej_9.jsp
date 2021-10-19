<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio 9</title>
</head>
<body>
	
	<%-- Mejora la aplicación anterior de tal forma que no haga falta introducir el
    día de la semana en que cae el día 1 y el número de días que tiene el mes.
    El programa debe deducir estos datos del mes y el año.
    Pista: puedes usar la clase Calendar (java.util.Calendar). --%>
	
	<form method="post">
		<label>Mes: </label>
		<input type="text" name="mes"><br>
		<label>Año: </label>
		<input type="number" name="anio"><br>
		<label>Texto: </label>
		<input type="text" name="texto"><br>
		<label>Día de la semana que cae el día 1: </label>
		<input type="number" name="dia1"><br>
		<label>Número de días que tiene el mes: </label>
		<input type="number" name="nums"><br>
		<input type="submit" value="Generar calendario">
	</form>
	
</body>
</html>