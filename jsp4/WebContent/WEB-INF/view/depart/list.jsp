<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list</title>
</head>

<body>
<div class="container">
		<br>
		<form class="fprm-signin" action="/depart/list" method="get">
			<select name="serchOption">
				<option value="diName">부서이름</option>
				<option value="diEtc">부서설명</option>
			</select>
			<input type="text" id="diName" name="diName"><button>검색</button>
		</form>
		<table id="table" data-height="460"
			class="table table-bordered table-hover">
			<thead>
				<tr>
					<th class="text-center" data-field="userNo">부서번호</th>
					<th class="text-center" data-field="userId">부서이름</th>
					<th class="text-center" data-field="userName">부서설명</th>
					<th class="text-center" data-field="btn">삭제</th>
				</tr>
			</thead>
			<tbody id="result_tbody">
		
			<c:forEach items="${departList}" var="dp">
			<tr >
			
					<td onclick="goView(${dp.diNo})">${dp.diNo}</td>
					<td onclick="goView(${dp.diNo})">${dp.diName}</td>
					<td onclick="goView(${dp.diNo})">${dp.diEtc}</td>
					<td><button tpye="button" onclick="deleteDi(${dp.diNo})">삭제</button></td>
				
			</tr>
			</c:forEach>
			</tbody>
		</table>
		<button type="button" id="diInsertBtn">부서입력</button>
	</div>
	<c:if test="${insert == 1}">
	
	<script>
		alert("정상입력 되었습니다.");
		location.href="/depart/list";
	</script>
	</c:if>
	
		<c:if test="${update == 1}">
	
	<script>
		alert("업데이트 되었습니다.");
		location.href="/depart/list";
	</script>
	</c:if>
	
	<c:if test="${delete == 1}">
	
	<script>
		alert("정상 삭제 되었습니다.");
		location.href="/depart/list";
	</script>
	</c:if>
	
	<script>
	$("#diInsertBtn").click(function(){
			location.href ="/depart/insert";
	})
	function goView(diNo)
	{
		location.href="/depart/view?dino=" + diNo;
	}
	function deleteDi(diNo){
		location.href="/depart/delete?dino=" + diNo;
	}
	</script>
</body>
</html>