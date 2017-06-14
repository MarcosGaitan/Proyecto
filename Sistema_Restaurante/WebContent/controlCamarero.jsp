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
				data: {mesaFinal: mesaFinal, habitacion: habitacion, idCamarero: idCamarero, dni:dni, },
				url: "vistaComandaAgregada",
				async: false
			}).done(function (data) {
				$("#responseAgregarComanda").html(data);
			})
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

});
	
	

	
	 
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
	
	<div class="btn-group btn-group-justified">
  		<A id="vercomandas" class="btn btn-primary">Ver Comandas</a>
  		<a id="agregarcomandas"  class="btn btn-primary" >Agregar Comanda</a>
	</div>

	
	<div id="responseComandas"></div>
	<div id="responseAgregarComanda"></div> <!--  Quizas con uno me alcanza -->

	<A href = "/Sistema_Restaurante/index.jsp"><BUTTON>volver</BUTTON> </A>
	
</BODY >
</html >