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
<title>Lista de PRODUCTS</title>
</head>
<body>

	<jsp:include page="../include/barra.jsp"/>
	<div class="container mt-5">	
	
		<div class="row justify-content-center">
			<div class="col-10">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>ProductCode</th>
							<th>ProductName</th>
							<th>ProductLine</th>
							<th>ProductScale</th>
							<th>ProductVendor</th>
							<th>ProductDescription</th>
							<th>QuantityInStock</th>
							<th>BuyPrice</th>
							<th>MSRP</th>
							<th>Ver+</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${products}" var="p">
							<tr>
								<td>${p.productCode}</td>
								<td>${p.productName}</td>
								<td>${p.productLine}</td>
								<td>${p.productScale}</td>
								<td>${p.productVendor}</td>
								<td>${p.productDescription}</td>
								<td>${p.quantityInStock}</td>
								<td>${p.buyPrice}</td>
								<td>${p.MSRP}</td>
								<td><a href="ProductsDetails?pc=${p.productCode}">
									<i onmouseover="this.style.color='yellowgreen';" onmouseout="this.style.color='navy';" 
									class="bi bi-plus-circle-dotted" style="color:navy"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>