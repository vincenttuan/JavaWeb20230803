<%@page import="java.util.List"%>
<%@page import="repository.model.Sales"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Sales Add</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 15px">
		
		<form class="pure-form">
			<fieldset>
				<legend>Sales Add</legend>
				日期: <input type="date" id="date" name="date"><p />
				商品: <select id="product" name="product">
						<option value="紅茶">紅茶</option>
						<option value="咖啡">咖啡</option>
						<option value="冰沙">冰沙</option>
						<option value="綠茶">綠茶</option>
						<option value="珍珠奶茶">珍珠奶茶</option>
						<option value="冰淇淋">冰淇淋</option>
						<option value="果汁">果汁</option>
						<option value="拿鐵">拿鐵</option>
						<option value="熱可可">熱可可</option>
					 </select><p />
				價格: <input type="date" id="date" name="date"><p />
				數量: <input type="date" id="date" name="date"><p />
				城市: <input type="date" id="date" name="date"><p />
				分店: <input type="date" id="date" name="date"><p />
			</fieldset>
		</form>
		
	</body>
</html>