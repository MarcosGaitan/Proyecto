<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "datos.MesaFinal" %>
<%@ page import = "datos.Mesa"%>
<%@ page import = "java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Sistema_Restaurante</title>
	<script type="text/JavaScript" src="js/jquery-3.2.1.js"></script>
	<link rel="stylesheet" href="css/bootstrap.min.css"/>  
	<script type="text/javascript" >
		
		$(document).ready(function(){
			$("#terminar").click(function () {
				
				var id = $("#idTerminar").val();
				console.log("id:" + id );
				var hecho = 0;
				if (id != "" ){	
					hecho = 1;
					$.ajax({	
						type: "POST",
						url: "terminarMesa", 
						data: { id:id },
						async: false 
					}).done(function (data) {
						$("#actualizar").html(data);
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
			
			$("#separar").click(function () {
				
				var id = $("#idSeparar").val();
				var hecho2 = 0;
				if (id != ""){	
					hecho2 = 1;
					$.ajax({	
						type: "POST",
						url: "controlJefeSalon", 
						data: { mesa1: mesa1, mesa2:mesa2 },
						async: false 
					}).done(function (data) {
						$("#actualizar").html(data);
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
		
	
	
</head>
<body>
	<% List<MesaFinal> mesasFinales = (List)request.getAttribute("mesasFinales");  %>
	
	<div class = "container">
	<h3> Mesas Compuestas: </h3> 
	<table border = "1" width = "400" cellspacing="2" >
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
	<% if (!mesasFinales.isEmpty()){ %>
		</div>
			<div class = "container">
			<form class="navbar-form navbar-center">
				<div class="form-group">
				<label for="idMesa">IdMesa:</label>
				<INPUT id="idTerminar" name="idTerminar" placeHolder = "insert id mesa" size = "8">
				</div>
				<INPUT id="terminar" type="button" class="btn btn-success" value= "Terminar" />
			</form>
		</div>
		
		<div class = "container">
			<form class="navbar-form navbar-center">
				<div class="form-group">
				<label for="idMesa">IdMesa:</label>
				<INPUT id="idSeparar" name="idSeparar" placeHolder = "insert id mesa" size = "8">
				</div>
				<INPUT id="separar" type="button" class="btn btn-success" value="Separar" />
			</form>
		</div>
	 <%} %>

</body>
</html>