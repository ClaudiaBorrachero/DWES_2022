<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Lista de Employees</title>
</head>
<body>
<jsp:include page="include/barra.jsp"/>
	<div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-10">
				<h1 class="bg-primary text-white text-center mb-5">Lista de Empleados de <b>"${ employees.city }"</b></h1>
				  <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Correo electrónico</th>
                            <th>Ciudad</th>
                            <th>Título</th>
                            <th>Jefe</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${employees.employeesList}" var="e">
                            <tr>
                                <td><p>${e.firstName} ${e.lastName}</p></td>
                                <td>${e.email}</td>
                                <td>${employees.city}</td>
                                <td>${e.jobTitle}</td>
                                <td>${e.reportsTo}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
			</div>
		</div>
	</div>
</body>
</html>