<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="include/header.jsp"%>
</head>
<body>
<%@include file="include/menu.jsp"%>
<h1>

<c:if test="${sessionScope.userid != null }">
	<h2>
		${sessionScope.name}(${userid})
		님의 방문을 환영합니다.
	</h2>
</c:if>

<!-- 배포디렉토리를 알수잇는경로 -->
<%=application.getRealPath("/") %>
</h1>

</body>
</html>