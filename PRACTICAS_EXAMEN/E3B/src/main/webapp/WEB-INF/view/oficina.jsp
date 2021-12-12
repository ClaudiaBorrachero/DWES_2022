<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Oficinas</title>
</head>
<jsp:include page="include/bootstrap.jsp"/>
<body>

	<jsp:include page="include/barra.jsp"/>
	<div class="container mt-5">
		
		<div class="row justify-content-center mt-5">
		
			<div class="col-6">
				<form method="post" class="p-2">
					<select name="oficinas" id="oficinas" required>
						<option value="San Francisco">San Francisco</option>
						<option value="Boston">Boston</option>
						<option value="NYC">NYC</option>
						<option value="Paris">Paris</option>
						<option value="Tokyo">Tokyo</option>
						<option value="Sydney">Sydney</option>
						<option value="London">London</option>
					</select>
					<br><br>
					<input type="submit" class="btn btn-primary" value="OBTENER DATOS">
				</form>
			</div>
			
			<div class="col-6">
				
				<h3>DATOS DE LA OFICINA DE ${oficinas.city}</h3>
				<h3>${ oficinas.officeCode }</h3>
				<h3>${ oficinas.phone }</h3>
				<h3>${ oficinas.addressLine1 }</h3>
				<h3>${ oficinas.addressLine2 }</h3>
				<h3>${ oficinas.state }</h3>
				<h3>${ oficinas.country }</h3>
				<h3>${ oficinas.postalCode }</h3>
				<h3>${ oficinas.territory }</h3>
			
			</div>
			
		</div>
	</div>

</body>
</html>