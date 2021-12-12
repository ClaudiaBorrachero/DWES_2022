<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UPDATE PRODUCT</title>
<jsp:include page="../include/bootstrap.jsp"/>
</head>
<body>
<jsp:include page="../include/barra.jsp"/>
	<div class="container">
		
		<div class="row justify-content-center mt-5">
			<div class="col-8">
				<form method="post">
								
					<h2 class="text-center"><b>MODIFICAR DATOS</b></h2>
					<label for="productCode" class="form-label mt-3">Código</label>
    				<input value="${ sessionScope.productCode }" type="text" class="form-control" id="productCode" name="productCode" required disabled>	
    				<label for="productName" class="form-label mt-3">Nombre</label>
    				<input value="${ sessionScope.product.productName }" type="text" class="form-control" id="productName" name="productName" required disabled>
    				<label for="productLine" class="form-label mt-3">Categoría</label>
    				<input value="${ sessionScope.product.productLine }" type="text" class="form-control" id="productLine" name="productLine" required disabled>
    				<%-- <label for="productScale" class="form-label mt-3">Escala</label>
    				<input value="${ product.productScale }" type="text" class="form-control" id="productScale" name="productScale" required disabled>
    				<label for="productVendor" class="form-label mt-3">Vendedor</label>
    				<input value="${ product.productVendor }" type="text" class="form-control" id="productVendor" name="productVendor" required disabled>
    				<label for="productDescription" class="form-label mt-3">Descripción</label>
    				<input value="${ product.productDescription }" type="text" class="form-control" id="productDescription" name="productDescription" required disabled> --%>
    				<label for="quantityInStock" class="form-label mt-3">Stock</label>
    				<input value="${ sessionScope.product.quantityInStock }" type="text" class="form-control" id="quantityInStock" name="quantityInStock" required disabled>
    				<label for="buyPrice" class="form-label mt-3">Precio</label>
    				<input value="${ sessionScope.product.buyPrice }" type="text" class="form-control" id="buyPrice" name="buyPrice" required>
    				<%-- <label for="MSRP" class="form-label mt-3">MSRP</label>
    				<input value="${ product.MSRP }" type="text" class="form-control" id="MSRP" name="MSRP" required disabled> --%>
    				
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="ACTUALIZAR DATOS" />
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>