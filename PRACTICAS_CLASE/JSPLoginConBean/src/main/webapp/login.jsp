<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginBean</title>
</head>
<body>

<%
	String error = null;
	//Compruebo si vengo de una petición del formulario
	if (request.getMethod().equals("POST") && request.getParameter("submit") != null) { %>

		
	<jsp:useBean id="loginBean" scope="application" class="org.alixar.servidor.cnbm.model.Usuario">
		<jsp:setProperty name="loginBean" property="user"/>
		<jsp:setProperty name="loginBean" property="pass"/>
	</jsp:useBean>
	
		<% 
		if (loginBean.isUsuarioValid()) {
			out.println("Bienvenido a la zona de administración");
			
			return;
		} else {
			//invalid user. Set error message
			error = "Credenciales erróneas. Pruebe de nuevo";
		}
	}
%>
<%
		if (error != null) {
%>
		<p style="color: red;">
<%
			out.print(error);
%>
		</p>
<%
		}
%>
	<form method="post">
		<label>Usuario:</label>
		<input type="text" name="user" id="user" required><br>
		<label>Contraseña:</label>
		<input type="text" name="pass" id="pass" required><br>
		<input type="submit" value="Enviar">
	</form>	

</body>
</html>