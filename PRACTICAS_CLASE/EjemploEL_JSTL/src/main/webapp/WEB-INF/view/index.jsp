<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio</title>
</head>
<body>

	<h1>HOLA</h1>
	
	<%-- <p>${requestScope.method}</p> --%>
	<%-- <p style="color:red">${saludo}</p> --%>
	<p>${pageContext.request.method}</p>
	<p>${sessionScope.saludo}</p>
	<p>${requestScope.saludo}</p>
	<p>${33+36}</p>
	<p><c:out value="CLAUDIA, ${7*3} AÑOS"></c:out></p>
	<c:set var="job" scope="session" value="DEVELOPER"/>
	<c:out value="${job}"/>

</body>
</html>