<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BEANS</title>
</head>
<body>

	<jsp:useBean id="usuario" scope="request" class="org.alixar.servidor.cnbm.model.Usuario"/>

	<p>Nombre: <%= usuario.getNombre() %></p>
	<p>Apellidos: <%= usuario.getApellidos() %></p>
	<p>Direccion: <%= usuario.getDireccion() %></p>
	<p>Edad: <%= usuario.getEdad() %></p>
	<p>Aficiones: 
	
	<%
		String[] aficiones = usuario.getAficiones();
	%>
	
	<% for (int i = 0 ; i < aficiones.length ; i++){ %>
		
		<p> <%= aficiones[i] %> </p>
		
	<% } %> 
	</p>

</body>
</html>