<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 회원 검색(단순검색)</h2>
	<form action ="front.do" method ="post">
		<input type ="hidden" name ="command" value ="find">
		
		조회ID<input type ="text" name ="id" required="required">
		<input type ="submit" value ="회원검색">
		
	</form>
</body>
</html>