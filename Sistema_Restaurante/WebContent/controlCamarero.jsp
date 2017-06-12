<%@page language = "java" contentType = "text/html; charset=ISO-8859-1"
pageEncoding = "ISO-8859-1" %>
<%@page import = "datos.Empleado" %>
<! DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd" >
<html >
<head >
	<meta http-equiv = "Content-Type" content = "text/html; charset=ISO-8859-1" >
	<title >Sistema Restaurante </title >
	<%@include file = "/cabecera.jsp" %>
	<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
	<script type="text/javascript" >
	$(document).ready(function () {
		$("#vercomandas").click(function () {
			$.ajax({
				type: "POST",
				data: "",
				url: "vistaComandas",
				async: false
			}).done(function (data) {
				$("#responseComandas").html(data);
			})
		});

		estado=1;                         
	    $("#mostrarOcultarAC").click(function () { 
	       if(estado==0) {
	         $('#vAgregarComanda').slideUp('fast');
	         estado=1;
	      } else {
	         $('#vAgregarComanda').slideDown('fast');
	         estado=0;
	      }
	    });

	    $("#agregarComanda").click(function () {
	    	var habitacion = $('#habitacion').val();
	    	var mesaFinal = $('#mesaFinal').val();
	    	var dni = $('#dni').val();
	    	var idCamarero = $('#idCamarero').val();

			$.ajax({
				type: "POST",
				data: {mesaFinal: mesaFinal, habitacion: habitacion, idCamarero: idCamarero, dni:dni},
				url: "vistaComandaAgregada",
				async: false
			}).done(function (data) {
				$("#responseAgregarComanda").html(data);
			})
		});
});
	function ver(chk) {
		  obj=chk.form;
		  obj.dni.style.visibility = (chk.checked) ? 'hidden': 'visible' ;
		  if (chk.checked) {
			 
		    obj.dni.value='0';
		  }
		  else{
			  obj.dni.value='';  
		  }
		}
	function ver2(chk) {
		  obj=chk.form;
		  obj.habitacion.style.visibility = (chk.checked) ? 'hidden': 'visible' ;
		  if (chk.checked) {
			 
		    obj.habitacion.value='0';
		  }
		  else{
			  obj.habitacion.value='';  
		  }
		}
	function ver3(chk) {
		  obj=chk.form;
		  obj.mesaFinal.style.visibility = (chk.checked) ? 'hidden': 'visible' ;
		  if (chk.checked) {
			 
		    obj.mesaFinal.value='0';
		  }
		  else{
			  obj.mesaFinal.value='';  
		  }
		}
	 
	</script>
</head >
<BODY style='allign:center'>
	
	<h2>Bienvenido al Restaurante</h2>
	
	<%Empleado empleado=(Empleado)request.getAttribute( "empleado" ); %>
	<BR >
		 Bienvenido <%empleado.getTipoEmpleado().getDescripcion(); %>: 
		<%= empleado.getApellido() %>
		<%= empleado.getNombre() %> <BR>
	<BR >
	
	
	<div class="container" >
		<form class="navbar-form navbar-left">	
			<div class="form-group">	
					<INPUT id="vercomandas" type="button" class="btn btn-success" value = "Ver Comandas">
			</div>
		</form >
	</div>	
	
	<div id="responseComandas"></div>

	<div class="container">
		<INPUT id="mostrarOcultarAC" type="button" class="btn btn-success" value = "Agregar Comanda">
			<div style='display:none' id="vAgregarComanda" >
			<FORM  method = "POST">
			<br><br>
				<table border = "1">
					<tr>
						<th > HABITACION </th>
						<td><INPUT id="habitacion" name="habitacion"></td>
						<td><INPUT id="checkBox2" onclick="ver2(this)" type="checkbox" name="checkbox" > No Habitacion </td>
					</tr>
					<tr >
						<th > MESA FINAL </th>
						<td><INPUT id="mesaFinal" name="mesaFinal"></td>
						<td><INPUT id="checkBox3" onclick="ver3(this)" type="checkbox" name="checkbox" > No Mesa </td>
					</tr >
					<tr >
						<th > DNI CLIENTE </th>
						<td><INPUT id="dni" name="dni"></td>
						<td><INPUT id="checkBox1" onclick="ver(this)" type="checkbox" name="checkbox" > No Cliente </td>
					</tr >
					<tr >
						<th > ID CAMARERO </th>
						<td><INPUT id="idCamarero" name="idCamarero" value="<%= empleado.getIdPersona() %>" disabled></td>
					</tr >			
				</table>
				<br>
				<INPUT id="agregarComanda" type = "button" class="btn btn-success" value="Agregar" />
			</FORM>
			</div >
		<div id="responseAgregarComanda"></div>
	</div>	

	<!--
	<div>
		<FORM method = "POST" action = "/Sistema_Restaurante/anularComanda">
					<INPUT type = "submit" value = "Anular Comanda" >
		</FORM >				
	</div>
	 -->
	<A href = "/Sistema_Restaurante/index.jsp" > Inicio </A >
	
</BODY >
</html >