<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Updae</title>
</head>
<body>
	<div class="container">
		<form action="/depart/update_ok" method="post">
			<table id="table" data-height="460"
				class="table table-bordered table-hover">
				<tbody id="result_tbody">
					<tr>
						<td>부서번호</td>
						<td>${depart.diNo}</td>
					</tr>
					<tr>
						<td>부서이름</td>
						<td><input type="text" name="diName" id="diName"
							value="${depart.diName}"></td>
					</tr>
					<tr>
						<td>부서설명</td>
						<td><input type="text" name="diEtc" id="diEtc"
							value="${depart.diEtc}"></td>
					</tr>
					<tr>
						<td colspan="2">
						 <button>저장</button>
						 <button type="button">취소</button>
					</tr>
				</tbody>
			</table>
			<input type="hidden" name="diNo" value="${depart.diNo}">
		</form>
	</div>
</body>
</html>