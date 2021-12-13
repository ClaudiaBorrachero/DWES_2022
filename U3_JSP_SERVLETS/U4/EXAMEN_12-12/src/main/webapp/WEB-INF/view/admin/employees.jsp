<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" />  
<jsp:include page="../include/bootstrap.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Employees</title>
</head>
<body>

	<jsp:include page="../include/barra.jsp"/>
	<div class="container mt-5">
	
		<div class="row justify-content-end">
			<div class="col-3">
				<a href="${pageContext.request.contextPath}/Admin/AddEmpleado" class="btn btn-primary">Añadir Empleado</a>
			</div>
		</div>
	
		<div class="row justify-content-center">
			<div class="col-12">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Número</th>
							<th>Apellidos</th>
							<th>Nombre</th>
							<th>Puesto</th>
							<th>Oficina</th>
							<th>Jefe</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${employee}" var="e">
							<tr>
								<td>${e.employeeNumber}</td>
								<td>${e.lastName}</td>
								<td>${e.firstName}</td>
								<td>${e.jobTitle}</td>
								<td>${e.officeCode}</td>
								<td>${e.reportsTo}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>