<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" />  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEARCH</title>
</head>

<jsp:include page="include/bootstrap.jsp"/>
<body>
	
	<jsp:include page="include/barra2.jsp"/>
	
	<c:choose>
		<c:when test="${ producto!=null and producto.size()>=1 }">
			<div class="row justify-content-center mt-4">
					<div class="col-10">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<!-- <th>productCode</th> -->
								<th>ProductName</th>
								<!-- <th>productDescription</th> -->
								<th>BuyPrice</th>
								<!-- <th>quantityInStock</th> -->
								<th>Ver+</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${producto}" var="productos">
								<tr>
									<%-- <td>${productos.productCode}</td> --%>
									<td>${productos.productName}</td>
									<%-- <td>${productos.productDescription}</td> --%>
									<td>${productos.buyPrice}$</td>
									<%-- <td>${productos.quantityInStock}</td> --%>		
									<td><a href="ProductsDetails?productName=${ productos.productName }"><i class="bi bi-eye"></i></a></td>	
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		
		<c:when test="${ producto!=null and producto.size()==0 }">
			<p class="text-center">No hay resultados para tu búsqueda</p>
		</c:when>
		
	</c:choose>

</body>
</html>