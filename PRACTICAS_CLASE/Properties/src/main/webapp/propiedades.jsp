<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Propiedades</title>
</head>
<body>

	<h1>Lista de Propiedades del bd.properties</h1>
	<ul>
		<%
		ArrayList<String> listaProp = (ArrayList<String>) request.getAttribute("propiedades");
		out.println(listaProp.toString());
		
		%>
	</ul>

</body>
</html>