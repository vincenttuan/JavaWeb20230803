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
				價格: <input type="number" id="price" name="price"><p />
				數量: <input type="number" id="qty" name="qty"><p />
				城市: 
					<select id="product" name="product">
						<option value="台北">台北</option>
						<option value="桃園">桃園</option>
						<option value="新竹">新竹</option>
						<option value="台中">台中</option>
						<option value="台南">台南</option>
						<option value="高雄">高雄</option>
					</select><p />
				分店: <input type="text" id="branch" name="branch" value="桃園分店"><p />
				<button type="reset" class="pure-button">重置</button>
				<button type="submit" class="pure-button pure-button-primary">新增</button>
			</fieldset>
		</form>
		
	</body>
</html>