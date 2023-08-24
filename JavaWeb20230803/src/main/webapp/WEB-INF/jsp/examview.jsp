<%@page import="repository.model.Exam"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Exam View</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 15px">
		
		<form class="pure-form">
			<fieldset>
				<legend>Exam View</legend>
				
				<table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th rowspan="2" valign="middle">序號</th>
							<th rowspan="2" valign="middle">帳號</th>
							<th rowspan="2" valign="middle">密碼</th>
							<th rowspan="2" valign="middle">代號</th>
							<th rowspan="2" valign="middle">費用</th>
							<th rowspan="2" valign="middle">繳費</th>
							<th rowspan="2" valign="middle">日期</th>
							<th colspan="3" valign="middle" align="center">時段</th>
							<th rowspan="2" valign="middle">備註</th>
						</tr>
						<tr>
							<th>上午</th>
							<th>下午</th>
							<th>晚上</th>
						</tr>
					
					<tbody>
						<% for(Exam exam : (List<Exam>)request.getAttribute("exams")) { %>
						<tr>
							<td align="center"><%=exam.getId() %></td>
							<td><%=exam.getUsername() %></td>
							<td><%=exam.getPassword() %></td>
							<td><%=exam.getExamNo() %></td>
							<td><%=exam.getExamFee() %></td>
							<td align="center"><%=(exam.getPaid()?"V":"") %></td>
							<td><%=exam.getExamDate() %></td>
							<td align="center"><%=(exam.getExamPeriod1()?"V":"") %></td>
							<td align="center"><%=(exam.getExamPeriod2()?"V":"") %></td>
							<td align="center"><%=(exam.getExamPeriod3()?"V":"") %></td>
							<td><%=exam.getMemo() %></td>
						</tr>
						<% } %>
					</tbody>
					
				</table>
				<p />
				<button type="button" 
						onclick="window.location.href='/JavaWeb20230803/html/examform.html';"
						class="pure-button pure-button-primary">新增 Exam</button>	 
			</fieldset>
		</form>
		
	</body>
</html>