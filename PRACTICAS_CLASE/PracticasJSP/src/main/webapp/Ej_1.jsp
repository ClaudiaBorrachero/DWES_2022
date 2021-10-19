<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio 1</title>
</head>
<body>
	<%--
    Documento   : JSP - Ejercicio 1
    Crea una aplicación web en Java que muestre tu nombre y tus datos   
    personales por pantalla. La página principal debe ser un archivo con la   
    extensión jsp. Comprueba que se lanzan bien el servidor y el navegador   
    web. Observa los mensajes que da el servidor. Fíjate en la dirección que   
    aparece en la barra de direcciones del navegador.
--%>
	
	<form method="post">
		<label>Nombre: </label>
		<input type="text" name="nombre">
	</form>
	<!-- <h1>Hola soy Claudia Borrachero</h1> -->
	
	<%
	if(request.getMethod().equals("POST")){
		out.print(request.getParameter("nombre"));
	}
	%>

</body>
</html>