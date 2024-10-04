<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<table class="table table-bordered">
		    <thead>
		    	<tr>
			        <th>상품명</th>
			        <th>제조사</th>
			        <th>가격</th>
		    	</tr>
		    </thead>
		    <tbody>
				<c:forEach items="${list}" var="myProduct">
					<tr>
						<td>${myProduct.name}</td>
						<td>${myProduct.maker}</td>
						<td>${myProduct.price}원</td>
					</tr>
				</c:forEach>
		      
		    </tbody>
		</table>
		
		<a href="myProduct.html">뒤로가기</a>
	</div>
</body>
</html>