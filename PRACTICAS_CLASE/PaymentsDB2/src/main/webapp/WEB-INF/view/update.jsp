<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UPDATE</title>
</head>
<body>

	<div class="container mt-5">
	
		<div class="row justify-content-center">
		
			<form method="post">
				 <label for="customerNumber" class="form-label">CustomerNumber</label>
			    <input type="text" class="form-control" id="customerNumber" value="${pago.customerNumber}" disabled name="customerNumber"><br>
			    <label for="checkNumber" class="form-label">CheckNumber</label>
			    <input type="text" class="form-control" id="checkNumber" value="${pago.checkNumber}" name="checkNumber"><br>
			    <label for="date" class="form-label">Date</label>
			    <input type="text" class="form-control" id="date" value="${pago.paymentDate}" name="paymentDate"><br>
			    <label for="amount" class="form-label">Amount</label>
			    <input type="text" class="form-control" id="date" value="${pago.amount}" name="amount"><br><br>
			    <input type="submit" value="Actualizar" name="actualizar" class="btn btn-primary w-100">
			</form>
		
		</div>
	
	</div>

</body>
</html>