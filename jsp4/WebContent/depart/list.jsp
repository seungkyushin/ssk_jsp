<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
		<table id="table" data-height="460"
			class="table table-bordered table-hover">
			<thead>
				<tr>
					<th class="text-center" data-field="userNo">부서번호</th>
					<th class="text-center" data-field="userId">부서이름</th>
					<th class="text-center" data-field="userName">부서설명</th>
				</tr>
			</thead>
			<tbody id="result_tbody">
		
			<c:forEach items="${departList}" var="dp">
			<tr>
				<c:if test="${dp.dino%2==1}">
					<td>${dp.dino}</td>
					<td>${dp.diname}</td>
					<td>${dp.didesc}</td>
				</c:if>
			</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>