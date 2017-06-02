<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "datos.Mesa" %>
<%@page import = "negocio.MesaABM" %>
<%@page import = "java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<h2 align= "center"> Layout </h2>
	<div class = "jumbotron" >
		<table border = "0" width="400" align ="center" >
			
			<% 
		 	//List<Mesa> mesas = (List)request.getAttribute("mesas");
			MesaABM abm = new MesaABM();
			List<Mesa> mesas = abm.traerMesa();
			int salto=0;
			for (Mesa m : mesas){
			%>	
					
					<th>
					N° <%= m.getNumero() %> <br>
					<img src="/Sistema_Restaurante/images/<%= m.getEstado()%>.png" width= "40" height = "85"><br>
					<br>
					</th>
					
					
			<%
				salto++;
				if(salto == 4){ 
					%>
					<tr>		
					<%	
					salto=0;
				}
			}
			%>
		</table>
	</div>
</body>
</html>