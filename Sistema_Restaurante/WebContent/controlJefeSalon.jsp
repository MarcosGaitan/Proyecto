
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "datos.Empleado" %>
<%@ page import= "negocio.MesaABM" %>
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
			function cargarLayout(){
				
				$.ajax({	
					type: "POST",
					url: "layoutMesas", 
					data: "",
					async: false 
				}).done(function (data) {
					$("#actualizarLayout").html(data);
					
				})
					$.ajax({	
					type: "POST",
					url: "vistaMesasFinales", 
					data: "",
					async: false 
				}).done(function (data) {
					$("#mostrarMesasFinales").html(data);
				})
			};
			window.onload = cargarLayout();
			$("#reporte").click(function () {
				$.ajax({	
					type: "POST",
					url: "vistaReporteEstadoSalon", 
					data: "",
					async: false 
				}).done(function (data) {
					$("#verReporte").html(data);
					
				});
			});
		})
	</script> 
</head>
<body>	
	<%@include file = "/cabecera.jsp" %>
	<div class = "container">
		<nav class = "navbar navbar-right">
			<div><a href = "/Sistema_Restaurante/index.jsp" class="btn btn-primary" href="#" role="button"> Cerrar Sesion</a>	</div>
		</nav>
	</div> 
	<%Empleado empleado=(Empleado)request.getAttribute( "empleado" ); %>
	<br>
	<div class = "container" >
		<h2 >
			Bienvenido Jefe de Salon: <BR>
			<%= empleado.getApellido() %>
			<%= empleado.getNombre() %> <BR>
		<BR >
		</h2>
	</div>
		  
	<div id="actualizarLayout">
	</div> 
	<BR > 
	
	<div id= "mostrarMesasFinales">
	</div>
	<br>
	
	<div class = "container">
		<form class="navbar-form navbar-center">
			<div class="form-group">
				<INPUT id= "reporte" type="button" class="btn btn-info" value="Generar Reporte" title="Generar un reporte de rotacion entre estados libres de Mesas" />
			</div>
		</form>
	</div>
	
	<div id = "verReporte" >
	</div>

</body> 
</html>

