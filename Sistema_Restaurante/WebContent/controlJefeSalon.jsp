
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "datos.Empleado" %>
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
				console.log("unir");
				var mesa1 = $("#mesa1").val();
				var mesa2 = $("#mesa2").val();
				$.ajax({	
					type: "POST",
					url: "controlJefeSalon", 
					data: { mesa1: mesa1, mesa2:mesa2 },
					async: false 
				}).done(function (data) {
					$("#actualizar").html(data);
				})
			});
			
			$("#cargar").click(function () {
				console.log("cargar");
				$.ajax({	
					type: "POST",
					url: "layoutMesas", 
					data: "",
					async: false 
				}).done(function (data) {
					$("#actualizar").html(data);
				})
			});
			
		})
	</script> 
</head>
<body>	
	<%@include file = "/cabecera.jsp" %> 
	
	<%-- 
	<%@include file = "/layoutMesas.jsp" %>
	<jsp:include page="url" flush="true|false" />.
	<jsp:include page="/layoutMesas" flush="true" />
	--%>
	<%Empleado empleado=(Empleado)request.getAttribute( "empleado" ); %>
	
	<br>
	<h1 >
		Bienvenido Jefe de Salon: <BR>
		<%= empleado.getApellido() %>
		<%= empleado.getNombre() %> <BR>
	<BR >
	</h1>
	<div class="container" >
		<form class="navbar-form navbar-left">
			<div class="form-group">
				<INPUT id= "cargar" type="button" class="btn btn-success" value="cargar Layout" />
			</div>
		</form>
	 </div>
	  
	<div id="actualizar">
	</div> 
	<BR >
	
	<div class="container" >
	 <BR > <label >Unir Mesas:  </label> <br>
		<form class="navbar-form navbar-left">
			<div class="form-group">
				<label for="mesa1">Mesa:</label>
				<INPUT id="mesa1" name="mesa1" size = "3">		
				<label for="mesa2">Mesa:</label >
				<INPUT id="mesa2" name="mesa2" size = "3">
				<INPUT id="unir" type="button" class="btn btn-success" value="unir" />
			</div>
		</form>
	  </div>
	
</body>
</html>

