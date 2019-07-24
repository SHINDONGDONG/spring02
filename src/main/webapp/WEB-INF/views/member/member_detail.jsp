<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>

<script>
	$(function(){
		$("#btnModify").click(function(){
			document.form1.action="${path}/member/update.do";
			document.form1.submit();
			
		});
		$("#btnDelete").click(function(){
			if(confirm("삭제하시겠습니까?")){
			document.form1.action="${path}/member/delete.do";
			document.form1.submit();
			}
		});
	});
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>회원정보</h2>
<form id="form1" name="form1" method="post" >
<table border="1px" width="400">
	<tr>
		<td>
		아이디 : <input value="${dto.userid}" name="userid" readonly>      
		</td>
	</tr>
	<tr>
	<tr>
		<td>
		이름 : <input value="${dto.name}" name="name">
		</td>
	</tr>
	<tr>
		<td>
		패스워드 : <input type="password" name="passwd">
		</td>
	</tr>
		<td>
		이메일 : <input value="${dto.email}" name="email">
		</td>
	</tr>
	<tr>
		<td>
		작성날짜 : <fmt:formatDate value="${dto.join_date}"
		pattern="yyyy-MM-dd HH:mm:ss" />
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="button" id="btnModify" value="수정">
		<input type="button" id="btnDelete" value="삭제">
		<div style="color:red;">${message}</div>
		</td>
	</tr>
</table>
</form>

</body>
</html>