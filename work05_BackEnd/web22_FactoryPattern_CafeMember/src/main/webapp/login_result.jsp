<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> Login Information</h2>
	ID ${vo.id} <br>
	Name ${vo.name} <br>
	Address ${vo.address} <br>
	
	<p></p> 
	<hr>
	
	<a href ="logout.do">Log out</a>
	<a href ="index.jsp">INDEX</a>
</body>
</html>