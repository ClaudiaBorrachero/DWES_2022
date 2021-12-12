<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" />  
<jsp:include page="include/bootstrap.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de PRODUCTS</title>
</head>
<body>

	<jsp:include page="include/barra.jsp"/>
	<div class="container mt-5">	
	
		<div class="row justify-content-center">
			<div class="col-12">
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
						</tr>
					</thead>
					<tbody>
						<%-- <c:forEach items="${products}" var="p"> --%>
							<tr>
								<td>${products.productCode}</td>
								<td>${products.productName}</td>
								<td>${products.productLine}</td>
								<td>${products.productScale}</td>
								<td>${products.productVendor}</td>
								<td>${products.productDescription}</td>
								<td>${products.quantityInStock}</td>
								<td>${products.buyPrice}$</td>
								<td>${products.MSRP}</td>
							</tr>
						<%-- </c:forEach>  --%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>