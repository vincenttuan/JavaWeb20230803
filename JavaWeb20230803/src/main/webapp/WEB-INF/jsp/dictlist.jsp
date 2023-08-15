<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Dict List</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 15px">
		
		<form method="get" action="/JavaWeb20230803/html/transferform.html" class="pure-form">
			<fieldset>
				<legend>所有字典列表</legend>
				<%=request.getAttribute("dict") %><p />
				<table class="pure-table pure-table-bordered">
				    <thead>
				        <tr>
				            <th>#</th>
				            <th>Make</th>
				            <th>Model</th>
				            <th>Year</th>
				        </tr>
				    </thead>
				    <tbody>
				        <tr>
				            <td>1</td>
				            <td>Honda</td>
				            <td>Accord</td>
				            <td>2009</td>
				        </tr>
				        <tr>
				            <td>2</td>
				            <td>Toyota</td>
				            <td>Camry</td>
				            <td>2012</td>
				        </tr>
				        <tr>
				            <td>3</td>
				            <td>Hyundai</td>
				            <td>Elantra</td>
				            <td>2010</td>
				        </tr>
				    </tbody>
				</table>
				<p />
				<button type="submit" class="pure-button pure-button-primary">回上一頁</button>	 
			</fieldset>
		</form>
		
	</body>
</html>