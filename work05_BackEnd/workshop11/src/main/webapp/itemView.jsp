<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!--  구글 jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>


<script type="text/javascript">

	$(function() {
		
		$("#view").on(click, function({
			
			$.ajax({
                type: "get",
                url: "recordCount.do?itemNum=${item.itemNumber}",
                success: function (result) {
                	$("#view").text(result.count);

                }
            })
			
		});
		
	});


</script>


<style>

* {
    text-align: center;
}

h2 {
    color: blue;
    margin-bottom: 10px;
}

#header {
    background : yellow;
    margin-bottom: 20px;
    padding : 20px;
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

</style>

</head>
<body>
	<h2>${item.name}의 정보</h2>
	<div id ="header">
		조회수 : <p id ="view">${item.count}</p>
		장바구니 담기
		장바구니 확인 
	</div>
	
	<div class ="content">
		<img src="${item.url}">
		<div>
			종류 : <p class="price">${item.name}</p><br>
			가격 : <p class="price">${item.price}</p><br>
		 	설명 : <p class="price">${item.description}</p><br>
		</div>
	</div>
	
	
	<a href ="#">상품 목록 보기</a>
	
</body>
</html>