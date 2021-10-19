<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio 3</title>
</head>
<body>

<%-- Documento   : JSP - Ejercicio 3 
	 Realiza una aplicación que calcule la media de tres notas. --%>

<form method="post">
	<label>Nota 1</label>
	<input type="number" step="any" name="nota1" required><br>
	<label>Nota 2</label>
	<input type="number" step="any" name="nota2" required><br>
	<label>Nota 3</label>
	<input type="number" step="any" name="nota3" required><br>
	<input type="submit" value="Media">
</form>

<%
if(request.getMethod().equals("POST")){
	
	double nota1 = Double.parseDouble(request.getParameter("nota1"));
	double nota2 = Double.parseDouble(request.getParameter("nota2"));
	double nota3 = Double.parseDouble(request.getParameter("nota3"));
	double media;

	media = (nota1+nota2+nota3)/3;

	out.println(Math.round(media));
}
%>

</body>
</html>