<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/JavaScript" src="js/jquery-3.2.1.js"></script>
	<link rel="stylesheet" href="css/bootstrap.min.css"/> 
	<title>Sistema_Restaurante</title>
	<script type="text/javascript">
	</script>
</head>
<body>
 
	<%  List<String> nombreProductos = (ArrayList<String>)request.getAttribute("nombreProductos");  %>
	<%  List<String> cantidadProducto = (ArrayList<String>)request.getAttribute("cantidadProducto");  %>
	<br>
	<h2>Grafico de Ventas</h2>
	<div id="ventas"></div>
	<script type="text/javascript">
		// Load google charts
		google.charts.load('current', {'packages':['corechart']});
		google.charts.setOnLoadCallback(drawChart);
		
		// Draw the chart and set the chart values
		function drawChart() {
			  var data = google.visualization.arrayToDataTable([
				  ["nombre", "cantidad"],
				  <% for(int i =0; i < nombreProductos.size(); i++) { 
			  			if (i != 0) { %>
			  			,
			  			<%}%>
			  			[" <%=nombreProductos.get(i) %> ", <%=cantidadProducto.get(i) %>]
			  			
			  		
					<% }%>		
				]);
		
		  // Optional; add a title and set the width and height of the chart
		  var options = {'title':'ventas de productos', 'width':550, 'height':400};
		
		  // Display the chart inside the <div> element with id="piechart"
		  var chart = new google.visualization.PieChart(document.getElementById('ventas'));
		  chart.draw(data, options);
		}
	</script>

</body>
</html>