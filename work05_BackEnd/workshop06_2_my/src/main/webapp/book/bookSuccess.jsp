<%@page import="web.servlet.model.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	Book vo = (Book)session.getAttribute("vo");

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align="center">
	<h2 align="center">결과 페이지</h2>
	<p style="color: green"><%= vo.getTitle() %> 정상적으로 저장됐습니다.</p> 
	<a href ="book.html">추가 등록</a>
	<a href = "#">도서목록</a>
</body>
</html>