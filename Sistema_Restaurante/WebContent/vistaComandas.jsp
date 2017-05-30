<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import = "negocio.Funciones" %>
<%@page import = "datos.Comanda" %>
<%@page import = "datos.ComandaItem" %>
<%@page import = "datos.Producto" %>
<%@ page import = "java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Sistema Restaurante</title>
	<%@include file = "/cabecera.jsp" %>
</head>
<body>
	<% List <Comanda> comandas = (List)request.getAttribute("comandas"); %>
	<BR>
	<BR>
	<BR>Vista Comandas<BR>
	<BR >
		<table border = "1" >
			<tr >
				<th > Comanda ID </th>
				<th > Fecha Creacion </th >
				<th > ITEMS </th >
			</tr >		
			<% for(Comanda c : comandas) {%>
					<tr>
						<td align="center"> <%= c.getIdComanda() %></td>
						<td align="center"> <%= Funciones.traerFechaCorta(c.getFechaCreacion()) %> </td >
						<td >
						<table border ="1">
							<tr >
								<th > Producto </th>
								<th > Cantidad </th >
								
							</tr >	
							<% for(ComandaItem ci : c.getComandaItems()) {%>
								<tr >
								<td align="center"> <%=  ci.getProducto().getNombre() %> </td> 
								<td align="center"> <%=  ci.getCantidad() %> </td> 
								
								</tr> 
						<% } %></table></td >
						
					</tr>
				<% } %>
			</table >
	<BR >
</body>
</html>