<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" />  

<nav class="navbar navbar-light bg-dark" style="box-shadow: 0px 10px 5px red">
	  <div class="container-fluid row">
	    <!-- <a class="navbar-brand text-white">BUSCADOR DE PRODUCTOS</a> -->
	    <div class="d-flex col-8">
	    	<a class="text-white btn-danger p-3" href="${pageContext.request.contextPath}/LogOut"><i class="bi bi-box-arrow-left"></i></a>
	    	<a href="DatosUsuario" class="d-flex text-white justify-content-start ml-3 mt-3"><i class="bi bi-person-circle"></i><c:out value="${ sessionScope.usuario }"/></a>
	    </div>
	    <div class="col-4">
		    <form class="d-flex" method="post">
		      <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="buscaProducto" id="buscaProducto">
		      <input class="btn btn-danger" type="submit" value="Search" name="search"/>
		    </form>		    
	    </div>
	  </div>	  
</nav>