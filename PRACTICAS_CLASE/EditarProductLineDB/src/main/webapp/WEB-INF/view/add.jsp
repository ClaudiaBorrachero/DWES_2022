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
<title>AÑADIR UN PRODUCTO</title>
</head>
<body>
	
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-6 mt-5">
				<h3 class="row justify-content-center">AÑADIR UN PRODUCTO</h3>
				<form method="post">
					<label for="producto" class="form-label">productLine</label>
    				<input name="producto" type="text" class="form-control" id="producto" required>
	    				<c:if test="${requestScope.error != null}">
	    					<p><small class="text-danger">Categoría ya existente</small></p>
	   					</c:if>
    				<label for="textDescription" class="form-label mt-3">textDescription</label>
    				<textarea id="textDescription" name="textDescription" class="form-control" required>
    					<c:if test="${requestScope.error != null}">
    						<c:out value="${requestScope.textDescription}"></c:out>
    					</c:if>
    				</textarea>
    				
    				<%-- <input name="textDescription" value="${pago.textDescription}" type="text" class="form-control" id="textDescription"> --%>
    				
    				<label for="htmlDescription" class="form-label mt-3">htmlDescription</label>
    				<textarea id="htmlDescription" name="htmlDescription" class="form-control" required>
    					<c:if test="${requestScope.error != null}">
    						<c:out value="${requestScope.htmlDescription}"></c:out>
    					</c:if>
    				</textarea>
    				<%-- <input name="htmlDescription" value="${producto.htmlDescription}" type="text" class="form-control" id="htmlDescription"> --%>
    				<input type="submit" value="Insertar" class="btn btn-primary w-100 mt-5">
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>