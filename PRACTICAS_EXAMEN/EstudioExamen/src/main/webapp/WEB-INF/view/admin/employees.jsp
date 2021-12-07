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
			<div class="col-2">
				<a class="btn btn-primary w-100" href="Add">AÑADIR EMPLOYEE</a>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-10">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>EmployeeNumber</th>
							<th>Email</th>
							<th>OfficeCode</th>
							<th>JobTitle</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${employee}" var="e">
							<tr>
								<td>${e.employeeNumber}</td>
								<td>${e.email}</td>
								<td>${e.officeCode}</td>
								<td>${e.jobTitle}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>