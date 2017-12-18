<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HOME</title>
</head>

<%
if(user!=null){
out.println(user.getUserName() + "님 환영해요~~");
out.println(user.getUserAge() + "살 이시네요");
}else{
%>
<body>
이 프로젝트의 홈입니다.
</body>
<%
}
%>
</html>