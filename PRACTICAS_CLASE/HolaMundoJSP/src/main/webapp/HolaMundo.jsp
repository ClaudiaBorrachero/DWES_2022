<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HolaMundoJSP</title>
</head>
<body>
	<h1>Hola Mundo JSP</h1>
	<h2>ADIÓS MUNDO CRUEL</h2>
	<h3 style="color:hotpink">La fecha de hoy es : <%= new Date() %></h3>
	<ul>
	
	<%	
	/* response.getWriter().println("<ul>"); */
	/* out.println("<ul>"); */
		for(int i = 0; i<101 ; i++){
			/* response.getWriter().println("<li>" + i + "</li>"); */
			/* out.println("<li>" + i + "</li>"); */
	%>
	
	<li> <%= i %> </li>
	
	<%}  
	/* response.getWriter().println("</ul>"); */
	/* out.println("</ul>"); */
	%>
	
	</ul>
</body>
</html>