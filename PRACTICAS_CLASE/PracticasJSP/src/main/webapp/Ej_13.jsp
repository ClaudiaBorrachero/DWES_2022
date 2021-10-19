<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio 13</title>
</head>
<body>

<%-- Realiza un configurador del interior de un vehículo. El usuario puede  
	 elegir, mediante un formulario, el color de la tapicería – blanco, negro
     o berenjena - y el material de las molduras – madera o carbono. Se debe  
     mostrar el interior del coche tal y como lo quiere el usuario. --%>

<form method="post">
	<h1>Configurador del interior del vehículo</h1>
	<label>Color: </label>
	<select name="select1" size="3" multiple>
		<option>Blanco</option>
		<option>Negro</option>
		<option>Berenjena</option>
	</select><br>
	<label>Material de las molduras: </label>
	<select name="select2" size="2" multiple>
		<option>Madera</option>
		<option>Carbono</option>
	</select><br>
	<input type="submit" value="Ver interior">
</form>

<%
	if(request.getMethod().equals("POST")){
		String items[] = request.getParameterValues("select1");
		String items2[] = request.getParameterValues("select2");
		for (int i = 0; i < items.length; i++){
			out.println("<br><h3 style='color:blue'>- El color de tu coche será " + items[i] + "</h3>"); 
		}
		for (int i = 0; i < items2.length; i++){
			out.println("<h3 style='color:brown'>- El material de las molduras seleccionado es " + items2[i] + "</h3>"); 
		}
	}
%>

</body>
</html>