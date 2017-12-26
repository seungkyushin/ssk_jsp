<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert</title>
</head>
<body>
	<div class="container">
		<form action="/depart/insert_ok" method="post"
			onsubmit="return checkValue()">
			<table id="table" data-height="460"
				class="table table-bordered table-hover">
				<tbody id="result_tbody">
					<tr>
						<td>부서번호</td>
						<td></td>
					</tr>
					<tr>
						<td>부서이름</td>
						<td><input type="text" name="diName" id="diName" value=""></td>
					</tr>
					<tr>
						<td>부서설명</td>
						<td><input type="text" name="diEtc" id="diEtc" value=""></td>
					</tr>
					<tr>
						<td colspan="2">
							<button>저장</button>
							<button type="button" onclick="goList()">취소</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
<script>
function goList(){
	location.href="/depart/list";
}
function checkValue(){
	var diName = $("#diName").val().trim();
	var diEtc = $("#diEtc").val().trim();
	if(diName == "")
		{
			alert("부서명을 입력해주세요");
			return false;
		}
	if(diEtc == "")
	{
		alert("부서설명을 입력해주세요");
		return false;
	}
}
</script>
	</div>
</body>
</html>