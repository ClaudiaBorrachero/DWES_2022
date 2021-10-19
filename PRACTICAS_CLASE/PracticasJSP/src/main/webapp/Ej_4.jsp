<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio 4</title>
</head>
<body>
	
<%-- Documento   : JSP - Ejercicio 4
Realiza un conversor de euros a dolares. --%>
	
<form method="post">
	<label>Euros:</label>
	<input type="number" step="any" name="euros">
	<input type="submit">
</form>
	
<%
if(request.getMethod().equals("POST")){
	
	double euros = Double.parseDouble(request.getParameter("euros"));
	double dolar = 1.16;
	
	dolar = Math.round((dolar*euros)*100.0)/100.0;	
	
	out.println(euros + "€ = " + dolar + "$");
}
%>
	
</body>
</html>