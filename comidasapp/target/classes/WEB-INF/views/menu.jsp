<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div id="accordion" style="margin: 2px">	
		<c:forEach items="${categorias}" var="categoria">	
			
			<c:if test="${empty categoria.padre}">
				<c:url value="/mostrarProducto.htm" var="catURL">
			  	 	<c:param name="idCat" value="${categoria.idCategoria}"/>
				</c:url>			
				<h3><a href="${catURL}"><c:out value="${categoria.nombre}"/></a></h3>
				<div>
					<ul id='panel'>
					<c:forEach items="${categoria.hijos}" var="subCat">
					
					<c:url value="/mostrarProducto.htm" var="catURL2">
					   <c:param name="idCat" value="${subCat.idCategoria}"/>
					</c:url>
						<li><a href="${catURL2}"><c:out value="${subCat.nombre}"/></a></li>
					</c:forEach>
					</ul>
				</div>			
			</c:if>
		</c:forEach>
	</div>