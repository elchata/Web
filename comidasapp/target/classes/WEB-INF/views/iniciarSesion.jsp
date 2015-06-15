<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/includes.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h2>Iniciar Sesion</h2>
<c:out value="${mensaje}"/>
	<form action="inicio.htm" method="post">
    <table border="0">
        <tr>
            <td colspan="2" align="center">Login Spring Mvc</td>
        </tr>
        <tr>
            <td>Usuario:</td>
            <td><input type="text" name="usuario"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="submit" value="Enviar">
            </td>
        </tr>
    </table>
    </form>
</body>
</html>