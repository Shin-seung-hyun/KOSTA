<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 	Member vo =(Member)request.getAttribute("vo");
 %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 검색 결과</h2>
	<h3>ID <%= request.getParameter("id") %> 님에 대한 정보입니다.</h3>
	<!-- Kosta에 대한 정보는 Attribute에서 가져오기 -->

	<hr>
	이름 <%= vo.getName() %> <br>
	주소 <%= vo.getAddress() %> <br>
	
</body>
</html>