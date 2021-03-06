<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import = "negocio.Funciones" %>
<%@page import = "datos.Comanda" %>
<%@page import = "datos.ComandaItem" %>
<%@page import = "datos.Producto" %>
<%@ page import = "java.util.List" %>

<script type="text/javascript">

function borrar(event, idComanda){
    event.preventDefault(); 
    console.log("HHHH");
    $.ajax({
		type: "POST",
		data: {idComanda: idComanda},
		url: "vistaEliminarComandas",
		async: false
	}).done(function (data) {
		$("#responseComandas").html(data);
		
	})	
}

function ConfirmEliminar(event, idComanda) {
	//Ingresamos un mensaje a mostrar
	var mensaje = confirm("�Desea eliminar la Comanda: "+idComanda+" ?");
	//Detectamos si el usuario acepto el mensaje
	if (mensaje) {
		borrar(event, idComanda)
	}
}
</script>	
	<% List <Comanda> comandas = (List <Comanda>)request.getAttribute("comandas"); %>

	<BR >
		
		<table border = "1" style='position:relative; top:10px; left:20%;'>
			<tr>
				<td align="center" colspan="4"> <b>MOSTRAR COMANDAS</b></td>
			</tr>
			<tr >
				<td align="center"> <b>Comanda ID </b></td>
				<td align="center"><b> Fecha Creacion </b></td >
				<td align="center"><b> Destino </b></td >
				<td align="center"><b> ITEMS </b></td >
			</tr >		
			<% for(Comanda c : comandas) {%>
			
				<% if (c.isAnulada()==false){ %>
				
					<tr>
						
						<td align="center"> <%= c.getIdComanda() %></td>
						<td align="center"> <%= Funciones.traerFechaCorta(c.getFechaCreacion()) %> </td >
						<td align="center"> <% if (c.getMesaFinal()!=null){ %>Mesa: <%=c.getMesaFinal().getNombre() %><% }else{ %>Habitacion: <%= c.getHabitacion() %><%}%> </td >
						
						<td>
						
						<table border ="1">
							<tr >
								<th > Producto </th>
								<th > Cantidad </th >
							</tr >
							
							<%if(c.getComandaItems()!=null){ %>	
								<% for(ComandaItem ci : c.getComandaItems()) {%>
									<tr>
									<td align="center"> <%=  ci.getProducto().getNombre() %> </td> 
									<td align="center"> <%=  ci.getCantidad() %> </td> 
									</tr> 
								<% } %>	
							<% } %>
							
							</table></td >
							
						<td><button class="btn btn-danger" onClick="ConfirmEliminar(event,<%=c.getIdComanda()%>)">ELIMINAR</button></td> 
					</tr>
					<%} %>
				<% } %>
				
			</table >
			
			
			
	<BR >