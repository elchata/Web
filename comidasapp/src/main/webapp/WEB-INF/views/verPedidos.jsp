<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.proyectos.comidasapp.clases.User"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	HttpSession session = request.getSession();
	User user = (User) session.getAttribute("usuario");
	String sesion = null;
	if (user != null){
		sesion = "Conectado: " + user.getNombre() +" <a href= 'salir.htm'>Salir </a>";
		}
	else sesion = "<a href= 'login.htm'>Iniciar sesion </a>";
	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%= sesion %>
<h2>Pedidos:</h2>
  <c:forEach items="${pedidos}" var="pedido"> 
    <li>Fecha: <c:out value="${pedido.fecha}"/></li>
	Productos incluidos:
	<c:forEach items="${pedido.productos}" var="prod"> 
	<li>Nombre: <c:out value="${prod.producto.nombre}"/></li>
	<li>Precio: <c:out value="${prod.producto.precio}"/> <c:out value="${prod.producto.unidad.abreviatura}"/></li>
	<li>Cantidad: <c:out value="${prod.cantidad}"/></li>
	</c:forEach>
	
    <h4>Precio Final: <c:out value="${pedido.precioFinal}"/></h4>
  </c:forEach> 
</body>
</html>