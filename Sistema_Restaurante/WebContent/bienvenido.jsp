<%@ page language = "java" contentType = "text/html; charset=ISO-8859-1"
pageEncoding = "ISO-8859-1" %>
<%@ page import = "datos.Empleado" %>
<! DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd" >
<html >
<head >
<meta http-equiv = "Content-Type" content = "text/html; charset=ISO-8859-1" >
<title >Sistema_Restaurante</title >
</head >
<BODY >
<%@ include file = "/cabecera.jsp" %>
<% Empleado empleado=(Empleado)request.getAttribute( "empleado" ); %>
<BR >

Bienvenido se�or: <%= empleado.getNombreUsuario() %> <BR >

<BR >
<A href = "/Sistema_Restaurante.v.4/index.jsp" > Volver... </A >
</BODY >
</html >
