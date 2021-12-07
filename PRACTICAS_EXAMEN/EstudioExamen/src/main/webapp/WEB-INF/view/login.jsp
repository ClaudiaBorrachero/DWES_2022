<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
<jsp:include page="include/bootstrap.jsp"/>
</head>
<body>

	<c:if test="${sessionScope.role=='usuario' }">
		<jsp:include page="include/barra.jsp"/>
		<img class="img-fluid" src="https://us.123rf.com/450wm/maxborovkov/maxborovkov1809/maxborovkov180900067/110330061-cartel-de-bienvenida-de-oto%C3%B1o-con-coloridas-hojas-de-arce-fondo-de-vector-.jpg?ver=6">
	</c:if>

	<div class="container mt-5">
		<c:if test="${sessionScope.usuario==null}">
			<h2 class="text-center">
				<b>Iniciar Sesión</b>
			</h2>
			<div class="row justify-content-center mt-5">
				<div class="col-6">
					<form method="post">
						<label for="usuario" class="form-label">Usuario</label> <input
							type="text" class="form-control" id="usuario" name="usuario"
							required> <label for="password" class="form-label mt-3">Password</label>
						<input type="password" class="form-control" id="password"
							name="password" required>
						<c:if test="${error!=null}">
							<p class="text-danger text-small mt-3">${error}</p>
						</c:if>
						<input type="submit" class="btn btn-primary w-100 mt-3"
							value="ENTRAR" />
					</form>
					<p class="text-primary text-center mt-3">
						<a href="RegisterServlet">¿No tienes cuenta?. Regístrate</a>
					</p>
				</div>
			</div>
		</c:if>
	</div>

</body>
</html>