<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" /> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="include/bootstrap.jsp"/>
<jsp:include page="include/barra.jsp"/>
<body>

	<div class="m-5">
		<a href="SearchProductServlet" class="btn btn-primary">Volver</a>
	</div>

	<div class="row justify-content-center mt-4">
		<div class="col-10">
			<table class="table table-striped">
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
					<c:forEach items="${producto}" var="productos">
						<tr>
							<td>${productos.productCode}</td>
							<td>${productos.productName}</td>
							<td>${productos.productLine}</td>
							<td>${productos.productScale}</td>
							<td>${productos.productVendor}</td>
							<td>${productos.productDescription}</td>
							<td>${productos.quantityInStock}</td>	
							<td>${productos.buyPrice}$</td>
							<td>${productos.MSRP}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>