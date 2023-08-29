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
	          title: 'Sales Analysis', is3D: true
	        };
	
	        //var chart = new google.visualization.PieChart(document.getElementById('piechart'));
	        //var chart = new google.visualization.BarChart(document.getElementById('piechart'));
	        var chart = new google.visualization.ColumnChart(document.getElementById('piechart'));
	        //var chart = new google.visualization.LineChart(document.getElementById('piechart'));
	    	
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
						分析項目: 
							<input type="radio" id="item" name="item" value="1"> 根據地區印出每區的銷售金額<br>
							<input type="radio" id="item" name="item" value="2"> 根據產品印出每一種產品的銷售金額<br>
							<input type="radio" id="item" name="item" value="3"> 根據分店印出每一家的銷售金額<br>
						選擇圖型:
							<input type="radio" id="chart" name="chart" value="1"> 直方圖
							<input type="radio" id="chart" name="chart" value="2"> 長條圖
							<input type="radio" id="chart" name="chart" value="3"> 圓餅圖
							<input type="radio" id="chart" name="chart" value="4"> 折線圖
						<br>	
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