<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio 6</title>
</head>
<body>

<%-- Realiza una aplicación que pida un número y que luego muestre la tabla de  
	 multiplicar de ese número. El resultado se debe mostrar en una tabla
     (<table> en HTML). --%>
     
     <form method="post">
     	<label>Inserta un número: </label>
     	<input type="number" placeholder="10" name="num" required>
     </form>

<%
	if(request.getMethod().equals("POST")){
		int num = Integer.parseInt(request.getParameter("num"));
%>
	<table>
		<tr>
			<td>0</td>
			<td>x</td>
			<td> <% out.println(num); %> </td>
			<td>=</td>
			<td> <% out.println(num*0); %> </td>
		</tr>
		<tr>
			<td>1</td>
			<td>x</td>
			<td> <% out.println(num); %> </td>
			<td>=</td>
			<td> <% out.println(num*1); %> </td>
		</tr>
		<tr>
			<td>2</td>
			<td>x</td>
			<td> <% out.println(num); %> </td>
			<td>=</td>
			<td> <% out.println(num*2); %> </td>
		</tr>
		<tr>
			<td>3</td>
			<td>x</td>
			<td> <% out.println(num); %> </td>
			<td>=</td>
			<td> <% out.println(num*3); %> </td>
		</tr>
		<tr>
			<td>4</td>
			<td>x</td>
			<td> <% out.println(num); %> </td>
			<td>=</td>
			<td> <% out.println(num*4); %> </td>
		</tr>
		<tr>
			<td>5</td>
			<td>x</td>
			<td> <% out.println(num); %> </td>
			<td>=</td>
			<td> <% out.println(num*5); %> </td>
		</tr>
		<tr>
			<td>6</td>
			<td>x</td>
			<td> <% out.println(num); %> </td>
			<td>=</td>
			<td> <% out.println(num*6); %> </td>
		</tr>
		<tr>
			<td>7</td>
			<td>x</td>
			<td> <% out.println(num); %> </td>
			<td>=</td>
			<td> <% out.println(num*7); %> </td>
		</tr>
		<tr>
			<td>8</td>
			<td>x</td>
			<td> <% out.println(num); %> </td>
			<td>=</td>
			<td> <% out.println(num*8); %> </td>
		</tr>
		<tr>
			<td>9</td>
			<td>x</td>
			<td> <% out.println(num); %> </td>
			<td>=</td>
			<td> <% out.println(num*9); %> </td>
		</tr>
		<tr>
			<td>10</td>
			<td>x</td>
			<td> <% out.println(num); %> </td>
			<td>=</td>
			<td> <% out.println(num*10); %> </td>
		</tr>
	</table>
<%
	}
%>

</body>
</html>