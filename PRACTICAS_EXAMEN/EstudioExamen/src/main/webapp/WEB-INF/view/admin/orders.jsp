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
<title>Lista de ORDERS</title>
</head>
<body>

	<jsp:include page="../include/barra.jsp"/>
	<div class="container mt-5">	
	
		<div class="row justify-content-center">
			<div class="col-10">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>OrderNumber</th>
							<th>OrderDate</th>
							<!-- <th>RequiredDate</th> -->
							<th>ShippedDate</th>
							<th>Status</th>
							<!-- <th>Comments</th> 
							<th>CustomerNumber</th>
							<th>OrderDetails</th> -->
							<th>Ver+</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${orders}" var="o">
							<tr>
								<td>${o.orderNumber}</td>
								<td>${o.orderDate}</td>
								<%-- <td>${o.requiredDate}</td> --%>
								<td>${o.shippedDate}</td>
								<td>${o.status}</td>
								<%-- <td>${o.comments}</td>
								<td>${o.customerNumber}</td>
								<td>${o.orderDetails}</td> --%>
								<td><a href="OrderDetails?orderNumber=${o.orderNumber}"><i class="bi bi-eye"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>