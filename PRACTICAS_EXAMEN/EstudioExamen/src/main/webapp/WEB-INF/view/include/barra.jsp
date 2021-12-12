<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- navbar-light bg-light  -->
<nav class="navbar mb-5 w-100"
	style="box-shadow: 0px 6px 5px yellowgreen; background-color: #F7FFE8">
	<div class="container-fluid row">

		<c:if test="${sessionScope.usuario==null }">
			<a class="p-1 nav-link" href="${pageContext.request.contextPath}/LoginServlet">
				<i onmouseover="this.style.color='yellowgreen';"
				onmouseout="this.style.color='navy';" class="bi bi-house-door-fill"
				style="color: navy"></i>
			</a>
		</c:if>

		<c:if test="${sessionScope.role=='usuario' }">
			<div class="d-flex col-2">
				<a class="p-1 nav-link" href="${pageContext.request.contextPath}/SearchProductServlet">
					<i onmouseover="this.style.color='yellowgreen';"
					onmouseout="this.style.color='navy';" class="bi bi-house-door-fill"
					style="color: navy"></i>
				</a>
			</div>
			<div class="d-flex col-10 justify-content-end">
				<a href="DatosUsuario" class="d-flex justify-content-start ml-3 mt-3">
				<i class="bi bi-person-circle"></i> 
				<c:out value="${ sessionScope.usuario }" /></a>
				<a class="btn-danger p-3" href="${pageContext.request.contextPath}/LogOutServlet">
				<i class="bi bi-box-arrow-left"></i></a> 
			</div>
		</c:if>
			
		<c:if test="${sessionScope.role=='admin' }">
			
			<div class="d-flex col-2 justify-content-start">
				<a class="p-1 nav-link" href="${pageContext.request.contextPath}/AdminMainServlet/">
					<i onmouseover="this.style.color='yellowgreen';"
					onmouseout="this.style.color='navy';" class="bi bi-house-door-fill"
					style="color: navy"></i>
				</a>
			</div>

			<div class="d-flex col-10 justify-content-end">
				<a href="${pageContext.request.contextPath}/AdminMainServlet/" class="d-flex justify-content-start ml-3 mt-3">
				<i class="bi bi-person-circle"></i> 
				<c:out value="${ sessionScope.usuario }" /></a>
				<a class="btn-danger p-3" href="${pageContext.request.contextPath}/LogOutServlet">
				<i class="bi bi-box-arrow-left"></i></a> 
			</div>

		</c:if>
			
	</div>
</nav>