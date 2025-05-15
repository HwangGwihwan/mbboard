<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(function() {
		$('#btn').click(function() {
			if ($('#pw').val().length < 1) {
				alert('기존 비밀번호를 입력하세요');
				return;
			}
			
			if ($('#pw').val() != $('#memberPw').val()) {
				alert('기존 비밀번호가 일치하지 않습니다');
				$('#pw').val('');
				return;
			}
			
			if ($('#changePw').val().length < 1) {
				alert('바꿀 비밀번호를 입력하세요');
				return;
			}
			
			$('#updateForm').submit();
			
		});
	});
</script>
</head>
<body>
	<form id="updateForm" action="/member/changePw" method="post">
		<input type="hidden" id="memberId" name="memberId" value="${member.memberId}">
		<input type="hidden" id="memberPw" value="${member.memberPw}">
		<div>
			<div>기존 비밀번호:</div>
			<div><input type="password" id="pw"></div>
			<div>바꿀 비밀번호:</div>
			<div><input type="password" id="changePw" name="memberPw"></div>
			<div><button type="button" id="btn">비밀번호 변경</button></div>
		</div>
	</form>
</body>
</html>