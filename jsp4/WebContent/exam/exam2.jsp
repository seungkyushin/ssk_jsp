
<%@page import="java.util.Iterator"%>
<%@page import="com.test.jsp.common.ListExam"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ include file="/common/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리스트 테스트</title>
</head>
<body>

jstl : ${test}
<br>
session : ${s_test}
<br>
application : ${a_test}

<%
String[] strs = {"1","2","3"};
UserInfo[] userList = new UserInfo[3];
UserInfo ui = new UserInfo();
ui.setUserName("test1");
userList[0] = ui;
ui = new UserInfo();
ui.setUserName("test2");
userList[1] = ui;
ui = new UserInfo();
ui.setUserName("test3");
userList[2] = ui;
request.setAttribute("userList",userList);
%>



<table border="1">
	<tr>
		<th>유저이름</th>
	</tr>
	<c:forEach var="ui" items="${userList}">
		<tr>
			<td>${ui.userName}</td>
		</tr>
	</c:forEach>
			
</table>
</body>
</html>