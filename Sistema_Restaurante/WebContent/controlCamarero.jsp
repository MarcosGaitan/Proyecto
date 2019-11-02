<%@page language = "java" contentType = "text/html; charset=ISO-8859-1"
pageEncoding = "ISO-8859-1" %>
<%@page import = "datos.Empleado" %>
<%@page import = "datos.Producto" %>
<%@page import = "java.util.List"%>
<! DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd" >
<html >
<head >
	<meta http-equiv = "Content-Type" content = "text/html; charset=ISO-8859-1" >
	<title >Sistema Restaurante </title >
	<%@include file = "/cabecera.jsp" %>
	<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
		<style type="text/css">
			#tabla{	border: solid 1px #333;	width: 300px; }
			#tabla tbody tr{ background: #999; }
			.eliminar{ cursor: pointer; color: #000; }
			input[type="text"]{ width: 80px; } /* ancho a los elementos input="text" */
 		</style>
	<script type="text/javascript" >
	$(document).ready(function () {
		//////////////////////////////////
		$("#vercomandas").click(function () {
			$.ajax({
				type: "POST",
				data: "",
				url: "vistaComandas",
				async: false
			}).done(function (data) {
				$("#responseComandas").html(data);
			});
		});

	    $("#agregarcomandas").click(function () {
	    	
	    	$.ajax({
				type: "POST",
				data: "",
				url: "vistaAgregarComanda",
				async: false
			}).done(function (data) {
				$("#responseComandas").html(data);
			});
		});
});
	
	

	
	 
	</script>
</head >
<BODY style='allign:center'>
	<%Empleado empleado=(Empleado)request.getAttribute( "empleado" ); %>
	<h2>Bienvenido al Restaurante: <%= empleado.getApellido() %> <%= empleado.getNombre() %></h2>
		
		 <BR>
	<BR >
	
	<div class="btn-group btn-group-justified">
  		<A id="vercomandas" class="btn btn-primary">Ver Comandas</a>
  		<A id="agregarcomandas"  class="btn btn-primary" >Agregar Comanda</a>
	</div>

	
	<div id="responseComandas"></div>
	<br><br>
	<A href = "/Sistema_Restaurante/index.jsp"><BUTTON>Log Out</BUTTON> </A>
	
</BODY >
</html >