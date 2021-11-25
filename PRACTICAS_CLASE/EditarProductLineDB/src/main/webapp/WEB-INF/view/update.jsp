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
<title>ACTUALIZAR UN PRODUCTO</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-6 mt-5">
				<h3 class="row justify-content-center">ACTUALIZAR UN PRODUCTO</h3>
				<form method="post">
					<label for="producto" class="form-label">productLine</label>
    				<input name="producto" value="${producto.productLine}" type="text" class="form-control" id="producto">
    				
    				<label for="textDescription" class="form-label">textDescription</label>
    				<input name="textDescription" value="${producto.textDescription}" type="text" class="form-control" id="textDescription">
    				
    				<label for="htmlDescription" class="form-label">htmlDescription</label>
    				<input name="htmlDescription" value="${producto.htmlDescription}" type="text" class="form-control" id="htmlDescription">
    				
    				<input type="submit" value="Actualizar" class="btn btn-primary w-100 mt-5">
				</form>
			</div>
		</div>
	</div>
</body>
</html>