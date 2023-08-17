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
		
		<form method="post" action="/JavaWeb20230803/servlet/login" class="pure-form">
			<fieldset>
				<legend>登入</legend>
				帳號: <input type="text" id="username" name="username" placeholder="請輸入帳號"><p />
				密碼: <input type="password" id="password" name="password" placeholder="請輸入密碼"><p />
				<button type="reset" class="pure-button">清除</button>
				<button type="submit" class="pure-button pure-button-primary">登入</button>	 
			</fieldset>
		</form>
		
	</body>
</html>