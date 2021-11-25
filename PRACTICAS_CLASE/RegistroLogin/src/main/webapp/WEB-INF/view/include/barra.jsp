<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${ sessionScope.usuario!=null }">
	<div class="nav justify-content-end bg-dark text-white mb-5" style="box-shadow: 0px 10px 5px red">
		<div class="row">
			<div class="d-flex col-10">
				<a href="DatosUsuario" class="p-2 text-white d-flex"><i class="bi bi-person-circle"></i><c:out value="${ sessionScope.usuario }"/></a>
				<a class="text-white btn-danger p-2 mr-5" href="${pageContext.request.contextPath}/LogOut"><i class="bi bi-box-arrow-left"></i></a>
			</div>
		</div>
	</div>	
</c:if>
