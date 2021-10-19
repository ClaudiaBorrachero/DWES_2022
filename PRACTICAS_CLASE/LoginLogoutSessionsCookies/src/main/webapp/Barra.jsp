<%@ page import="org.alixar.servidor.cnbm.model.Usuarios"%>

<div class="d-flex justify-content-end" style="background-color:#BFFFEC">
	
	<h4 style="padding:15px"> <%= ((Usuarios)session.getAttribute("user")).getNombre() %> </h4>
	<a href="Logout" style="padding:15px" class="btn btn-dark">Logout</a>
	
</div>
