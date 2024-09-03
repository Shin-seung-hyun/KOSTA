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
		$("#idCheck").on('click', function(){
			let userId = $("#userId").val();
			
			// 비동기
			$.ajax({
			
				type : 'post',
				url :'front.do?command=idCheck',
				data : {"userId" : userId},
						
				// result 값 받아서 true/false 출력
				// resultView 영역에 사용중인 id(붉은색)/ 사용가능 id(파란색)
				success : function(result){
					
					if(result == 'true'){
						$("#resultView").html("<h3><font color=crimson> 사용중인 ID</font></h3>");
					}
					else{
						$("#resultView").html("<h3><font color=blue> 사용 가능 ID</font></h3>");
					}
					
					alert(result);
				}
				
			});
			
		});
	});

</script>

</head>
<body>
	<h2>Register Member Form</h2>
	<form action ="front.do" method ="post">
	<input type ="hidden" name ="command" value ="register">
		ID<input type ="text" name ="id" required="required" id ="userId">
		<input type ="button" value ="중복확인" id ="idCheck">
		<span id = "resultView"></span>
		<br>
		PASS<input type ="password" name ="password" required="required"><br>
		Name<input type ="text" name ="name"><br>
		ADDR<input type ="text" name= "address"><br>
		
		<input type ="submit" value ="회원등록">
	</form>
</body>
</html>