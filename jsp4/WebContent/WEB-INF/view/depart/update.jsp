<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Updae</title>
</head>
<body>
<div class="container">
		<table id="table" data-height="460"
			class="table table-bordered table-hover">
			<tbody id="result_tbody">
			<tr>
					<td>부서번호</td>
					<td>${depart.dino}</td>
			</tr>
			<tr>
					<td>부서이름</td>
					<td><input type="text" name="diname" id="diname" value="${depart.diname}"></td>
			</tr>
			<tr>
					<td>부서설명</td>
					<td><input type="text" name="didesc" id="didesc" value="${depart.didesc}"></td>
			</tr>

			</tbody>
		</table>
	</div>
</body>
</html>