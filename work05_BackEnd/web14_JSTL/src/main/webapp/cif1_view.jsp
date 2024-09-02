<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!--
만약에 폼값에 입력된 숫자가 100이면
자동차세 100 만원 입금됐습니다.

만약에 폼값에 입력된 숫자가 200이면
보증금 200 만원 입금됐습니다.

JSTL if문으로 작성
1) .jar 파일이 2개 있어야 한다. (jstl.jar, standard.jar)
2) taglib 라는 선언문이 필요하다
	http://java.sun.com/jsp/jstl/core

-->
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>jstl의 if문을 다뤄보자</h2>
	<c:if test="${param.NUM == '100'}">
		<b>자동차세 100만원이 입급됐습니다.</b><br>
	</c:if>
	<c:if test="${param.NUM == '200'}">
		<b>보증금 200만원이 입급됐습니다.</b><br>
	</c:if>	
</body>
</html>