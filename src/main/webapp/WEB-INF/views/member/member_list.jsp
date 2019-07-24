<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>

<script>
	$(function(){
		$("#btnCreate").click(function(){
			location.href="${path}/member/create.do";
		});
	});
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>

<h1>회원목록</h1>
<button type="button" name="btnCreate" id="btnCreate">회원가입</button>

<table border="1" width="700">
	<tr>
		<td>아이디</td>
		<td>이름</td>
		<td>이메일</td>
		<td>가입날짜</td>
	</tr>
	<c:forEach var="row" items="${list}">
	<tr>
		<td>${row.userid}</td>
		<td>
		<a href="${path}/member/detail.do?userid=${row.userid}">${row.name}</a>
		</td>
		<td>${row.email}</td>
		<td>
		<fmt:formatDate value="${row.join_date}"
		 pattern="yyyy-MM-dd HH:mm:ss"/>
		 </td>
	</tr>
	</c:forEach>

</table>


</body>
</html>