<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INFO-USER</title>
</head>
<jsp:include page="include/bootstrap.jsp"/>
<body>
<jsp:include page="include/barra.jsp"/>
	<div class="container">
	
		<div>
			<a href="SearchProductServlet" class="btn btn-primary">Volver</a>
		</div>
	
		<div class="row justify-content-center mt-3 p-3" style="background-color: #4D4E59; border-radius:15px; box-shadow: 0 0 10px 2px red">
		
			<div class="col-5">
				<img class="img-fluid" src="https://i.pinimg.com/originals/40/c5/3f/40c53ff5a0da610aa4daff660c962961.png">
			</div>
		
			<div class="col-7 mt-3 text-white">
			
				<h2><b>Datos de la cuenta, "${ sessionScope.usuario }"</b></h2>
				<ul class="mt-5">
					<li><h4>Usuario: ${ sessionScope.usuario }</h4></li>
				</ul>
				<ul class="mt-5">
					<li><h4>Email: ${ sessionScope.email }</h4></li>
				</ul>
				
				<%-- <label for="usuario" class="form-label mt-3">Usuario</label>
   				<input value="${ sessionScope.usuario }" type="text" class="form-control" id="usuario" name="usuario" required disabled>	
   				<label for="email" class="form-label mt-3">Email</label>
   				<input value="${ sessionScope.email }" type="email" class="form-control" id="email" name="email" required disabled>
   				<label for="password" class="form-label mt-3">Password</label>
   				<input value="${ sessionScope.password }" type="password" class="form-control" id="password" name="password" required> --%>
    			<!-- <form method="post"> -->
    				<a href="UpdatePassword" class="btn btn-danger w-100 mt-5">MODIFICAR DATOS</a>
					<!-- <input type="submit" class="btn btn-danger w-100 mt-5" value="MODIFICAR DATOS"/>    			 -->
    			<!-- </form> -->
			</div>
			
		</div>
		
		<div class="card card-outline-secondary mt-5">
			<div class="card-header">
				<h3 class="mb-0">Mis pedidos</h3>
			</div>
			<div class="card-body">
				
				
				<table class="table table-striped">
					<thead> 
						<tr>
							<th> ProductCode </th>
							<th> Producto </th>
							<th> Categoria </th>
							<th> Precio </th>
						</tr>
					</thead>
					
					<tbody> 
						<c:forEach items="${requestScope.cesta}" var="cesta">
							<tr>
								<td> ${cesta.productCode} </td>
								<td> ${cesta.productName} </td>
								<td> ${cesta.productLine} </td>
								<td> ${cesta.buyPrice} </td>
							</tr>
						</c:forEach>
					</tbody>
					
				</table>
				
				<%--<p> ${requestScope.cesta.getProductCode()} | ${requestScope.cesta.getProductName()} | ${requestScope.cesta.getBuyPrice()}$</p> 
				 ${requestScope.cesta} --%>
	
			</div>
		</div>
		
	</div>

</body>
</html>