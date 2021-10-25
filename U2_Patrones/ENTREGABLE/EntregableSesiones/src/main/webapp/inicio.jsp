<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
	
	<% if(!session.isNew() && session.getAttribute("LOGEADO")!=null && ((boolean)session.getAttribute("LOGEADO"))){ %>
		
		<jsp:include page="barra.jsp"></jsp:include>
		<img src="https://t2.pb.ltmcdn.com/es/posts/4/5/8/que_significa_sonar_con_la_playa_5854_600.jpg" class="img-fluid p-5">
	
	
	<% }else { %>
			
	<div class="container">
		<h1 style="color:navy">CENTRAL DE VIAJES</h1>
		<div class="row justify-content-center">
			<form method="post">
				<label class="form-label" >Usuario</label>
				<input type="text" class="form-control" name="usuario">
				<label class="form-label" >Password</label>
				<input type="password" class="form-control" name="pass">
				<label class="form-label" >Confirmar Password</label>
				<input type="password" class="form-control" name="passw">
				<label class="form-label" >Email</label>
				<input type="text" class="form-control" name="email">
				<input type="submit" value="REGISTRARSE" class="btn btn-primary w-100 mt-3" name="registrarse">
			</form>
		</div>
	</div>
		
	<% } %>
	
</body>
</html>