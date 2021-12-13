<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADDEMPLOYEE</title>
<jsp:include page="../include/bootstrap.jsp"/>
</head>
<body>
<jsp:include page="../include/barra.jsp"/>
	<div class="container">
		
		<div class="row justify-content-center mt-5">
			<h2 class="text-center"><b>Añadir un empleado</b></h2>
			<div class="col-6">
				<form method="post">
				<label for="employeeNumber" class="form-label mt-3">Número de Empleado</label>
    				<input type="number" class="form-control" id="employeeNumber" name="employeeNumber" required >	
    				<label for="lastName" class="form-label mt-3">Apellidos</label>
    				<input type="text" class="form-control" id="lastName" name="lastName" required >	
					<label for="firstName" class="form-label mt-3">Nombre</label>
    				<input type="text" class="form-control" id="firstName" name="firstName" required >	
					<label for="extension" class="form-label mt-3">Extension</label>
    				<input type="text" class="form-control" id="extension" name="extension" required >
    				<label for="email" class="form-label mt-3">Email</label>
    				<input type="email" class="form-control" id="email" name="email" required >	
    				<label for="jobTitle" class="form-label mt-3">Puesto</label>
    				<input type="text" class="form-control" id="jobTitle" name="jobTitle" required >
    				<label for="officeCode" class="form-label mt-3">Oficina</label><br>
    				<!-- <select id="officeCode" name="officeCode" class="w-100">
    					<option value="San Francisco">San Francisco</option>
						<option value="Boston">Boston</option>
						<option value="NYC">NYC</option>
						<option value="Paris">Paris</option>
						<option value="Tokyo">Tokyo</option>
						<option value="Sydney">Sydney</option>
						<option value="London">London</option>
    				</select><br> -->
    				<input type="text" class="form-control" id="officeCode" name="officeCode" required>
    				<label for="reportsTo" class="form-label mt-3">Jefe</label>
    				<input type="text" class="form-control" id="reportsTo" name="reportsTo" required>
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="AÑADIR EMPLEADO" />
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>