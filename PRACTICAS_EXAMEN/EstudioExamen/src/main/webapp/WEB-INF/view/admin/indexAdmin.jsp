<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PANEL DE CONTROL ADMIN</title>
<jsp:include page="../include/bootstrap.jsp"/>
</head>
<body>
	<jsp:include page="../include/barra.jsp"/>
	
	<h2 class="text-center" style="color: navy"><b>PANEL DE CONTROL DE ADMIN</b></h2>
	
	<div class="row justify-content-center mt-4 text-center">
		<div class="col-4 p-3">
			<a href="PaymentsServlet" class="btn btn-primary">Payments</a>			
		</div>
		<div class="col-4 p-3">
			<a href="CustomersServlet" class="btn btn-primary">Customers</a>			
		</div>
		<div class="col-4 p-3">
			<a href="EmployeesServlet" class="btn btn-primary">Employees</a>			
		</div>
		<div class="col-4 p-3">
			<a href="OfficesServlet" class="btn btn-primary">Offices</a>			
		</div>
		<div class="col-4 p-3">
			<a href="ProductsServlet" class="btn btn-primary">Products</a>			
		</div>
		<div class="col-4 p-3">
			<a href="UsuariosServlet" class="btn btn-primary">Usuarios</a>			
		</div>
		<div class="col-4 p-3">
			<a href="OrdersServlet" class="btn btn-primary">Orders</a>			
		</div>
	</div>
	
</body>
</html>