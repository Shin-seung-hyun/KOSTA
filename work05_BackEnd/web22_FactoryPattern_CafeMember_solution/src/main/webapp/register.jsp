<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(()=>{
		$('#idCheck').on('click', ()=>{
			let id = $('#id').val();
			$.ajax({
				//front.do?command=idCheck
				type:'post',
				url:'idCheck.do',
				//서버에서 응답하는 데이터 타입을 미리 알려주는 속성
				data: {'id':id},
				
				success: function(result){
					if(result=='false'){
						$('#resultView').html('<h3><font color=crimson>사용가능 ID!!</font></h3>');
					}else{
						$('#resultView').html('<h3><font color=blue>사용중인 ID!!</font></h3>');
					}
				}
			})
			
		})
	});
</script>
</head>
<body>
<h2>회원가입</h2>
<form action="register.do" method="post">
	ID : <input type="text" name="id" required="required" id="id">
		 <input type="button" value="중복확인" id="idCheck">
		 <span id="resultView"></span>
		 <br>
	PASSWORD : <input type="password" name="password" required="required"><br>
	NAME : <input type="text" name="name"><br>
	ADDRESS : <input type="text" name="address"><br>
	<input type="submit" value="회원가입">
</form>
</body>
</html>