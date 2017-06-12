<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import = "negocio.Funciones" %>
<%@page import = "datos.Comanda" %>
<%@page import = "datos.ComandaItem" %>
<%@page import = "datos.Producto" %>
<%@ page import = "java.util.List" %>

	<% List <Comanda> comandas = (List <Comanda>)request.getAttribute("comandas"); %>
	<BR>Vista Comandas: <BR>
	<BR >
		
		<table border = "1">
			<tr >
				<th > Comanda ID </th>
				<th > Fecha Creacion </th >
				<th > Destino </th >
				<th > ITEMS </th >
			</tr >		
			<% for(Comanda c : comandas) {%>
			
				<% if (c.isAnulada()==false){ %>
					<tr>
						<td align="center"> <%= c.getIdComanda() %></td>
						<td align="center"> <%= Funciones.traerFechaCorta(c.getFechaCreacion()) %> </td >
						<td align="center"> <% if (c.getMesaFinal()!=null){ %>Mesa: <%= c.getMesaFinal().getNombre()  %><% }else{ %>Habitacion: <%= c.getHabitacion() %><%} %> </td >
						
						<td>
						<table border ="1">
							<tr >
								<th > Producto </th>
								<th > Cantidad </th >
							</tr >
							
							<%if(c.getComandaItems()!=null){ %>	
								<% for(ComandaItem ci : c.getComandaItems()) {%>
									<tr >
									<td align="center"> <%=  ci.getProducto().getNombre() %> </td> 
									<td align="center"> <%=  ci.getCantidad() %> </td> 
									
									</tr> 
								<% } %>	
							<% } %>
							</table></td >
						
					</tr>
					<%} %>
				<% } %>
			</table >
	<BR >