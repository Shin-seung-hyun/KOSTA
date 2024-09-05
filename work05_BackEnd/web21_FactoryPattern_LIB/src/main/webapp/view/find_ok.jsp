<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 검색 결과</h2>
	${message}
	<h3>ID ${param.id} 님에 대한 정보입니다.</h3>
	<hr>
	이름 ${vo.name} <br>
	주소 ${vo.address} <br>
	
</body>
</html>