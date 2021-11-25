<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Password</title>
<jsp:include page="include/bootstrap.jsp"/>
</head>
<body>
<jsp:include page="include/barra.jsp"/>
	<div class="container">
	
		<div class="m-5">
			<a href="DatosUsuario" class="btn btn-primary">Volver</a>
		</div>
	
		<div class="row justify-content-center mt-5">
			<div class="col-8">
				<form method="post">
				
					<%-- <c:forEach items="${ usuario }" var="usuario">
						<p>${ usuario.usuario }</p>
					</c:forEach> --%>
				
					<h2>MODIFICAR DATOS DE LA CUENTA</h2>
					<label for="usuario" class="form-label mt-3">Usuario</label>
    				<input value="${ sessionScope.usuario }" type="text" class="form-control" id="usuario" name="usuario" required disabled>	
    				<label for="email" class="form-label mt-3">Email</label>
    				<input value="${ sessionScope.email }" type="email" class="form-control" id="email" name="email" required disabled>
    				<label for="password" class="form-label mt-3">Password</label>
    				<input type="password" class="form-control" id="password" name="password" required>
    				<label for="password2" class="form-label mt-3">Confirmación de Password</label>
    				<input type="password" class="form-control" id="password2" name="password2" required>
    				
    				<c:if test="${requestScope.diferentes == null}">
						<span class="form-text small text-muted"> To confirm, type
							the new password again. </span>
					</c:if>

					<c:if test="${requestScope.diferentes != null}">
						<div class="alert alert-danger" role="alert">Las contraseñas
							no son iguales</div>
					</c:if>
    				
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="ACTUALIZAR DATOS" />
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>