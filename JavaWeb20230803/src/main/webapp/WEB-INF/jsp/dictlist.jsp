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
				<button type="submit" class="pure-button pure-button-primary">回上一頁</button>	 
			</fieldset>
		</form>
		
	</body>
</html>