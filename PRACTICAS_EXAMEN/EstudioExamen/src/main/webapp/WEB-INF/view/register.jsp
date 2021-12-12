<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<jsp:include page="include/bootstrap.jsp"/>
</head>
<body>
	<jsp:include page="include/barra.jsp"/>
	<div class="container">
		<div class="row justify-content-center mt-5">
			<h2 class="text-center"><b>Formulario de registro</b></h2>
			<div class="col-6">
				<form method="post">
					<label for="firstName" class="form-label mt-3">Nombre</label>
    				<input type="text" class="form-control" id="firstName" name="firstName" required >	
    				<label for="lastName" class="form-label mt-3">Apellido</label>
    				<input type="text" class="form-control" id="lastName" name="lastName" required >	
					<label for="usuario" class="form-label mt-3">Usuario</label>
    				<input type="text" class="form-control" id="usuario" name="usuario" required >	
    				<label for="email" class="form-label mt-3">Email</label>
    				<input type="email" class="form-control" id="email" name="email" required >
    				<label for="password" class="form-label mt-3">Password</label>
    				<input type="password" class="form-control" id="password" name="password" required>
    				<label for="password2" class="form-label mt-3">Confirmación de password</label>
    				<input type="password" class="form-control" id="password2" name="password2" required>
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="REGISTRAR" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>