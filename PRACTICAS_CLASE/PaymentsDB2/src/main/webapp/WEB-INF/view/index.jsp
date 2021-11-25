<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="org.alixar.servidor.cnbm.model.Payments" import="java.util.ArrayList" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="interface" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Pagos</title>
<jsp:include page="include/bootstrap.jsp"/>
<!-- EN CASO DE USAR BEAN -->
<%-- <jsp:useBean id="clientes" scope="request" class="java.util.ArrayList<org.alixar.servidor.cnbm.model.Customer>"/> --%>
</head>
<body>	
	<div class="container mt-5">
		<div class="row justify-content-center mt-5">
			<div class="col-10">
				<table class="table table-striped table-hover">
					<%-- <thead>
						<th><fmt:message key="customerNumber" /></th>
						<th><fmt:message key="checkNumber" /></th>
						<th><fmt:message key="paymentDate" /></th>
						<th><fmt:message key="amount" /></th>
						<th><fmt:message key="Acciones" /></th>
					</thead>  --%>
					
					<thead>
						<th>CustomerNumber</th>
						<th>CheckNumber</th>
						<th>PaymentDate</th>
						<th>Amount</th>
						<th>Acciones</th>
					</thead>
					<%-- <tbody>
						<c:forEach items="${pagos}" var="pago">
							<tr>
								<td>${pago.customerNumber}</td>
								<td>${pago.checkNumber}</td>
								<td>${pago.paymentDate}</td>
								<td>${pago.amount}</td>
								<td><a href="/Eliminar?customerNumber=${pago.customerNumber}&checkNumber=${pago.checkNumber}" style="margin-right:15px; margin-left:40px"><i class="bi bi-trash-fill"></i></a>
									<a href="/Actualizar?customerNumber=${pago.customerNumber}&checkNumber=${pago.checkNumber}"><i class="bi bi-pencil-fill"></i></a></td>
							<tr>	
						</c:forEach>
					</tbody> --%>
					
					<tbody>
					
						<c:choose>
						
							<c:when test="${pago.amount>0 and pago.amount<10000 }">
								<td class="text-primary">${pago.amount }</td>
							</c:when>
							<c:when test="${pago.amount>=10000 and pago.amount<20000 }">
								<td class="text-secondary">${pago.amount }</td>
							</c:when>
							<c:when test="${pago.amount>=20000 and pago.amount<30000 }">
								<td class="text-warning">${pago.amount }</td>
							</c:when>
							<c:otherwise>
								<td class="text-danger">${pago.amount }</td>
							</c:otherwise>
						
						</c:choose>
					
						<%
						for (Payments c:(ArrayList<Payments>)request.getAttribute("payments")) {
						%>
							<tr>
								<%-- <td><a href="ClientInfo?customerId=<%= c.getCustomerNumber() %>"><%= c.getCheckNumber() %></a></td> --%>
								<td><%= c.getCustomerNumber() %></td>
								<td><%= c.getCheckNumber() %></td>
								<td><%= c.getPaymentDate() %></td>
								<td><%= c.getAmount() %></td>
								<td><a href="/Remove?customerNumber=${pago.customerNumber}&checkNumber=${pago.checkNumber}" style="margin-right:15px; margin-left:40px"><i class="bi bi-trash-fill"></i></a>
									<a href="/Update?customerNumber=${pago.customerNumber}&checkNumber=${pago.checkNumber}"><i class="bi bi-pencil-fill"></i></a></td>
							<tr>								
						<% } %>
					</tbody> 
					
				</table>
			</div>
		</div>
	</div>
</body>
</html>