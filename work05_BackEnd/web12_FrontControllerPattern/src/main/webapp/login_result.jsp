<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%

	Member vo  = (Member)session.getAttribute("vo");

	if( vo == null){
%>
		<h4>로그인부터 다시 해주세요</h4>
		<a href ="index.html">HOME</a>
<%		

	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> Login Information</h2>
	ID <%= vo.getId() %> <br>
	Name <%= vo.getName() %><br>
	Address <%= vo.getAddress() %><br>
	
	<p></p> 
	<hr>
	
	<a href ="logout.jsp">Log out</a>
	<a href ="index.html">INDEX</a>
</body>
</html>