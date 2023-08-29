<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="repository.model.Sales"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
	Map<String, Integer> salesMap = (Map<String, Integer>)request.getAttribute("salesMap");
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Sales Analysis</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		
		<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	    <script type="text/javascript">
	      google.charts.load('current', {'packages':['corechart']});
	      google.charts.setOnLoadCallback(drawChart);
	
	      function drawChart() {
	
	        var data = google.visualization.arrayToDataTable([
	          ['Item', 'Amount'],
	          <% for(Entry<String, Integer> map : salesMap.entrySet()) { %>
	          	['<%=map.getKey() %>', <%=map.getValue() %>],
	          <% } %>
	        ]);
	
	        var options = {
	          title: 'Sales Analysis'
	        };
	
	        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
	
	        chart.draw(data, options);
	      }
	    </script>
		
	</head>
	<body style="padding: 15px">
		
		<table>
			<td valign="top">
				<form class="pure-form">
					<fieldset>
						<legend>Sales Analysis</legend>
						<table class="pure-table pure-table-bordered">
							<thead>
								<th>項目</th><th>銷售額</th>
							</thead>
							<tbody>
								<% for(Entry<String, Integer> map : salesMap.entrySet()) { %>
									<tr>
										<td><%=map.getKey() %></td>
										<td><%=map.getValue() %></td>
									</tr>
								<% } %>		
							</tbody>
						</table>
					</fieldset>
				</form>
			</td>
			<td valign="top">
				<form class="pure-form">
					<fieldset>
						<legend>Sales Chart</legend>
						<div id="piechart" style="width: 900px; height: 500px;"></div>
					</fieldset>
				</form>	
			
			</td>
		</table>
		
	</body>
</html>