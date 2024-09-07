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
		$(function(){
			
			$("#AjaxBtn").on("click", ()=>{
				
				let id = $("userId").val();
				
				//비동기 시작
				$.ajax({
					
				/* 	Get 방식일 때
					type: 'get',
					url : './members.json?id=' + id, 
				*/
					
					type : 'post',
					url : './members.json',
					data : { 'id' : id},
					
					success : function(result){
						//alert(result.members.length);
						
						let members = result.members;
						let str = '';
						$.each(members, function(index, item){
							
							//str += item.id;
							$('#resultScope').append('<h3><font color=crimson>' + item.id + "</font></h3>");
							
						})
						
						//alert(str);
					}
					
				}); // ajax
				
			});
			
		});
		
	
	</script>

</head>
<body>
	<h3>Form에 입력된 값 서버로 보내고 서버에서 보낸값 받아서 페이지 부분 갱신하기</h3>

	ID<input type ="text" name ="userId" id ="userId">
	<input type ="button" value ="AjaxBtn" id ="AjaxBtn">
	<div id = "resultScope"> <!-- 동기 통신일 때는 resultPage 인 영역 -->
		
	</div>
</body>
</html>