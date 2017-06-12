<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import = "negocio.Funciones" %>
<%@page import = "datos.Comanda" %>
<%@page import = "datos.ComandaItem" %>
<%@page import = "datos.Producto" %>
<%@ page import = "java.util.List" %>

		<p>AÑADIDA CON EXITO</p>
		<%Comanda comanda = (Comanda)request.getAttribute("comanda");  %>
		<p>COMANDA NRO: <%= comanda.getIdComanda() %></p>
	<BR >