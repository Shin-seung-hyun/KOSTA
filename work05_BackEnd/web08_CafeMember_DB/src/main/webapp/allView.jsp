<%@page import="web.servlet.model.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
 ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">회원 전체 명단 보기</h2>
	<table border = "2" width ="400px" bgcolor = "yellow" align="center">
	
	<%
		for(Member vo : list){
	%>
			<tr>
				<td> <%= vo.getId() %></td>
				<td> <%= vo.getName() %></td>
				<td> <%= vo.getAddress() %></td>	 							
			</tr>
	<%
		}
	%>
	
	</table>
	
	<h3 align="center"><a href ="index.html">Index</a></h3>
</body>
</html>