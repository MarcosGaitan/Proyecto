<%@page language = "java" contentType = "text/html; charset=ISO-8859-1"
pageEncoding = "ISO-8859-1" %>
<%@page import = "datos.Empleado" %>
<! DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd" >
<html >
<head >
<meta http-equiv = "Content-Type" content = "text/html; charset=ISO-8859-1" >
<title >Sistema Restaurante </title >
</head >
<BODY >
	<h2>Bienvenido al Restaurante</h2>
	<%@include file = "/cabecera.jsp" %>
	<%@include file = "/layoutMesas.jsp" %>
	<%Empleado empleado=(Empleado)request.getAttribute( "empleado" ); %>
	<BR >
		Bienvenido Gerente: 
		<%= empleado.getApellido() %>
		<%= empleado.getNombre() %> <BR>
	<BR >
	
	
	<div>
		<FORM method = "POST" action = "/Sistema_Restaurante/vistaPreTicket" >
		<BR>  Generar PreTicket: <BR>
		<TABLE>
			<tr>
				<td>Escribir id Mesa:</td><td><INPUT name="idMesa"  maxlength="10" size="10"></td>
				<td></td><td><INPUT type = "submit" value = "Generar" ></td></tr>	
			</tr>
		</TABLE>	
		</form>
	</div>
	
	
	
	<A href = "/Sistema_Restaurante/index.jsp" > Volver... </A >
	
</BODY >
</html >