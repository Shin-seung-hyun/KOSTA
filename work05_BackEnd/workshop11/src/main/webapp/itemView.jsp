<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!--  구글 jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>


<style>

* {
    text-align: center;
}

h2 {
    color: blue;
    margin-bottom: 10px;
}

#header {
    background : orange;
    margin-bottom: 20px;
    padding : 20px;
    text-align : right;
}

.content {
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center; /* 세로 중앙 정렬 */
}

.content img {
    width: 400px; 
    height: 400px;
    margin-right: 40px;
}

.content div {
    display: flex;
    flex-direction: column;
    align-items: flex-start; 
    gap: 10px; 
}

a{
	margin-top : 30px;
	display : inline-block;
}

</style>



</head>
<body>
	<h2>${item.name}의 정보</h2>
	<div id ="header">
		<span id ="view">조회수 : ${item.count}</span>&nbsp;&nbsp;
		<span>장바구니 담기</span>&nbsp;&nbsp;
		<span>장바구니 확인</span> 
	</div>
	
	<div class ="content">
		<img src="${item.url}">
		<div>
			<p class="price">종류 : ${item.name}</p><br>
			<p class="price">가격 : ${item.price}</p><br>
		 	<p class="price">설명 : ${item.description}</p><br>
		</div>
	</div>
	
	
	<a href ="itemList.do">상품 목록 보기</a>
	
</body>
</html>