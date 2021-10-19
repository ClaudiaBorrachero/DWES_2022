<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio 15</title>
</head>
<body>

<%-- Crea el juego “Apuesta y gana”. El usuario debe introducir inicialmente una 
	 cantidad de  dinero. A continuación aparecerá por pantalla una imagen de forma 
	 aleatoria. Si sale una calavera, el usuario pierde todo su dinero y termina el 
	 juego. Si sale medio limón, el usuario  pierde la mitad del dinero y puede 
	 seguir jugando con esa cantidad o puede dejar de jugar. Si sale el gato chino 
	 de la suerte, el usuario multiplica por dos su dinero y puede seguir  jugando 
	 con esa cantidad o puede dejar de jugar. --%>

	<form method="post">
		<h1>Apuesta y gana</h1>
		<label>Introduce una cantidad de dinero: </label>
		<input type="number" step="any">
		<input type="submit" value="Aceptar">
	</form>

<%
	if(request.getMethod().equals("POST")){
		
	}
%>

</body>
</html>