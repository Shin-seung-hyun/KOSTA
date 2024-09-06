<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(()=>{
		cartList();
		calPrice();

		$('tbody').on('click', '.up', raiseCount);
		$('tbody').on('click', '.down', reduceCount);

		
		
		$('#delete').on('click', function () {
			$('input:checkbox[name=delete-check]').each(function (index) {
				if($(this).is(":checked")==true){
					localStorage.removeItem($(this).attr('id'));
			    }
			})
			
			cartList();
			calPrice();
		});
	});
	
	function cartList() {
		var cartList = "";
		var num = 1;
		for (let i = 0; i < localStorage.length; i++) {
			let key = localStorage.key(i);
			if (key.startsWith("cartList")) {
				let data = localStorage.getItem(key).split(",");
				cartList += "<tr>";
				cartList += "<td>" + num++ + "</td>";
				cartList += "<td><img src='" + data[0] + "' class='item-img'></td>";
				cartList += "<td>" + data[1] + "</td>";
				cartList += "<td class='price'>" + data[2] + "</td>";
				cartList += "<td><img src='img/up.jpg' class='up'><div class='count'>1</div><img src='img/down.jpg' class='down'></td>";
				cartList += "<td><input type='checkbox' id='" + key + "' name='delete-check'></td>";
				cartList += "</tr>";
			}
		}
		if(cartList=="") cartList = "<h3>장바구니에 담겨있는 상품이 없습니다.</h3>";
		$('tbody').html(cartList);
	}
		
	function calPrice() {
		var price = 0;
		$('tbody>tr').each(function (index) {
			price += parseInt($(this).find('.count').html()) * parseInt($(this).find('.price').html());
		});
		
		$('#price').html(price);
	}
	
	function raiseCount() {
		count = parseInt($(this).parent().find('.count').html()) + 1;
		$(this).parent().find('.count').html(count);
		calPrice()
	}
	
	function reduceCount() {
		if($(this).parent().find('.count').html()>1){
			count = parseInt($(this).parent().find('.count').html()) - 1;
			$(this).parent().find('.count').html(count);
			calPrice()			
		}
	}
</script>
<style type="text/css">
	.item-img{
		width: 150px;
		height: 150px;
	}
	
	.up, .down{
		width: 10px;
		height: 10px;
	}
	
	.table > tbody > tr > td {
	     vertical-align: middle;
	}
</style>
</head>
<body>
<div class="container">
	<h1 class="text-center text-danger" ><b>장바구니</b></h1>
	<div class="text-right mb-3 mr-5">
		<a href="itemList.do">쇼핑 계속하기</a>
	</div>
	<table class="table table-bordered">
		<thead class="table-primary text-center">
			<tr>
				<th>번호</th>
				<th>상품이미지</th>
				<th>상품명</th>
				<th>상품가격</th>
				<th>수량</th>
				<th><input type="button" value="삭제" id="delete"></th>
			</tr>
		</thead>
		<tbody class="text-center">
		</tbody>
		<tfoot class="table-primary text-right">
			<tr>
				<td colspan="6">총 결제금액 : <span id="price"></span></td>
			</tr>
		</tfoot>
	</table>
</div>
</body>
</html>