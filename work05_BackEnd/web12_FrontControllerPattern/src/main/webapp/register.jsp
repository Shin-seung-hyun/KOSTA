<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원등록</h2>
	<form action ="front.do" method ="post">
	<input type ="hidden" name ="command" value ="register">
		ID<input type ="text" name ="id" required="required"><br>
		PASS<input type ="password" name ="password" required="required"><br>
		Name<input type ="text" name ="name"><br>
		ADDR<input type ="text" name= "address"><br>
		
		<input type ="submit" value ="회원등록">
	</form>
</body>
</html>