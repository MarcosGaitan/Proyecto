<%@page language = "java" contentType = "text/html; charset=ISO-8859-1"
pageEncoding = "ISO-8859-1" %>
<%@page import = "datos.Empleado" %>
<! DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd" >
<html >
<head >
<meta http-equiv = "Content-Type" content = "text/html; charset=ISO-8859-1" >
<title >Sistema Restaurante </title >
<%@include file = "/cabecera.jsp" %>
</head >
<BODY >
	
	<h2>Bienvenido al Restaurante</h2>
	
	<%Empleado empleado=(Empleado)request.getAttribute( "empleado" ); %>
	<BR >
		 Bienvenido <%empleado.getTipoEmpleado().getDescripcion(); %>: 
		<%= empleado.getApellido() %>
		<%= empleado.getNombre() %> <BR>
	<BR >
	
	
	<div>
		<FORM method = "POST" action = "/Sistema_Restaurante/vistaComandas">		
					<INPUT type = "submit" value = "Ver Comandas">
		</FORM >
		<FORM method = "POST" >		
					<INPUT type = "submit" value = "Agregar Comanda">
		</FORM >
		<FORM method = "POST" action = "/Sistema_Restaurante/anularComanda">
					<INPUT type = "submit" value = "Anular Comanda" >
		</FORM >				
	</div>
	
	<A href = "/Sistema_Restaurante/index.jsp" > Inicio </A >
	
</BODY >
</html >