<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Iniciar Sesión</title>
</head>
<jsp:include page="include/bootstrap.jsp"/>
<body>

	<div class="container mt-5">
	
		<jsp:include page="include/barra.jsp"/>
	
		<div class="row justify-content-center mt-5">
			<div class="col-6">
			<c:if test="${sessionScope.usuario==null}">
				<form method="post">
					<label for="usuario" class="form-label">Usuario</label>
    				<input type="text" class="form-control" id="usuario" name="usuario" required >	
    				<label for="password" class="form-label mt-3">Password</label>
    				<input type="password" class="form-control" id="password" name="password" required>
    				<c:if test="${error!=null}">
    					<p class="text-danger text-small mt-3">${error}</p>
    				</c:if>
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="ENTRAR" />
				</form>
				<p class="text-primary text-center mt-3"><a href="${pageContext.request.contextPath}/RegisterServlet">¿No tienes cuenta?. Regístrate</a></p>
			</c:if>
			
			<c:if test="${sessionScope.usuario!=null }">
				<img class="img-fluid" src="https://us.123rf.com/450wm/maxborovkov/maxborovkov1809/maxborovkov180900067/110330061-cartel-de-bienvenida-de-oto%C3%B1o-con-coloridas-hojas-de-arce-fondo-de-vector-.jpg?ver=6">
			</c:if>
			
			</div>
		</div>
	</div>

</body>
</html>