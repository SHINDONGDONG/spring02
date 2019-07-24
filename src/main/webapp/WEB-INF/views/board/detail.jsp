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
			document.form1.action="${path}/board/update.do";
			document.form1.submit();
		});
		$("#btnDelete").click(function(){
			if(confirm("삭제할꺼야?")){
				document.form1.action="${path}/board/delete.do";
				document.form1.submit();
			}
			
		});
	});
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>상세화면</h2>
<form id="form1" name="form1" method="post" >
<table border="1px">
	<tr>
		<td>
		글번호 : <input value="${dto.bno}" name="bno" readonly>      
		</td>
	</tr>
	<tr>
		<td>
		작성자 : <input value="${dto.writer}" name="writer">
		</td>
	</tr>
	<tr>
		<td>
		제목 : <input value="${dto.title}" name="title">
		</td>
	</tr>
	<tr>
		<td>
		작성날짜 : <fmt:formatDate value="${dto.regdate}"
		pattern="yyyy-MM-dd HH:mm:ss" />
		</td>
	</tr>
	<tr>
		<td>
		<textarea rows="30" cols="50" name="content">${dto.content}</textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="button" id="btnModify" value="수정">
		<input type="button" id="btnDelete" value="삭제">
		</td>
	</tr>
</table>
</form>

</body>
</html>