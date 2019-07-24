<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("UTF-8"); %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script>
	$(function(){
		$("#btnInsert").click(function(){
			location.href="${path}/board/insert.do";
		});
	});
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>게시판</h2>
<button type="button" id="btnInsert">게시글작성</button>
<table border="1" width="700px" >
	<tr> 
		<td>글번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성날짜</td>	
	</tr>
	<c:forEach var="row" items="${map.list}">
	<tr>
		<td>${row.bno}</td>
		<td><a href="${path}/board/detail/${row.bno}">${row.title}</a></td>
		<td>${row.writer}</td>
		<td><fmt:formatDate value="${row.regdate}"
		pattern="yyyy-MM-dd HH:mm:ss"/></td>
	</tr>
	</c:forEach>	
</table>
</body>
</html>