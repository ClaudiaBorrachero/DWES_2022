<%@page import="java.util.*"%>

<ul class="nav justify-content-end bg-light">
  <li class="nav-item">
    <a class="nav-link" aria-current="page" href="<%= request.getContextPath() %>"><i class="bi bi-house-fill"></i>Volver</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="<%= request.getContextPath()+"/Logout" %>"><i class="bi bi-x-octagon-fill"></i>Salir</a>
  </li>  
</ul>
<ul class="nav justify-content-end bg-light">
  <li class="nav-item">
    Usuario:  <%= ((String)session.getAttribute("usuario")) %>
  </li>
  <li class="nav-item">
    Sesi?n: <%= new Date(session.getCreationTime()) %>
  </li>  
</ul>
