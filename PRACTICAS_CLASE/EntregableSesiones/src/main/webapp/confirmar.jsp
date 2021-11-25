<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmación de Reserva</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
	
	<%-- <jsp:useBean id="reserva" scope="session" class="org.alixar.servidor.cnbm.model.Reserva"/> --%>
	
	<jsp:include page="barra.jsp"></jsp:include>
	
	<div class="container">
		<div class="row mt-5 justify-content-center">
			<h1 style="color:navy; text-align: center;">RESERVA CONFIRMADA</h1>
			<div class="col-4 fs-2">
				<p><span class="fw-bold">FECHA DE INICIO:</span>
				
				<%-- <jsp:getProperty property="reservar" name="fechaInicio"/> --%>
				
				<%= ((String)session.getAttribute("fechaInicio")) %></p>
				<p><span class="fw-bold">FECHA FINALIZACIÓN:</span>
				
				<%-- <jsp:getProperty property="reserva" name="fechaFin"/> --%>
				
				<%= ((String)session.getAttribute("fechaFin")) %></p>
				<p><span class="fw-bold">NÚMERO DE PERSONAS:</span>
				
				<%-- <jsp:getProperty property="reserva" name="numPersonas"/> --%>
				
				<%= ((String)session.getAttribute("numPersonas")) %></p>
				<h4>SERVICIOS RESERVADOS</h4>
				<ul>

					<%
					String[] servicios = (String[]) session.getAttribute("checkbox");

					if (servicios.length == 0) {
					%>

					<li>No hay servicios seleccionados</li>l
					<%
					} else {
					%>
						<% for (int i=0;i<servicios.length;i++) { %>
							<li><%= servicios[i] %></li>
						<% } %>
					<%
					}
					%>
					
				</ul>
			</div>
		</div>
	</div>

</body>
</html>