
<%@page import="web.servlet.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%
	Product product = (Product)request.getAttribute("product");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>상품이 저장되었습니다.</h2>
<div>
	<p><b>상품 번호</b> <%= product.getProductNum() %></p>
	<p><b>상 품 명</b> <%= product.getName() %></p>
	<p><b>상품 가격</b> <%= product.getPrice() %></p>
	<p><b>상품 설명</b> <%= product.getDescription() %></p>
</div>
</body>
</html>