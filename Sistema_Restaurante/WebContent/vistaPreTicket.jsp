<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "datos.MesaFinal" %>
     <%@page import = "datos.Ticket" %>
      <%@page import = "datos.Comanda" %>
       <%@page import = "datos.ComandaItem" %>
        <%@page import = "datos.Producto" %>
        <%@ page import = "java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Sistema Restaurante</title>
</head>
<body>
	
	<%@include file = "/cabecera.jsp" %>
	<% Ticket ticket = (Ticket)request.getAttribute("ticket"); %>
	<% MesaFinal mesaFinal = (MesaFinal)request.getAttribute("mesaFinal"); %>
	<BR>
		
	<BR>
	<BR>Vista Preticket<BR>
	<BR >
		<table border = "1" >
			<tr >
				<th > producto </th>
				<th > precio </th >
				<th > cantidad </th >
				<th > total </th>
			</tr >		
			<% for (Comanda c : mesaFinal.getComandas()){ %>
				<% for(ComandaItem ci : c.getComandaItems()) {%>
					<tr>
						<td > <%= ci.getProducto().getNombre() %></td>
						<td >$ <%= ci.getPrecio()  %> </td >
						<td > <%= ci.getCantidad() %> </td >
						<td >$ <%= ci.getPrecio()* ci.getCantidad() %> </td >
					</tr>
				<% } %>
			<% } %>
			 <tr><td> precio Total: </td> <td>  </td> <td> </td> <td> $ <%= ticket.getPrecioTotal() %> </td></tr>   
			</table >
	<BR >
</body>
</html>