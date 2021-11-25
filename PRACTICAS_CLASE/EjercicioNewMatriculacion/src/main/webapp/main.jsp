<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>

	<div class="container">
		<div class="row justify-content-center mt-5">
			<% if (!session.isNew() && session.getAttribute("LOGEADO")!=null && ((boolean)session.getAttribute("LOGEADO")) ) { %>

			<!-- ELEMENTOS DE LA PÁGINA QUE SE SACAN SI ESTAMOS LOGEADOS -->
			<div class="col-3">
				<a href="<%= request.getContextPath()+"/Logout" %>">
				<input type="button" class="btn btn-primary w-100" value="SALIR">
				</a>
			</div>

			<% } else { %>

			<!-- ELEMENTOS DE LA PÁGINA QUE SE SACAN SI NO ESTAMOS LOGEADOS -->
			<div class="col-3">
				<form method="post">
					<input name="entrar" type="submit" class="btn btn-primary w-100" value="ENTRAR" />
				</form>
			</div>
			<% } %>
		</div>
	</div>
	</div>
</body>
</html>