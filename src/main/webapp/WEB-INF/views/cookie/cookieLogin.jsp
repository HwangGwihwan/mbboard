<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>cookieLogin</h1>
	<form action="/cookieLogin" method="post">
		<div>
			<div>memberId:</div>
			<div>
				<input type="text" id="memberId" name="memberId" value="${cookie.saveId.value}">
				<input type="checkbox" value="yes" name="saveIdCk">아이디 저장
			</div>
			<div>memberPw:</div>
			<div><input type="password" id="memberPw" name="memberPw"></div>
			<div><button type="submit">로그인</button></div>
		</div>
	</form>
	<c:if test="${param.error == 'true'}">
	    <div style="color:red; margin-top:10px;">아이디 또는 비밀번호가 올바르지 않습니다.</div>
	</c:if>
	<div><a href="/joinMember">회원가입</a></div>
	
</body>
</html>