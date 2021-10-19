<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio 11</title>
</head>
<body>

<%-- Realiza una aplicación que genere 100 números aleatorios del 1 al 200. 
	 Los  primos deberán aparecer en un color diferente al resto. --%>

<%
	int nums;
	for(int i = 1; i <= 100; i++){
		nums = (int)(Math.random()*(101-1)+1);
		/* out.print(nums + " - "); */
			if(nums%2 == 0){
%>
				<p style="color:red"> <% out.print("- " + nums + " -"); %>  </p>
<%
			}else {
%>
				<p style="color:green"> <% out.print("- " + nums + " -"); %>  </p>
<%
			}
		}
%>

</body>
</html>