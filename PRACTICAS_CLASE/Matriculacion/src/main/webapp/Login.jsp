<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<%
	if (!session.isNew()) {
%>

	<form method="post">
		<a href="Logout">
			<input type="submit" name="salir" value="Salir"/>
		</a>
	</form>

<%
    } else {
%>

	<form method="post">
		<input type="submit" name="entrar" value="Entrar"/>
	</form>

<%
    }
%>

</body>
</html>