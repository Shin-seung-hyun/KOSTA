<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
* {
	text-align: center;
}
</style>
</head>
<body>
	<br>
	<h1>${vo.userId} 님이 로그인 되었습니다~~!!!
	</h1>
	
	<br>
	<a href="./book/Book.html">추가 등록</a><br><br>
	
	<br>
	<a href="./front.do?command=showAllBook">도서목록</a><br><br>
</body>
</html>



