<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script>
	$(function(){
		$("#btnLogin").click(function(){
			var userid =$("#userid").val();
			var passwd =$("#passwd").val();
			if(userid ==""){
				alert("아이디를 입력해주세요");
				$("#userid").focus();
				return;
			}
			if(passwd ==""){
				alert("비밀번호를 입력해주세요.");
				$("#passwd").focus();
				return;
			}
			document.form1.action="${path}/member/login_check.do";
			document.form1.submit();
		});
	});
</script>

</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2 align="center">로그인</h2>

<form name="form1" method="post" >
	<table border="1" align="center">
		<tr>
			<td>아이디</td>
			<td><input id="userid" name="userid" ></td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td><input id="passwd" type="password" name="passwd"></td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<button type="button" id="btnLogin">로그인</button>
					<c:if test="${message =='error'}">
						<div style="color:red;">아이디 혹은 비밀번호를 틀렸습니다.</div>
					</c:if>
					<c:if test="${message =='logout' }">
						<div style="color:red;">로그아웃 되었습니다.</div>
					</c:if>
					
			</td>
		</tr>
	</table>
</form>

</body>
</html>