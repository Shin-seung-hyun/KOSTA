<%@page import="web.servlet.model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	Product product = (Product)request.getAttribute("product");
%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품이 저장되었습니다.</h2>
	<b>상품 번호 : </b> <%= product.getNum() %><br>
	<b>상품명 : </b> <%= request.getParameter("name") %><br>
	<b>상품 가격 : </b> <%= request.getParameter("price") %><br>
	<b>상품 설명 : </b> <%= request.getParameter("detail") %><br>
	
	<p></p>
	<a href ="List">상품목록</a>
	
</body>
</html>