<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View</title>
</head>
<body>
<div class="container">
		<table id="table" data-height="460"
			class="table table-bordered table-hover">
			<tbody id="result_tbody">
			<tr>
					<td>부서번호</td>
					<td>${depart.diNo}</td>
			</tr>
			<tr>
					<td>부서이름</td>
					<td>${depart.diName}</td>
			</tr>
			<tr>
					<td>부서설명</td>
					<td>${depart.diEtc}</td>
			</tr>
			
			<tr>
					<td colspan="2"><button onclick="goUpdate()">수정</button></td>
			</tr>

			</tbody>
		</table>
	</div>
	<script>
		function goUpdate(){
			location.href="/depart/update?dino=${depart.diNo}";
		}
	</script>
</body>
</html>