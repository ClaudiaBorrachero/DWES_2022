<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="include/bootstrap.jsp" />
<body>

	<div class="container">
		<jsp:include page="include/barra.jsp" />
		<div class="row justify-content-center">
			<div class="col-10">
				<table>
					<thead>
						<tr>
							<th>Número</th>
							<th>Fecha</th>
							<th>Fecha de envío</th>
							<th>Estado</th>
							<th>/</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ pedidos }" var="p">
							<td>${ p.orderNumber }</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>

</body>
</html>