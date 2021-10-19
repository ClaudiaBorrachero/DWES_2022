<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Datos</title>
</head>
<body>

	<h1>Datos del formulario</h1>
	<!-- UTILIZAMOS GETPARAMETER PARA TEXTO -->
	<%-- <h3 style="color:navy">Simple: <%= request.getAttribute("simple") %></h3> --%>
	<h3 style="color:navy">Simple: <%= request.getParameter("simple") %></h3>
	<%-- <h3 style="color:red">Coche: <%= request.getAttribute("select1") %> </h3> --%>
	<h3 style="color:red">Coche: <%= request.getParameter("select1") %> </h3>
	<%-- <h3 style="color:green">Color: <%= request.getAttribute("checkbox") %> </h3> --%>
	<h3 style="color:green">Color: <%= request.getParameter("checkbox") %> </h3>

</body>
</html>