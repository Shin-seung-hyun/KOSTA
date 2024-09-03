<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script type="text/javascript">
	
		$(function(){
			
			$('#AjaxBtn').on('click',()=>{
				
				//폼에 입력된 값 받아오기
				let id = $('#userId').val();
				
				$.ajax({
					
					//요청하는 부분
					type : 'post',
					url : 'front.do',
					data : {'id' : id},
					
					//응답부분
					success : function(result){
						alert(result);
					},
					error : function(message){
						alert("대기시간 초과 에러" + message);
					},
					timeout:1000 //1초 이상 서버에서 응답하지 않을 시 에러 처리
					
					
				});// ajax
				
				
			});
			
		});
		
	
	</script>

</head>
<body>
	<h2>서블릿으로 비동기 요청하기</h2>
	ID<input type ="text" name ="userId" id ="userId">
	<input type ="button" value ="AjaxBtn" id ="AjaxBtn">
	<div id = "resultScope">
		
		
	</div>
</body>
</html>