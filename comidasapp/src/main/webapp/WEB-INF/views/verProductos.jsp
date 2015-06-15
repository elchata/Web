<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
  <nav><%@ include file="/WEB-INF/views/menu.jsp" %></nav>
    <h1><fmt:message key="heading"/></h1>
    <h3>Productos de <c:out value="${categoria.nombre}"/> </h3>
    <c:forEach items="${categoria.productos}" var="prod">
    	<c:out value="${prod.nombre}"/> <i>$<c:out value="${prod.precio}"/> <c:out value="${prod.unidad.abreviatura}"/></i> 
 		<c:choose>
	  		<c:when test="${prod.stock > 0 }">
	   			 Quedan en stock: <c:out value="${prod.stock}"/> <c:out value="${prod.unidad.nombre}"/>
	  		</c:when>
	 		<c:when test="${prod.stock == 0 }">
	 		 	No queda en stock
	 		</c:when>
 	   	</c:choose>
 	   	<br>
    </c:forEach>
  </body>
</html>