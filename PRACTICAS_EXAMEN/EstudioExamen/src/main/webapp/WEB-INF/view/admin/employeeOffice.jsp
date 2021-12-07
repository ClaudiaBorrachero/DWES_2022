<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="interface" />
<jsp:include page="../include/bootstrap.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMPLOYEES</title>
</head>
<body>

	<jsp:include page="../include/barra.jsp" />
	<div class="container">
		
		<div class="text-center m-3">
			<h1 style="color: navy">EMPLEADOS DE LA OFICINA <b>"${requestScope.oficina.city.toUpperCase() }"</b></h1>
		</div>
		
		<div class="row justify-content-center">
			<div class="col-10">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>EmployeeNumber</th>
							<th>LastName</th>
							<th>FirstName</th>
							<th>Extension</th>
							<th>Email</th>
							<th>OfficeCode</th>
							<th>ReportsTo</th>
							<th>JobTitle</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${employees}" var="e">
							<tr>
								<td>${e.employeeNumber}</td>
								<td>${e.lastName}</td>
								<td>${e.firstName}</td>
								<td>${e.extension}</td>
								<td>${e.email}</td>
								<td>${e.officeCode}</td>
								<td>${e.reportsTo}</td>
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