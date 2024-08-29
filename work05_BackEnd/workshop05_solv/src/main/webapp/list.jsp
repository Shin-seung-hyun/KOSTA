<%@page import="web.servlet.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h2>Product List</h2>
	<table class="table table-dark table-hover">
		<thead>
			<tr>
				<th>상품 번호</th>
				<th>상 품 명</th>
				<th>상품 가격</th>
				<th>상품 설명</th>
			</tr>
		</thead>
		<tbody>
			<% 
				for(Product p : list){
			%>
			<tr>
				<td><%= p.getProductNo() %></td>
				<td><%= p.getName() %></td>
				<td><%= p.getPrice() %></td>
				<td><%= p.getDetail() %></td>
			</tr>
			<%		
				}
			%>
		</tbody>
	</table>
	<h3><a href="index.html">INDEX</a></h3>
</div>
</body>
</html>