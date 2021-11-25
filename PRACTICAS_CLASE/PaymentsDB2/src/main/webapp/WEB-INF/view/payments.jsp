<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="interface" />   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Información de un PAGO Determinado</title>
<jsp:include page="include/bootstrap.jsp" />
<jsp:useBean id="payment" scope="request"
	class="org.alixar.servidor.cnbm.model.Payments" />
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center mt-5">
			<div class="col-5">
				<h1 class="h1">
					Payments:<jsp:getProperty property="paymentsInfo" name="payment" /></h1>
				<ul>
					<li><span class="text-uppercase fw-bold"><fmt:message key="customerNumber" />: </span><jsp:getProperty
							property="customerNumber" name="payment" /></li>
					<li><span class="text-uppercase fw-bold"><fmt:message key="checkNumber" />: </span><jsp:getProperty
							property="checkNumber" name="payment" /></li>
					<li><span class="text-uppercase fw-bold"><fmt:message key="paymentDate" />: </span><jsp:getProperty
							property="paymentDate" name="payment" /></li>
					<li><span class="text-uppercase fw-bold"><fmt:message key="amount" />: </span><jsp:getProperty
							property="amount" name="payment" /></li>				
				</ul>
			</div>
		</div>
	</div>
</body>
</html>