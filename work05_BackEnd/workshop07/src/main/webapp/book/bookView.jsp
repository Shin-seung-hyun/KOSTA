<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- bootstrap -->
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
 <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
 
<style type="text/css">

	body{
		text-align: center;
	}
	.table {
	   margin: auto;
	   width: 50% !important; 
	}
	
	table th {
	   background-color: darkgrey;
	}

	form{
		text-align: right;
	}

</style>  


</head>
<body>
	<h2 align="center">도서 목록 화면</h2>
	
	<form action="./front.do" method="get" id="frm">
		<input type ="hidden" name ="command" value ="searchBook">
		<select name = "category">
			<option value ="all">전체</option>
			<option value ="title">도서명</option>
			<option value ="publisher">출판사</option>
			<option value ="price">가격</option>
		</select>
		<input type ="text" name ="search">
		<input type="submit" value="검색">
	</form>	

	
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>도서번호 </th>
				<th>도서명 </th>
				<th>도서분류 </th>
				<th>저자 </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${books}" var ="item">
				<tr>
					<td>${item.isbn}</td>
					<td>${item.title}</td>
					<td>${item.catalogue}</td>
					<td>${item.author}</td>
				</tr>
			
			</c:forEach>
		</tbody>
	</table>
	
	<a href ="./book/Book.html">도서 등록</a>
</body>
</html>