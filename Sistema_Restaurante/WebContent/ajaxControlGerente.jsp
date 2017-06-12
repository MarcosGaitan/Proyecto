<%@page language = "java" contentType = "text/html; charset=ISO-8859-1"
pageEncoding = "ISO-8859-1" %>
<%@page import = "datos.Empleado" %>
<! DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd" >
<html >
<head >
	<meta http-equiv = "Content-Type" content = "text/html; charset=ISO-8859-1" >
	<title >Sistema Restaurante </title >
	<script type="text/JavaScript" src="js/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<link rel="stylesheet" href="css/bootstrap.min.css"/> 
	<script type="text/javascript" >
		$(document).ready(function(){
			function cargarLayout() {
				$.ajax({	
					type: "POST",
					url: "layoutMesas", 
					data: "",
					async: false 
				}).done(function (data) {
					$("#actualizarLayout").html(data);	
				})
			}
			setInterval(cargarLayout,5000);
			
			$("#reporteVentas").click(function () {
				$.ajax({	
					type: "POST",
					url: "vistaHistoricoVentas", 
					data: "",
					async: false 
				}).done(function (data) {
					$("#mostrarReporteVentas").html(data);
					
				});
			});
			
			$("#preticket").click(function () {
				var idMesa=$('#idMesa').val();
				$.ajax({	
					type: "POST",
					url: "vistaPreTicket", 
					data: {idMesa:idMesa},
					async: false 
				}).done(function (data) {
					$("#mostrarPreticket").html(data);
					
				});
			});
		})
	</script>
</head >
<BODY >
	<h2>Bienvenido al Restaurante</h2>
	<%@include file = "/cabecera.jsp" %>
	
	<div id = "actualizarLayout">
	</div>
	
	<%Empleado empleado=(Empleado)request.getAttribute( "empleado" ); %>
	<BR >
		Bienvenido Gerente: 
		<%= empleado.getApellido() %>
		<%= empleado.getNombre() %> <BR>
	<BR >
	
	
	<div class = "container">
		<form class="navbar-form navbar-center">
			<div class="form-group">
				<BR>  Generar PreTicket: <BR>
				<TABLE>
					<tr>
						<td>Escribir id Mesa:</td><td><INPUT id="idMesa" name="idMesa"  maxlength="10" size="10"></td>
						<td></td><td><INPUT id="preticket" type = "button" value = "Generar" ></td></tr>	
					</tr>
				</TABLE>	
			</div>
		</form>
	</div>
	<div id = "mostrarPreticket"></div>
	
	<div class = container>
		<form class="navbar-form navbar-center">
			<div class="form-group">
				<INPUT id= "reporteVentas" type="button" class="btn btn-info" value="Ver Reporte de Ventas"  />
			</div>
		</form>
	</div>
	<div id = "mostrarReporteVentas"></div>
	<A href = "/Sistema_Restaurante/index.jsp" > Volver... </A >
</BODY >
</html >