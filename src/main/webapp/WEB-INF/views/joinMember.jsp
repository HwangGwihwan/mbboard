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
		let isIdChecked = false;
		$('#idCheck').click(function() {
			$.ajax({
				url:'/idCheck/' + $('#memberId').val()
				, type:'get'
				, success: function(data) {
					if (data == true) {
						alert('이미 사용중인 아이디 입니다.');
						$('#memberId').val('');
						isIdChecked = false;
					} else {
						alert('사용 가능한 아이디 입니다.');
						isIdChecked = true;
					}
				}
			});
		});
		
		$('#memberId').on('input', function() {
	        isIdChecked = false;
	    });

		$('#btn').click(function() {
			if ($('#memberId').val().length < 1) {
				alert('아이디를 입력하세요');
				return;
			}
			
			if (!isIdChecked) {
				alert('아이디 중복검사를 먼저 해주세요');
				return;
			}
			
			if ($('#memberPw').val().length < 1) {
				alert('비밀번호를 입력하세요');
				return;
			}
			
			$('#joinForm').submit();
		});
	});
</script>
</head>
<body>
	<h1>회원가입</h1>
	
	<form id="joinForm" action="/joinMember" method="post">
		<div>
			<div>memberId:</div>
			<div>
				<input type="text" id="memberId" name="memberId">
				<button type="button" id="idCheck">중복검사</button>
			</div>
			<div>memberPw:</div>
			<div><input type="password" id="memberPw" name="memberPw"></div>
			<div><button type="button" id="btn">회원가입</button></div>
		</div>
	</form>
</body>
</html>