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
		var veces=0;
		$("button").click(function()
				   {
				    // añadir nueva fila usando la funcion addTableRow
				    addTableRow($("table"));
				    // prevenir que el boton redireccione a una nueva pagina
				    return false;
				   });
				  
				   // funcion que añade una nueva fila a la tabla clonando la ultima fila e 
				   // incrementando los nombres y los ids en 1 para hacerlos unicos en el documento
				   function addTableRow(table)
				   {
				    // clonar la ultima fila de la tabla
				    var $tr = $(table).find("tbody tr:last").clone();
				    // obtener el atributo name para los inputs y selects
				 	$tr.find("input:text").val("");
				    $tr.find("input,select").attr("name", function()
				    {
				     //  separar el campo name y su numero en dos partes
				     var parts = this.id.match(/(\D+)(\d+)$/);
				     // crear un nombre nuevo para el nuevo campo incrementando el numero para los previos campos en 1
				     return parts[1] + ++parts[2];
				    // repetir los atributos ids
				    }).attr("id", function(){
				     var parts = this.id.match(/(\D+)(\d+)$/);
				     return parts[1] + ++parts[2];
				    });
				    // añadir la nueva fila a la tabla
				    $(table).find("tbody tr:last").after($tr);
					veces=veces+1
				};
				
				$(document).on("click",".eliminar",function(){
					var parent = $(this).parents().get(0);
					if(veces>0){
						$(parent).remove();
						veces=veces-1;
					}
				});
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
					<tbody>
					<tr>
					  	<th> HABITACION </th>
						<td><INPUT id="habitacion" name="habitacion"></td>
						<td><INPUT id="checkBox2" onclick="ver2(this)" type="checkbox" name="checkbox" > No Habitacion </td>
					</tr>
					<tr >
						<th> MESA FINAL </th>
						<td><INPUT id="mesaFinal" name="mesaFinal"></td>
						<td><INPUT id="checkBox3" onclick="ver3(this)" type="checkbox" name="checkbox" > No Mesa </td>
					</tr >
					<tr >
						 <th> DNI CLIENTE </th>
						<td><INPUT id="dni" name="dni"></td>
						<td><INPUT id="checkBox1" onclick="ver(this)" type="checkbox" name="checkbox" > No Cliente </td>
					</tr >
					<tr >
						<th> ID CAMARERO </th>
						<td><INPUT id="idCamarero" name="idCamarero" value="<%= empleado.getIdPersona() %>" disabled></td>
					</tr >	
					<tr>
						<th > PRODUCTO </th>
						<th > CANTIDAD </th>
					</tr>
					<tr>
						<td>
							<select name="select1"  id="select1">
								<option value="0">Seleccione un producto</option>
								<%List<Producto> lista =(List<Producto>)request.getAttribute("productos");
								//ORDENAR LISTA.
									for(Producto p: lista){%>
									<option value="<%=p.getIdProducto()%>"><%= p.getNombre() %></option>
								<% } %>
							</select>
						</td>
						<td>
							<INPUT id="cantidad1" name="cantidad1">
						</td>
						
						<td align="center" class="eliminar">Eliminar</td>
						
						
					</tr>
				</tbody>	
				
				</table>
				<button>Agregar Fila</button>
					

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