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
<title>Lista de USUARIOS</title>
</head>
<body>

	<jsp:include page="../include/barra.jsp"/>
	<div class="container mt-5">	
	
		<div class="row justify-content-center">
			<div class="col-10">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Usuario</th>
							<th>Password</th>
							<th>Email</th>
							<th>Role</th>
							<th>FirstName</th>
							<th>LastName</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${usuarios}" var="u">
							<tr>
								<td>${u.usuario}</td>
								<td>${u.password}</td>
								<td>${u.email}</td>
								<td>${u.role}</td>
								<td>${u.firstName}</td>
								<td>${u.lastName}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>