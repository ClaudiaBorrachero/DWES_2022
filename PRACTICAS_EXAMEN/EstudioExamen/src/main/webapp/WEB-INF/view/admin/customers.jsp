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
<title>Lista de Customers</title>
</head>
<body>

	<jsp:include page="../include/barra.jsp"/>
	<div class="container mt-5">	
	
		<div class="row justify-content-center">
			<div class="col-10">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>CustomerNumber</th>
							<th>CustomerName</th>
							<th>City</th>
							<th>PostalCode</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${customer}" var="c">
							<tr>
								<td>${c.customerNumber}</td>
								<td>${c.customerName}</td>
								<td>${c.city}</td>
								<td>${c.postalCode}</td>
								<td><a href="Update?cn=${c.customerNumber}&checkn=${pago.checkNumber}">
									<i onmouseover="this.style.color='yellowgreen';" onmouseout="this.style.color='navy';"
									class="bi bi-pencil-fill" style="color: navy"></i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>