<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
</head>
<jsp:include page="include/bootstrap.jsp"/>
<body>

	<jsp:include page="include/barra.jsp"/>
	<c:if test="${ sessionScope.usuario!=null }">
		<div class="container mt-5">
		
			<div class="row justify-content-center mt-5">
				<div class="col-6">
				<c:if test="${sessionScope.role=='usuario'}">
					<h1 class="text-center"><b>Categorías disponibles</b></h1>
					
				</c:if>
				
				<c:if test="${sessionScope.role=='admin'}">
					<h1 class="text-center"><b>Operaciones disponibles</b></h1>
					<ul>
						<li>
							<a href="${pageContext.request.contextPath}/Admin/Empleados">Mostrar Empleados</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/Admin/AddEmpleado">Añadir Empleado</a>
						</li>
					</ul>					
				</c:if>
				
				<%-- <c:if test="${role=='usuario' and sessionScope.usuario!=null}">
					<img class="img-fluid" src="https://us.123rf.com/450wm/maxborovkov/maxborovkov1809/maxborovkov180900067/110330061-cartel-de-bienvenida-de-oto%C3%B1o-con-coloridas-hojas-de-arce-fondo-de-vector-.jpg?ver=6">
				</c:if> --%>
				
				</div>
			</div>
		</div>
	</c:if>

</body>
</html>