<div style="box-shadow: 0px 10px 5px white">
	<ul class="nav justify-content-end bg-light" >
	  <li class="nav-item">
	    <a class="nav-link" aria-current="page" href="<%= request.getContextPath() %>"><i class="bi bi-house-fill"></i>Volver</a>
	 </li>
	 <li class="nav-item">
	   <a class="nav-link" href="<%= request.getContextPath()+"/Logout" %>"><i class="bi bi-x-octagon-fill"></i>Salir</a>
	  </li>  
	</ul>
	<% if (!session.isNew() && session.getAttribute("LOGEADO") != null && ((boolean) session.getAttribute("LOGEADO"))) { %>
	<ul class="nav justify-content-end bg-light">
		<li class="nav-item p-1">
	    	 Usuario:  <%= ((String)session.getAttribute("usuario")) %>
	  </li>  
	</ul>
	<% } %>
</div>