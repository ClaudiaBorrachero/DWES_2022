<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
      
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN-INDEX</title>
</head>
<jsp:include page="../include/bootstrap.jsp"/>
<body>

	<jsp:include page="../include/barra.jsp"/>
	<div class="container mt-5">
		
		<div class="row justify-content-center">
			<div class="col-12">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Código</th>
							<th>Nombre</th>
							<th>Categoría</th>
							<th>Escala</th>
							<th>Vendedor</th>
							<th>Descripción</th>
							<th>Stock</th>
							<th>Precio</th>
							<th>MSRP</th>
							<th>Acción</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaProductos}" var="p">
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
								<td><a href="EditarProductoServlet?productCode=${p.productCode}">
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