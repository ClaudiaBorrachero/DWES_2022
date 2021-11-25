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
<title>REGISTRO</title>
</head>
<body style="background: navy">
<jsp:include page="barra.jsp"/>
	<div class="container">
		<div class="row justify-content-center m-5">
			<div class="col-sm-12 col-md-8 col-lg-8" style="box-shadow: 0 0 10px 2px white; border-radius: 15px; background: white">
				
				<form method="post" class="p-3">
				
					<h2 class="w-100 text-center" style="color:navy"><b>CREA UN NUEVO USUARIO</b></h2>
					
					<label class="form-label mt-3"><h5>Nombre</h5></label>
					<input class="form-control" type="text" name="nombre" id="nombre" REQUIRED>
					
					<c:if test="${requestScope.error != null}">
    					<p><small class="text-danger"> Usuario ya existente </small> </p>
    				</c:if>					
					
					<label class="form-label mt-3"><h5>Correo electrónico</h5></label>
					<input class="form-control" type="email" name="correo" id="correo" REQUIRED>
					
					<c:if test="${requestScope.error != null}">
    					<c:out value="${requestScope.email}"></c:out>	
    				</c:if>
					
					<label class="form-label mt-3"><h5>Rol</h5></label>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="rol" value="admin" id="rol" required/>
						<label class="form-check-label" for="rol">ADMIN</label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="rol" value="normal" id="rol" checked required/>
						<label class="form-check-label" for="rol">NORMAL</label>
					</div>		
					
					<label class="form-label mt-3"><h5>Password</h5></label>
					<input class="form-control" type="password" name="passw1" id="passw1" REQUIRED>
					
					<label class="form-label mt-3"><h5>Confirmación de Password</h5></label>
					<input class="form-control" type="password" name="passw2" id="passw2" REQUIRED>
					
					<input type="submit" value="REGISTRARSE" name="REGISTRARSE" class="mt-3 w-100 btn btn-primary">
				</form>
				
			</div>
		</div>
	</div>

</body>
</html>