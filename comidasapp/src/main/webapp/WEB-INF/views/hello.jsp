<%@ include file="/WEB-INF/views/includes.jsp" %>

<html>
  <head><title>Spring</title></head>
  <body>
    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/> <c:out value="${now}"/></p>
    <a href="<c:url value="listar.htm"/>">Increase Prices</a><br>
    <a href="<c:url value="verCateg.htm"/>">ABM categorias</a><br>
    <a href="<c:url value="verPedidos.htm"/>">Pedidos</a><br>
    <a href="<c:url value="login.htm"/>">Iniciar Sesion</a>
    <br>
  </body>  
</html>