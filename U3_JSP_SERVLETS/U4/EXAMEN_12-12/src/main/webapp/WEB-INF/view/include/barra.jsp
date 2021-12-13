<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${ sessionScope.usuario!=null }">

	<nav class="navbar navbar-expand-lg navbar-light w-100" style="background-color: blue">
	  <div class="container-fluid">
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarText">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item d-flex">
	        	<c:if test="${role=='usuario'}">
	          		<a class="nav-link text-white" href="${pageContext.request.contextPath}/Home">Inicio</a>
	          		<p class="text-white">ZONA DE <c:out value="${ sessionScope.usuario }"/></p>
	          	</c:if>
	          	<c:if test="${role=='admin'}">
	          		<li class="nav-item">
	          			<a class="nav-link text-white" href="${pageContext.request.contextPath}/Home">Inicio</a>
	          		 </li>
	          		 <li class="nav-item">
			          	<a class="nav-link text-white" href="${pageContext.request.contextPath}/Admin/Empleados">MostrarEmpleados</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link text-white" href="${pageContext.request.contextPath}/Admin/AddEmpleado">Añadir Empleado</a>
			        </li>
			        <p class="text-white">ZONA DE <c:out value="${ sessionScope.usuario }"/></p>
	          	</c:if>
	        </li>
	      </ul>
	      <span class="navbar-text d-flex">
	      	<!-- <b class="p-2 d-flex text-white"><i class="bi bi-person-circle"></i><c:out value="${ sessionScope.usuario }"/></b> -->
			<a class="text-white btn-danger p-2 mr-5" href="${pageContext.request.contextPath}/LogOutServlet"><i class="bi bi-box-arrow-left"></i></a>
	      </span>
	    </div>
	  </div>
	</nav>
	
</c:if>
