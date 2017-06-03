
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
				var mesa1 = $("#mesa1").val();
				var mesa2 = $("#mesa2").val();
				var hecho = 0;
				if (mesa1 != "" && mesa2 != ""){	
					hecho = 1;
					$.ajax({	
						type: "POST",
						url: "controlJefeSalon", 
						data: { mesa1: mesa1, mesa2:mesa2 },
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
			
			$("#cargar").click(function () {
				
				$.ajax({	
					type: "POST",
					url: "layoutMesas", 
					data: "",
					async: false 
				}).done(function (data) {
					$("#actualizar").html(data);
					
				})
					$.ajax({	
					type: "POST",
					url: "vistaMesasFinales", 
					data: "",
					async: false 
				}).done(function (data) {
					$("#mostrarMesasFinales").html(data);
				})
			});
			
			
			
		})
	</script> 
</head>
<body>	
	<%@include file = "/cabecera.jsp" %> 
	<%Empleado empleado=(Empleado)request.getAttribute( "empleado" ); %>
	<%-- 
	<%@include file = "/layoutMesas.jsp" %>
	<jsp:include page="url" flush="true|false" />.
	<jsp:include page="/layoutMesas" flush="true" />
	--%>
	<br>
	<h2 >
		Bienvenido Jefe de Salon: <BR>
		<%= empleado.getApellido() %>
		<%= empleado.getNombre() %> <BR>
	<BR >
	</h2>
	
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
	 <BR > <h3 >Unir Mesas:  </h3> 
		<form class="navbar-form navbar-left">
			<div class="form-group">
				<label for="mesa1">Mesa:</label>
				<INPUT id="mesa1" name="mesa1" size = "3" placeholder = "insert Id">		
				<label for="mesa2">Mesa:</label >
				<INPUT id="mesa2" name="mesa2" size = "3" placeholder = "insert Id">
				<INPUT id="unir" type="button" class="btn btn-success" value="Unir" />
			</div>
		</form>
	  </div>
	  
	  	
	  <div id= "mostrarMesasFinales">
	  </div>
	  <br>
	
</body>
</html>

