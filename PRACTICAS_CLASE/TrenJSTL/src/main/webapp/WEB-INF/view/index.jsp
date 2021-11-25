<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="interface" />  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TREN</title>
</head>

<%-- <jsp:useBean id="tren" scope="request" class="org.alixar.servidor.cnbm.model.Tren"/> --%>

<body>

	<%-- <jsp:getProperty property="maquinista.nombre" name="tren"/> --%>
	
	<c:if test="${tren.maquinista.nombre eq 'Pepe'}">
		<p style="color:red"><c:out value = "${tren.maquinista.nombre}"/></p>
	</c:if>
	
	<p>	${tren.maquinista.nombre} </p>
	<p>	${tren.maquinista.apellidos} </p>
	<p>	${tren["maquinista"]["nombre"]} </p>
	<p>	${tren.vagones[0].longitud} </p>
	<p>	${tren.vagones["1"].longitud} </p>

	<ul>
		<c:forEach items="${tren.vagones}" var="item">
			<li>
				<c:out value="Longitud:${item.longitud} Capacidad:${item.capacidad}"/>
				<%-- Longitud:${item.longitud} Capacidad:${item.capacidad} --%>
			</li>
		</c:forEach>
	</ul>

</body>
</html>