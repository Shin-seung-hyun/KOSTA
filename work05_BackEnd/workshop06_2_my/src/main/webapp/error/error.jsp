<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	String msg = (String)session.getAttribute("error");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2 align="center">정보를 찾지 못했습니다.</h2>
	<p align="center"><%= msg %> 문제가 발생했습니다.</p>
	<center><img src="../images/1.png"></center>

	<h3 align="center"><a href="../login.html">Try Log In.</a></h3>

</body>
</html>