<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "datos.MesaFinal" %>
<%@ page import = "datos.Mesa"%>
<%@ page import = "java.util.List" %>
<%@ page import = "negocio.MesaABM" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Sistema_Restaurante</title>
	<script type="text/JavaScript" src="js/jquery-3.2.1.js"></script>
	<link rel="stylesheet" href="css/bootstrap.min.css"/>  
	<script type="text/javascript" >
		
		$(document).ready(function(){
			
			$("#unir").click(function () {
				var mesa1 = $("#idMesa1").val();
				var mesa2 = $("#idMesa2").val();
				var hecho = 0;
				console.log(mesa1 + ":" + mesa2);
				if (mesa1 != 0 && mesa2 != 0){	
					hecho = 1;
					$.ajax({	
						type: "POST",
						url: "unirMesas", 
						data: { mesa1: mesa1, mesa2 : mesa2 },
						async: false 
					}).done(function (data) {
						$("#actualizarLayout").html(data);
					})
				}
				if (hecho == 1){
					hecho = 0;
					$.ajax({	
						type: "POST",
						url: "vistaMesasFinales", 
						data: "",
						async: false 
					}).done(function (data) {
						$("#mostrarMesasFinales").html(data);
					})
				}
			});
			
			
			
			$("#terminar").click(function () {
				
				var id = $("#idTerminar").val();
				console.log("id:" + id );
				var hecho1 = 0;
				if (id != 0 ){	
					hecho1 = 1;
					$.ajax({	
						type: "POST",
						url: "terminarMesa", 
						data: { id:id },
						async: false 
					}).done(function (data) {
						$("#actualizarLayout").html(data);
					})
				}
				if (hecho1 == 1){
					hecho1 = 0;
					$.ajax({	
						type: "POST",
						url: "vistaMesasFinales", 
						data: "",
						async: false 
					}).done(function (data) {
						$("#mostrarMesasFinales").html(data);
					})
				}
				
			});
			
			$("#liberar").click(function () {
				console.log("liberando");
				var id = $("#idLiberar").val();
				var hecho2 = 0;
				if (id != 0){	
					hecho2 = 1;
					console.log("liberando 2");
					$.ajax({	
						type: "POST",
						url: "liberarMesa", 
						data: { id : id},
						async: false 
					}).done(function (data) {
						$("#actualizarLayout").html(data);
					})
				}
				if (hecho2 == 1){
					hecho2 = 0;
					$.ajax({	
						type: "POST",
						url: "vistaMesasFinales", 
						data: "",
						async: false 
					}).done(function (data) {
						$("#mostrarMesasFinales").html(data);
					})
				}
				
			});

				
		})
		
	</script> 
	<style type="text/css">
	.ocupada {color:#FF0000;}
	.terminada {color:#0066FF;}
	.libre {color:#009900;}
	</style>	
</head>
<body>
	
	
	<div class="container" >
	<% 
	MesaABM abm= new MesaABM(); 
	List<Mesa> mesas = null;
	%>
	 <br><h3 >Unir Mesas:  </h3> 
		<form class="navbar-form navbar-left">
			
				<label for="idMesa">IdMesa:</label>
				<select class="selectpicker form-control" id="idMesa1" >
					<option value="0">Seleccione una Mesa</option>				
					<%	
					mesas = abm.traerLibresyOcupadas();
					for(Mesa m : mesas){	
					%>
						<option class="<%= m.getEstado()%>" value="<%= m.getIdMesa() %>"><%= m.getNumero() %> </option>
					<% } %>			
				</select>
				
				<label for="idMesa">IdMesa:</label>
				<select class="selectpicker form-control" id="idMesa2" >
					
					<option value="0">Seleccione una Mesa</option>				
					<% mesas = abm.traerLibres(); 
					for(Mesa m : mesas){ %>
					<option class="<%= m.getEstado()%>" value="<%= m.getIdMesa() %>"><%= m.getNumero() %> </option>
					<% } %>			
				</select>
				<INPUT id="unir" type="button" class="btn btn-success" value="Unir" />	
		</form>
	 </div>
	
	<% List<MesaFinal> mesasFinales = (List)request.getAttribute("mesasFinales");  %>
	
	<div class = "container">
	<h3> Mesas Compuestas: <%=mesasFinales.size() %></h3> 
	<table border = "1" class="table table-striped table-bordered table-condensed" >
		<% 
			int salto = 0;
			int i = 0; 
			for (MesaFinal mf : mesasFinales){
				i++;
			%>	
				   <th>
				   Mesa Final: 
				       <br>
				   		<% for (Mesa m : mf.getMesas()){ 
				   		%>
				   			n° <%= m.getNumero() %>, 

				   		<%} %>
				   		<BR> 
				   		
				  	 </th>
				<%
				salto++;
				if(salto == 4){ 
					%>
					<tr>
					</tr>		
					<%	
					salto=0;
				}
			}
		%>
	 </table>
	</div>
	<% if (!mesasFinales.isEmpty()){ %>
		<% MesaABM mAbm = new MesaABM();
		%>
		 <div class = "container">
			<form class="navbar-form navbar-center">
				<label for="idMesa">IdMesa:</label>
				<select class="selectpicker form-control" id="idTerminar" >
					<option value="0">Seleccione una Mesa</option>				
					<%
					mesas = mAbm.traerOcupadas();
					for(Mesa m : mesas){ %>
					<option class="<%= m.getEstado()%>" value="<%= m.getIdMesa() %>"><%= m.getNumero() %> </option>
					<% } %>			
				</select>		
				<INPUT id="terminar" type="button" class="btn btn-success" value= "Terminar" />
			</form>
		</div>
		
		<div class = "container" >
			<form class="navbar-form navbar-center">
				<label for="idMesa">IdMesa:</label>
				<select class="selectpicker form-control" id="idLiberar" >
					<option value="0">Seleccione una Mesa</option>				
					<% 
					mesas = mAbm.traerTerminadas();
					for(Mesa m : mesas){ %>
					<option class="<%= m.getEstado()%>" value="<%= m.getIdMesa() %>"><%= m.getNumero() %> </option>
					<% } %>			
				</select>
				<INPUT id="liberar" type="button" class="btn btn-success" value= "Liberar" />
			</form>
		</div>
	 <%} %>

</body>
</html>