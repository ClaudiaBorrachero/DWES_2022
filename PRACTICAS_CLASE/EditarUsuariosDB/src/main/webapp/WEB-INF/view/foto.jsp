<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" />      
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGEADO</title>
<jsp:include page="include/bootstrap.jsp"/>
<jsp:include page="barra.jsp"/>
</head>
<body style="background:navy">

	<div class="container mt-3">
	
		<div class="row justify-content-center">
			<div class="w-100 col-12 text-center"><img  class="img-fluid" alt="soy una foto" src="https://www.pngkit.com/png/full/138-1383641_winery-technology-and-winemaking-welcome-banner-background.png"></div>
		</div>
	
		<div class="row justify-content-center" style="box-shadow: 0 0 10px 2px white; border-radius: 15px; background: white">
		
			<div class="col-10">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Correo electrónico</th>
							<th>Rol</th>
							<th>Password</th>
							<th>Acciones </th>
							<th><a href="Registro"><i class="bi bi-plus-circle-dotted"></i></a>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaUsuarios}" var="usuarios">
							<tr>
								<td>${usuarios.nombre}</td>
								<td>${usuarios.email}</td>
								<td>${usuarios.rol}</td>
								<td>${usuarios.password}</td>
								<td><a href="UpdateUser?nombre=${usuarios.nombre}&correo=${usuarios.email}"><i class="bi bi-pencil-fill"></i></a>
									<a href="RemoveUser?nombre=${usuarios.nombre}&correo=${usuarios.email}"><i class="bi bi-trash-fill"></i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>