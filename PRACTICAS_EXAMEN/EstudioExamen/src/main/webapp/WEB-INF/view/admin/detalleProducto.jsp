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
<title>DETALLE PRODUCTO</title>
</head>
<body>

	<jsp:include page="../include/barra.jsp" />
	<div class="container">

		<div class="row justify-content-center">
			<div class="col-12">
				<h2 class="text-center p-3">
				<b onmouseover="this.style.color='yellowgreen';" onmouseout="this.style.color='navy';" 
					style="color: navy">${ productos.productName }</b></h2>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Nº Pedidos</th>
							<th>Nº Productos en 1 Venta</th>
							<th>Nº Ventas</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${ detailsOrderNumber }</td>
							<td>${ detailsNumProductosVentas }</td>
							<td>${ detailsNumVentasPrecio }
							<b onmouseover="this.style.color='navy';" onmouseout="this.style.color='yellowgreen';" 
								style="color: yellowgreen">$</b></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>