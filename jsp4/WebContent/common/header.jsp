<%@page import="com.test.jsp.dto.UserInfo"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP4</title>
</head>

<%
UserInfo user = null;
user = (UserInfo) session.getAttribute("user");
String m2 = "로그인";
String u2 = "/user/login.jsp";
if(user!=null){
	m2 = "로그아웃";
	u2 = "/user/logout.user?cmd=logout";
}
%>
<script>
var AjaxUtil = function(p_url, p_params, p_method,p_aSync){
	if(!p_url || p_url.trim()==""){
		alert("AjaxUtil호출시 url은 필수 입니다.");
		return;
	}
	this.params = p_params;
	var getHttpXmlObj = function(){
		if(window.XMLHttpRequest){
	  		return new XMLHttpRequest();
	 	}else if(window.ActiveXObject){
	  		return new ActiveXObject("Microsoft.XMLHTTP");
	 	}
		alert("해당 브라우져가  Ajax를 지원하지 않습니다.");
	}
	this.xhr = getHttpXmlObj();
	var method = p_method?p_method:"get";
	var url = p_url;
	var aSync = p_aSync?p_aSync:true; //< ture면 비동기 
	this.xhr.callback = null;
	this.xhr.onreadystatechange=function(){
   		if (this.readyState==4){ //< 서버로부터 연결이 잘되었다면 값이 4로 된다.
   			if(this.status==200){ //< 성공적인 대답/응답 성공!
	   			var result = decodeURIComponent(this.responseText); //< 서버가 응답하는 곳
	   			if(this.callback){ 
	   				this.callback(result); //< 콜백함수 실행 this는 함수영역에 있기 떄문에 this(xhr).callback
	   			}else{
	   				alert(result);
	   			}
   			}else{
	   			var result = decodeURIComponent(this.responseText);
	   			alert(result);
   			}
   		}
	}
	this.changeCallBack = function(func){
		this.xhr.callback = func;
	}
	//< 전화기로 비유하면 전화번호만 누르고 대기중...
   	this.xhr.open(method, url+this.params, aSync);
	
	//< 서버로 전송!(전화 걸기)
   	this.send = function(){
   		this.xhr.send.arguments = this;
   	   	this.xhr.send(); //< 서버로 send
   	}
}
</script>
<body>
<table border="1">
	<tr>
		<td><a href="/index.jsp">home</a></td>
		<td><a href="<%=u2%>"><%=m2%></a></td>
		<td><a href="#">회원가입</a></td>
		<td><a href="#">게시판</a></td>
		<td><a href="/user/list.jsp">유저리스트</a></td>
	</tr>
</table>
<%
String str1 = "Name1";
String str2 = "나이";
%>
</body>
</html>


