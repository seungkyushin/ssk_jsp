<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<script>
function callback(re){
	var obj = JSON.parse(re);
	alert(obj.msg);
	if(obj.result=="ok"){
		location.reload();
	}
	
}
function login(){
	var url = 'list.user';
	var id = document.getElementById("id");
	var pwd = document.getElementById("pwd");
	var param = '?cmd=login&id=' + id.value + '&pwd=' + pwd.value;
	var au = new AjaxUtil(url,param);
	au.changeCallBack(callback);
	au.send();
}
</script>
<body>
<% 
if( user != null )
{
out.println(user.getUserName() + "님 환영합니다.");
out.println(user.getUserAge() + "살 이시네요 ");
}else
{


%>
<div id="resutDiv">
</div>
<form method='post' action="/te.login">
아이디 : <input type="text" name="id" id="id"><br>
비밀번호 : <input type="password" name="pwd" id="pwd"><br>
<input type="button" value="login" onclick="login()"> 
</form>
<%
}
%>
</body>
</html>