<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema_Restaurante</title>
</head>
<body>
<%@ include file = "/cabecera.jsp" %>
<h2>Bienvenido al Restaurante</h2>
<div>
	<FORM method = "POST" action = "/IniciarSesion/Bienvenido " >
	<TABLE>
		<tr>
			<td>Escribir Usuario:</td><td><INPUT name="usuario"></td>
		</tr>
		<tr>
			<td>Escribir Password:</td><td><INPUT name="pass" type="password"></td>
		</tr>
		
		<tr><td></td><td><INPUT type = "submit" value = "Consultar" ></td></tr>
			
	</TABLE>	
	</form>
</div>
</body>
</html>