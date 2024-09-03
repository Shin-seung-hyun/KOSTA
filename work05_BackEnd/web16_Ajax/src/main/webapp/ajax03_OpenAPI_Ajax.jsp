<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	
	<!--  구글 jQuery CDN -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	
	<!-- bootstrap -->
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

	<script type="text/javascript">
	
		$(function(){
			
			$("#serverSend").on('click', ()=>{
				
				$.ajax({
					type : 'get',
					url : 'http://localhost:8888/weather.xml',
					
					// 서버에서 응답하는 데이터 타입을 미리 알려주는 속성 (꼭 안 해도 됨)
					// 응답할 때 데이터가 오더라도 요청할 때 들어간다.
					dataType : 'xml',
					success: function(result){
						//alert(result);
						
						let str = '';
						$(result).find("list").each(function(index, item){
							
							let region =$(this).find("region").text();
							let wind =$(this).find("wind").text();
							let rain =$(this).find("rain").text();
							let temp =$(this).find("temp").text();
							
							str += "<tr>";
							str += "<td>" + region+ "</td>";
							str += "<td>" + wind+ "</td>";
							str += "<td>" + rain+ "</td>";
							str += "<td>" + temp+ "</td>";
							str += "</tr>";
						});
						
						// 방법 1
						//$("tbody").html(str);  // on("click"function(){})
						
						//방법2
						//$("tbody").append(str); // one("click",function(){})
				
						//방법3 : 지우고 추가하기
						$("tbody>tr*").remove(); // on("click"function(){})
						$("tbody").append(str);
					}
					
				});
				
			});
			
		});
		
	
	</script>

</head>
<body>
	<div class = "container">
		<div class="jumbotron center-text">
			<h2 align = "center"> == Open API Weather 데이터 가져오기 == </h2>
		</div>	
		<p><a href ="#" id ="serverSend">XML 데이터 서버로 요청하기</a></p>
		
		<table class="table table-hover">
			<thead class= "thead-dark">
				<tr>
					<th>region</th>
					<th>wind</th>
					<th>rain</th>
					<th>temp</th>
				</tr>
			</thead>
			
			<tbody>
			<!-- 이 부분에 공공테이저 XML 의 태그 안의 내용이 출력 $.each -->
				<tr></tr>
			
			</tbody>
		
		</table>
	</div>

</body>
</html>