<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(function() {
		$('#btn').click(function() {
			if ($('#memberId').val().length < 1) {
				alert('아이디를 입력하세요');
				return;
			}
			
			if ($('#memberPw').val().length < 1) {
				alert('비밀번호를 입력하세요');
			}
			
			$('#loginForm').submit();
		});
	});
</script>
</head>
<body>
	<c:if test="${loginMember == null}">
		<!-- 로그인이 안되어 있다면 -->
		<form id="loginForm" action="/login" method="post">
			<div>
				<div>memberId:</div>
				<div><input type="text" id="memberId" name="memberId"></div>
				<div>memberPw:</div>
				<div><input type="password" id="memberPw" name="memberPw"></div>
				<div><button type="button" id="btn">로그인</button></div>
			</div>
		</form>
		<c:if test="${param.error == 'true'}">
		    <div style="color:red; margin-top:10px;">아이디 또는 비밀번호가 올바르지 않습니다.</div>
		</c:if>
		<div><a href="/joinMember">회원가입</a></div>
	</c:if>

	<c:if test="${loginMember != null}">
		<!-- 로그인 되어 있다면 -->
		<div>
			${loginMember.memberId}님 <a href="/member/info">memberInfo</a>으로 이동
		</div>
		<div><a href="/logout">로그아웃</a></div>
	</c:if>
	
</body>
</html>