<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	/* 자바 코드를 넣으면 된다. */
	Member mem = (Member)request.getAttribute("mem");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2><%= mem.getAddress() %>에 거주하는 멤버의 정보입니다.</h2>
	<p></p>
	이름 : <%= mem.getName() %> <br>
	나이 : <%= mem.getAge() %> <br>
</body>
</html>