<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ include file="/common/header.jsp" %>
<html>
<link rel="stylesheet" href="<%=rootPath%>/ui/sign.css"/>
<body>
<form class="form-signin" >
		<h2 class="form-signin-heading">회원가입</h2>
		
		<label for="id" class="sr-only">ID</label> <input type="text"
			id="id" name="id" class="form-control" placeholder="ID" required autofocus>

		 <label for="pwd" class="sr-only">Password</label>
		<input type="password" name="pwd" id="pwd" class="form-control"
			placeholder="Password" required>
			
		<label for="name" class="sr-only">이름</label> <input type="text"
			id="name" name="name" class="form-control" placeholder="이름" required >
		<label for="age" class="sr-only">나이</label> <input type="text"
			id="age" name="age" class="form-control" placeholder="나이" required >
		<label for="address" class="sr-only">주소</label> <input type="text"
			id="address" name="address" class="form-control" placeholder="주소" required ><br>
			
		<label for="dino" class="sr-only">부서</label>
		<select name="dino" id="dino">		</select>		
		
		<input  class="btn btn-lg btn-primary btn-block"
			type="button" id="joinBtn" value="회원가입">
	</form>
<script>
function callback(result){
	var str ="";
	for(var di of result){
		str += "<option value='" + di.diNo + "'>" + di.diName + "</option>"
	}
	$("#dino").html(str);
}

$(document).ready(function(){
	
	var url = "dino.user";
	var param = {};
	param["cmd"] = "dino";

	$.ajax({
		type : "post",
		url : url,
		dataType : "json",
		data : param,
		success : callback,
		error : function(xhr,status){
			alert("에러 : " + xhr.responseText)
		}
	});
	
})

function afterLogin(obj){
	alert(obj.msg);
	if(obj.result=='ok'){
		location.reload();
	}
}
$("#joinBtn").click(function(){
		var url = "join.user";
		var params = {};
		//< userID 이값은 DTO의 변수명과 동일하게 해야한다.
		params["userId"] = $("#id").val();
		params["userPwd"] = $("#pwd").val();
		params["userName"] = $("#name").val();
		params["userAge"] = $("#age").val();
		params["userAddress"] = $("#address").val();
		params["diNo"] = $("#dino").val();

		var param = {};
		param["cmd"] = "join";
		//< JSON.stringify은 JSON 타입의 구조체로 변경한다.
		param["params"] = JSON.stringify(params);
		

		//< dataType을 따로 지정하지 않으면 text형태로 된다.
		$.ajax({
			type : "post",
			url : url,
			dataType : "json",
			data : param,
			success : afterLogin,
			error : function(xhr,status){
				alert("에러 : " + xhr.responseText)
			}
		});
});

</script>
</body>
</html>