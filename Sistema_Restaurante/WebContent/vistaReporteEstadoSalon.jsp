<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List"%>
<%@ page import = "datos.MesaFinal" %>
<%@ page import = "datos.Comanda" %>
<%@ page import = "datos.ComandaItem" %>
<%@ page import = "datos.Producto" %>
<%@ page import = "negocio.Funciones"%>
<%@ page import = "negocio.MesaFinalABM"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Sistema_Restaurante</title>
	<script type="text/JavaScript" src="js/jquery-3.2.1.js"></script>
	<link rel="stylesheet" href="css/bootstrap.min.css"/>  
	<script type="text/javascript" ></script>
	
</head>

<body>
	
	<div Class = "container"> 
	<%
		MesaFinalABM mesaFinalABM= new MesaFinalABM ();
		List<MesaFinal> lstMesaFinal = (List)request.getAttribute("lstMesaFinal");
		    for(MesaFinal mf : lstMesaFinal) { 
		    	mf = mesaFinalABM.traerMesaFinalyComandas(mf.getIdMesaFinal());
					if(mf.getComandas().size() > 0){		
					%>
					 <div class="panel panel-info">
					      <div class="panel-heading"> <b> Mesas: </b><%= mf.getNombre() %>
					      		&emsp;&emsp; <b>tiempo Inicio:</b> <%= Funciones.traerFecha(mf.getTiempoInicio())  %>
					      		&emsp;&emsp; <b>tiempo Final: </b> <%= Funciones.traerFecha(mf.getTiempoFin())  %>				      
					  	  </div>
					  	  
			 		<table class="table table-striped table-bordered table-condensed " >
						<thead>
					      <tr >
					        <th>Item numero</th>
					        <th>id Producto</th>
					        <th>nombre</th>
					        <th>precio</th>
					        <th>cantidad</th>
					      </tr>
					    </thead>
					    <tbody>
				 		<% int i=1; %>
				 		<% 
				 		for (Comanda c : mf.getComandas()) {
				 			for (ComandaItem ci : c.getComandaItems()) { 
				 		%>
					 	<tr >
					        <td><%= i++ %> </td>
					        <td><%= ci.getProducto().getIdProducto() %></td>
					        <td><%= ci.getProducto().getNombre() %></td>
					        <td><%= ci.getPrecio() %></td>
					        <td><%= ci.getCantidad() %></td>
					    </tr>
		
						 		 <% }%>
						 	<% } 
					 	}%>
					 	</tbody> 	 	  
					</table>
					</div>
					<BR>
						
		  <% }%>
	</div>
</body>
</html>