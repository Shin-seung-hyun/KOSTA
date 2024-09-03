<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<!--  구글 jQuery CDN -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	
	<style>
        h1 {
            text-align: center;
        }
        form {
            text-align: right;
            margin-right: 438px;
        }
        table {
            width: 800px;
            margin: 20px auto;
        }
        tr {
            height: 43px;
        }
        th{
            background: #ddd;
        }
        .center{
        	margin-left: 740px;
        	padding-top: 30px;
        }
    </style>
    
<script type="text/javascript">
    
    $(function(){
        $("table .bookTitle").hover(function(){
        	
            let bookIsbn = $(this).prev().text();
            
            //console.log(bookIsbn);
            $(this).css('font-weight', 'bold').css('color', 'blue');
            
            // 비동기
            $.ajax({
                type: 'get',
                url: 'front.do?command=detail&isbn='+bookIsbn,
                
                success: function(result){
                    $("#detail").html("<h3><font color=crimson>" + result + "</font></h3>");
                }
            });
        });
    });

    
    
</script>
</head>
<body>
	<h1>도서 목록 화면</h1>
    <form action="${pageContext.request.contextPath}/front.do">
    	<input type="hidden" name="command" value="search">
        <select name="searchSelect">
            <option disabled selected>전체</option>
            <option value="title">도서명</option>
            <option value="catalogue">도서분류</option>
            <option value="author">저자</option>
        </select>
        <input type="text" name="searchText">
        <input type="submit" value="검색">
    </form>
    <table border="1">
        <tr>
            <th>도서번호</th>
            <th>도서명</th>
            <th>도서분류</th>
            <th>저자</th>
        </tr>
        
        <c:forEach items="${list}" var="book">
			<tr>
				<td class ="bookIsbn">${book.isbn}</td>
				<td class ="bookTitle">${book.title}</td>
				<td>${book.catalogue}</td>
				<td>${book.author}</td>
			</tr>
		</c:forEach>
    </table>
    
    <div>
    	<span id ="detail"></span>
    </div>
    
    <div class="center">
    <a href="./book/Book.html">도서 등록</a>
    <a href="${pageContext.request.contextPath}/front.do?command=bookList">도서 목록</a>
	</div>
</body>
</html>