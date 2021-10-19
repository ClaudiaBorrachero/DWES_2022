<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio 7</title>
</head>
<body>

<%-- Realiza una aplicación que pinte una pirámide. La altura se pedirá en un  
	 formulario. La pirámide estará hecha de bolitas, ladrillos o cualquier otra
  	 imagen. --%>

<form method="post">
	<label>Altura de la pirámide:</label>
	<input type="number" name="altura">
</form>

<%
	if(request.getMethod().equals("POST")){
		int altura = Integer.parseInt((request.getParameter("altura")));
			for(int i = 1; i <= altura; i++){
				/* for(int b = 1; b <= altura-i; b++){
					out.print(" ");
				} */
				for(int c = 1; c <= (i*2)-1; c++){
					out.print("*");	
				}
				out.println("<br>");
			}
	}
%>

</body>
</html>