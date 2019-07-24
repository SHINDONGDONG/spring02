<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/menu.jsp" %>

<h2>게시글 작성화면</h2>
<form name="form1" method="post" action="${path}/board/write.do">
<table border="1px">
	<tr>
		<td>제목</td>
		<td><input type="text" name="title"></td>
	</tr>
	<tr>
		<td>작성자</td>
		<c:choose>
			<c:when test="${sessionScope.userid !=null }">
				<td><input type="text" name="writer" readonly value="${sessionScope.userid }"></td>
			</c:when>
			<c:otherwise>
				<td><input type="text" name="writer"></td>
			</c:otherwise>
		</c:choose>
	</tr>
	<tr>
		<td>내용</td>
		<td>
			<textarea rows="30" cols="50" name="content"></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		 	<input type="submit" value="확인">
		</td>
	</tr>
</table>
</form>
</body>
</html>