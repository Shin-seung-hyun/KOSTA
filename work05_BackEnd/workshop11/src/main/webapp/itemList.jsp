<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
   
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
}

.fruitList {
    display: flex;
    flex-direction: row;
    justify-content: center; /* 아이템들이 중앙에 정렬되도록 설정 */
    flex-wrap: wrap; /* 아이템들이 한 행에 너무 많으면 다음 줄로 이동 */
    gap: 3px; 
}

.fruit {
    display: flex;
    flex-direction: column;
    align-items: right;
    width: 150px;
    margin-bottom: 20px; 
}

.fruit img {
    width: 100px;
    height: 100px;
    border: 2px solid black;
    border-radius: 5px;
}
</style>

<script type="text/javascript">
	
	$(function() {
/* 	    $('#fruitImg').on(click, function({
	    	
	        let name = $(this).find(".name").text();  
	        let price = $(this).find(".price").text();

	        console.log("name = " + name + ", price = " + price);

	        let itemInfo = { name: name, price: price };
	        
	        localStorage.setItem("item", JSON.stringify(itemInfo));
	    }); */
	});


</script>


</head>
<body>
	<h2>Fruit Total List1.</h2>
	<div class="fruitList">
        <c:forEach var="item" items="${items}">
            <div class="fruit">
                <a href="itemView.do?itemNum=${item.itemNumber}" id ="fruitImg"><img src="${item.url}"></a><br>
                상품명 : <span class="name">${item.name}</span><br>
                가격 : <span class="price">${item.price}</span><br>
            </div>
        </c:forEach>
    </div>
	
</body>
</html>