<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Sistema Restaurante</title>
	<script type="text/JavaScript" src="js/jquery-3.2.1.js"></script>
	<link rel="stylesheet" href="css/bootstrap.min.css"/>  
	<script type="text/javascript" ></script>
</head>
<body>
	<%@ include file = "/cabecera.jsp" %>
	<h2>Bienvenido al Restaurante</h2>
	<div>
		<form class="form-horizontal" method = "POST" action = "/Sistema_Restaurante/Bienvenido">
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">Usuario</label>
		    <div class="col-sm-2">
		      <input  name="usuario" class="form-control" id="inputEmail3" placeholder="Usuario">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
		    <div class="col-sm-2">
		      <input name="pass" type="password" class="form-control" id="inputPassword3" placeholder="Pass">
		    </div>
		  </div>
		 
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default">Consultar</button>
		    </div>
		  </div>
		</form>
		<!-- <FORM method = "POST" action = "/Sistema_Restaurante/Bienvenido" >
		<TABLE>
			<tr>
				<td>Escribir Usuario:</td><td><INPUT name="usuario"></td>
			</tr>
			<tr>
				<td>Escribir Password:</td><td><INPUT name="pass" type="password"></td>
			</tr>
			
			<tr><td></td><td><INPUT type = "submit" value = "Consultar" ></td></tr>
				
		</TABLE>	
		</form> -->
	</div>
</body>
</html>