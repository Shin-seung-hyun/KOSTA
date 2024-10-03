<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h1{
		color: DodgerBlue;
	}
</style>
</head>
<body>
    <h1 align="center"> ======= MyProduct ======= </h1><p/>
    
    <form action="addMyProduct.do" method="post">
    	상품명 : <input type ="text" name = "name" id ="name"  ><br>
		제조사 : <input type ="text" name = "maker" id ="maker"  ><br>
		가격 :  <input type ="text" name = "price" id ="price"  ><br>
		<input type="submit" value ="상품등록">
	</form>
</body>
</html>