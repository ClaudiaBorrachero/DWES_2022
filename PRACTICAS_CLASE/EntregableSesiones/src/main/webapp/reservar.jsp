<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservar</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>

<%-- 	<jsp:useBean id="reserva" scope="session" class="org.alixar.servidor.cnbm.model.Reserva"/>
	<jsp:setProperty name="reserva" property="fechaInicio"/>
	<jsp:setProperty name="reserva" property="fechaFin"/>
	<jsp:setProperty name="reserva" property="numPersonas"/>
	<jsp:setProperty name="reserva" property="servicios"/> --%>

	<jsp:include page="barra.jsp"></jsp:include>
	
	<div class="container">
		<h1 style="color:navy">DATOS DE LA RESERVA</h1>
		<div class="row justify-content-center">
			<form method="post">
				<label class="form-label" >Fecha de inicio</label>
				<input type="date" class="form-control" name="fechaInicio">
				<label class="form-label" >Fecha de Fin</label>
				<input type="date" class="form-control" name="fechaFin">
				<label class="form-label" >Número de personas</label>
				<input type="number" class="form-control" name="numPersonas">
				
				<label class="form-label" ><h3 style="color:navy">SERVICIOS</h3></label>
				<div class="row">
					<div class="col">
						<input type="checkbox" name="checkbox" value="Wifi"> Wifi<br>
						<input type="checkbox" name="checkbox" value="Toallas"> Toallas<br>
						<input type="checkbox" name="checkbox" value="Desayuno"> Desayuno
					</div>
					<div class="col">
						<input type="checkbox" name="checkbox" value="Limpieza"> Limpieza<br>
						<input type="checkbox" name="checkbox" value="Ruta guiada"> Ruta guiada<br>
						<input type="checkbox" name="checkbox" value="Sauna"> Sauna
					</div>
				</div>
				
				<input type="submit" value="RESERVAR" class="btn btn-primary w-100 mt-3" name="reservar">
			</form>
		</div>
	</div>

</body>
</html>