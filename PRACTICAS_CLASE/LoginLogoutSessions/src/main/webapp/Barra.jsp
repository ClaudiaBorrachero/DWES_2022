<%@ page import="org.alixar.servidor.cnbm.model.Usuarios"%>

<div class="flex flex-end">
	
	<h4> <%= ((Usuarios)session.getAttribute("user")).getNombre() %> </h4>
	<a href="Logout">Logout</a>
	
</div>
