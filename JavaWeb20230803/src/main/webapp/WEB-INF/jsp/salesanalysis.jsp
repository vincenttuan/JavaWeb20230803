<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="repository.model.Sales"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
	Map<String, Integer> branchSales = (Map<String, Integer>)request.getAttribute("branchSales");
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Sales Analysis</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 15px">
		
		<form class="pure-form">
			<fieldset>
				<legend>Sales Analysis</legend>
				<table class="pure-table pure-table-bordered">
					<thead>
						<th>分店</th><th>銷售額</th>
					</thead>
					<tbody>
						<% for(Entry<String, Integer> map : branchSales.entrySet()) { %>
							<tr>
								<td><%=map.getKey() %></td>
								<td><%=map.getValue() %></td>
							</tr>
						<% } %>		
					</tbody>
				</table>
					 
			</fieldset>
		</form>
		
	</body>
</html>