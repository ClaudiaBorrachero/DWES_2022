<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" />  
<jsp:include page="include/bootstrap.jsp"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenid@</title>
</head>
<body style="background: navy">

	<div class="container">
		<div class="row justify-content-center m-5 align-items-center" style="box-shadow: 0 0 10px 2px white; border-radius: 15px; background: white">
		
			<div class="col-sm-12 col-md-5 col-lg-5">
				<a href="Login">
					<img class="img-fluid" src="http://quickdine.xyz/assets/img/gallery/login.png">
				</a>
			</div>
		
			<div class="col-sm-12 col-md-5 col-lg-5 mt-5">
				
				<form method="post" class="p-3">
				
					<h2 class="w-100 text-center" style="color:navy"><b>INICIAR SESIÓN</b></h2>
					
					<label class="form-label mt-3"><h5>Usuario</h5></label>
					<input class="form-control" type="text" name="usuario">
					
					<label class="form-label mt-3"><h5>Password</h5></label>
					<input class="form-control" type="password" name="passw1">
					
					<a href="Login" class="pt-1 w-100">¿Olvidó su nombre de usuario o contraseña?</a>
					
					<input type="submit" value="ENTRAR" name="ENTRAR" class="mt-3 w-100 btn btn-primary">
				</form>
				
				<form action="Registro" class="p-3">
					<h6 class="w-100 text-center">Crea una cuenta si aún no estás registrado</h6>
					<input type="submit" value="REGISTRARSE" name="REGISTRARSE" class="w-100 btn btn-secondary">
				</form>
				
			</div>
		</div>
	</div>

</body>
</html>