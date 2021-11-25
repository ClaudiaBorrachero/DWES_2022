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
<title>UPDATE</title>
</head>
<body style="background: navy">
<jsp:include page="barra.jsp"/>
	<div class="container">
		<div class="row justify-content-center m-5">
			<div class="col-sm-12 col-md-8 col-lg-8" style="box-shadow: 0 0 10px 2px white; border-radius: 15px; background: white">
				
				<form method="post" class="p-3" action="UpdateUser">
				
					<h2 class="w-100 text-center" style="color:navy"><b>ACTUALIZA UN USUARIO</b></h2>
					
					<label class="form-label mt-3"><h5>Nombre</h5></label>
					<input class="form-control" type="text" name="nombre" value="${ usuario.nombre }" disabled id="nombre">
					
					<label class="form-label mt-3"><h5>Correo electrónico</h5></label>
					<input class="form-control" type="email" name="correo" value="${ usuario.email }" disabled id="correo">
					
					<label class="form-label mt-3"><h5>Rol</h5></label>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="rol" value="${ usuario.rol }" required id="checkbox"/>
						<label class="form-check-label" for="rol">ADMIN</label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="rol" value="${ usuario.rol }" checked required id="checkbox"/>
						<label class="form-check-label" for="rol">NORMAL</label>
					</div>		
					
					<label class="form-label mt-3"><h5>Password</h5></label>
					<input class="form-control" type="text" name="passw1" value="${ usuario.password }" id="passw1">
					
					<input type="submit" value="ACTUALIZAR" class="mt-3 w-100 btn btn-primary">
				</form>
				
			</div>
		</div>
	</div>

</body>
</html>