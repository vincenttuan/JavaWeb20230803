<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登入</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 15px">
		
		<form method="get" action="/JavaWeb20230803/servlet/login" class="pure-form">
			<fieldset>
				<legend>登入-結果</legend>
				帳號: <%=request.getAttribute("username") %><p />
				結果: <%=request.getAttribute("check") %><p />
				<button type="submit" class="pure-button pure-button-primary">回上一頁</button>	 
			</fieldset>
		</form>
		
	</body>
</html>