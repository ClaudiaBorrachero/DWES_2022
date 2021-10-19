<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio 5</title>
</head>
<body>

<%-- Combina las dos aplicaciones anteriores en una sola de tal forma que en la 
	 página principal aparezca en un único formulario y se pueda elegir pasar de 
	 euros a dolares o de dolares a euros según dónde introduzcamos el valor y 
	 el botón que pulsemos. Incluye en la página alguna imagen. --%>
	 
<form method="post">
	<label>Cantidad:</label>
	<input type="number" step="any" name="dinero" id="dinero"><br>
	<input type="submit" value="Euros" name="euros" id="euros">
	<input type="submit" value="Dólares" name="dolares" id="dolares">
</form>

<% 
	if(request.getMethod().equals("POST")){
		
		double cantidad = Double.parseDouble(request.getParameter("dinero"));
		double total;
		
		if(request.getParameter("euros")!=null){
			total = 0.86 * cantidad;
			out.println(cantidad + "$ = " + total + "€");
%>
		<br>
		<img width="300px" height="300px" src="https://upload.wikimedia.org/wikipedia/commons/5/56/Reverso_1_euro.jpg">
<%
		} else{
			total = 1.16 * cantidad;
			out.println(cantidad + "€ = " + total + "$");
%>
			<br>
			<img width="300px" height="300px" src="https://e00-us-marca.uecdn.es/claro/assets/multimedia/imagenes/2020/11/10/16050186706737.jpg">
<%
		}
	}
%>

	<!-- double dolar = 1.16;
	double euro = 1;  -->


	<!-- Enumeration parameters = request.getParameterNames();
	
	while(parameters.hasMoreElements()){
		String nombre = (String) parameters.nextElement();
		out.println("<p>" + request.getParameter(nombre) + "</p>");
	} -->

</body>
</html>