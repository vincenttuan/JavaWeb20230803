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
		
		<form class="pure-form" method="post" action="${pageContext.request.contextPath}/servlet/sales/add">
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
				分店: 
					<select id="branch" name="branch" onchange="this.value==''?branch_newname.style.display='':branch_newname.style.display='none';">
						<option value="">請選擇</option>
					    <option value="信義分店">信義分店</option>
					    <option value="大安分店">大安分店</option>
					    <option value="左營分店">左營分店</option>
					    <option value="西區分店">西區分店</option>
					    <option value="鳳山分店">鳳山分店</option>
					    <option value="中壢分店">中壢分店</option>
					    <option value="東區分店">東區分店</option>
					    <option value="安平分店">安平分店</option>
					    <option value="北區分店">北區分店</option>
					    <option value="南區分店">南區分店</option>
					    <option value="士林分店">士林分店</option>
					    <option value="蘆竹分店">蘆竹分店</option>
					    <option value="鼓山分店">鼓山分店</option>
					    <option value="中區分店">中區分店</option>
					    <option value="大同分店">大同分店</option>
					    <option value="香山分店">香山分店</option>
					    <option value="松山分店">松山分店</option>
					    <option value="平鎮分店">平鎮分店</option>
					    <option value="中西分店">中西分店</option>
					    <option value="前鎮分店">前鎮分店</option>
					    <option value="南屯分店">南屯分店</option>
					    <option value="中山分店">中山分店</option>
					    <option value="楊梅分店">楊梅分店</option>
					    <option value="安南分店">安南分店</option>
					    <option value="苓雅分店">苓雅分店</option>
					    <option value="北屯分店">北屯分店</option>
					    <option value="竹北分店">竹北分店</option>
					    <option value="萬華分店">萬華分店</option>
					    <option value="南港分店">南港分店</option>
					    <option value="三民分店">三民分店</option>
					    <option value="永康分店">永康分店</option>
					    <option value="龍潭分店">龍潭分店</option>
					    <option value="新興分店">新興分店</option>
					    <option value="內湖分店">內湖分店</option>
					    <option value="新豐分店">新豐分店</option>
					    <option value="文山分店">文山分店</option>
					    <option value="鳥松分店">鳥松分店</option>
					    <option value="西屯分店">西屯分店</option>
					    <option value="小港分店">小港分店</option>
					    <option value="龜山分店">龜山分店</option>
					    <option value="前金分店">前金分店</option>
					    <option value="烏日分店">烏日分店</option>
					    <option value="中正分店">中正分店</option>
					    <option value="八德分店">八德分店</option>
					    <option value="仁德分店">仁德分店</option>
					    <option value="旗津分店">旗津分店</option>
					</select>
					<!-- 自訂新的分店名 -->
					<input type="text" id="branch_newname" name="branch_newname" title="自訂新的分店名">
				<p />
				<button type="reset" class="pure-button">重置</button>
				<button type="submit" class="pure-button pure-button-primary">新增</button>
			</fieldset>
		</form>
		
	</body>
</html>