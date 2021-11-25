<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<title>Confirmar</title>
</head>
<body>

	<div class="d-flex justify-content-end" style="background-color:#F1BFFF">
		
		<a href="Logout" style="padding:15px" class="btn btn-dark">Logout</a>
		
	</div>

	<div style="padding:15px">
	
	<%
	Cookie[] cookies = null;
	cookies = request.getCookies();
	
	if(cookies!=null) {
	    for (Cookie cookie : cookies) {
	      if(cookie.getName().equals("Curso")) {
	        out.println("La cookie ha guardado " + cookie.getValue());
	      }
	    }
	  }
	
	%>
	
		<br><br>
		<h4>Nombre: <%= request.getParameter("nombre") %></h4><br>
		<h4>Apellido: <%= request.getParameter("apellido") %></h4><br>
		<h4>Correo: <%= request.getParameter("correo") %></h4><br>
		<h4>Radios: <%= request.getParameter("radio") %></h4><br>
		<h4>Selecciona: <%= request.getParameter("select") %></h4>
		
	</div>

</body>
</html>