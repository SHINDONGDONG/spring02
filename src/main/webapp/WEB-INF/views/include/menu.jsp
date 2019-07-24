<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<div style="text-align:center">


	<a href="${path}/member/list.do">회원목록</a> |
	<a href="${path}/board/list.do">게시판</a> |
	
	<div style="text-align: right;">
	<c:choose>
		<c:when test="${sessionScope.userid ==null }">
			<a href="${path}/member/login.do">로그인</a> 
		</c:when>
		<c:otherwise>
			<a href="${path}/member/logout.do">로그아웃</a> 
		</c:otherwise>
	</c:choose>
	</div>
	
</div>
<hr>