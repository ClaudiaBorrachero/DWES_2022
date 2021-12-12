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
<title>Lista de Payments</title>
</head>
<body>

	<jsp:include page="../include/barra.jsp"/>
	<div class="container mt-5">	
	
		<div class="row justify-content-end">
			<div class="col-2">
				<a class="btn btn-primary w-100" href="AddPayment">AÑADIR PAGO</a>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-10">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>CustomerNumber</th>
							<th>CheckNumber</th>
							<th>Date</th>
							<th>Amount</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagos}" var="pago">
							<tr>
								<td>${pago.customerNumber}</td>
								<td>${pago.checkNumber}</td>
								<td>${pago.date}</td>
								<td>${pago.amount}</td>
								<td><a href="UpdatePayment?cn=${pago.customerNumber}&checkn=${pago.checkNumber}">
									<i onmouseover="this.style.color='yellowgreen';" onmouseout="this.style.color='navy';" 
									class="bi bi-pencil-fill" style="color: navy"></i></a>
									
									<a href="DeletePayment?cn=${pago.customerNumber}&checkn=${pago.checkNumber}">
									<i onmouseover="this.style.color='yellowgreen';" onmouseout="this.style.color='navy';" 
									class="bi bi-trash" style="color: navy"></i></a>
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