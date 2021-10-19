<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio 10</title>
</head>
<body>
	
	<%-- Escribe un programa que muestre los n primeros términos de la serie de   
		 Fibonacci. El primer término de la serie de Fibonacci es 0, el segundo es 1  
		 y el resto se calcula sumando los dos anteriores, por lo que tendríamos que   
		 los términos son 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144... El número n  
		 se debe introducir por teclado. --%>
	
	<form method="post">
		<label>Introduce un número: </label>
		<input type="number" name="num">
	</form>
	
	<% 
	if(request.getMethod().equals("POST")){
		int num = Integer.parseInt(request.getParameter("num"));
		long f1=0,f2=1,aux;
		
		switch(num){
		case 1: out.print("0");break;
		case 2: out.print("0 1");break;
		default:
			out.print("0 1");
			while(num>2){
				aux = f1;
				f1 = f2;
				f2 = aux + f2;
				out.print(" "+ f2);
				num--;
			}
		}
	}
	%>
	
</body>
</html>