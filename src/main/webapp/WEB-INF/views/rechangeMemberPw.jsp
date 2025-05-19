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
			if ($('#id').val().length < 1) {
				alert('아이디를 입력하세요');
				return;
			}
			
			if ($('#pw').val() != $('#memberPw').val()) {
				alert('비밀번호가 일치하지 않습니다');
				$('#pw').val('');
				return;
			}
			
			if ($('#changePw').val().length < 1) {
				alert('바꿀 비밀번호를 입력하세요');
				return;
			}
			
			$('#changeForm').submit();
			
		});
	});
</script>
</head>
<body>
	<h1>rechangeMemberPw</h1>
	<input type="hidden" id="memberPw" value="${member.memberPw}">
	<form id="changeForm" action="/changeMemberPw" method="post">
		<div>
			memberId <input type="text" id="id" name="memberId">
		</div>
		<div>
			메일로 받은 PW <input type="password" id="pw">
		</div>
		<div>
			변경할 PW <input type="password" id="changePw" name="memberPw">
		</div>
		<button type="button" id="btn">패스워드변경</button>
	</form>
	
	<!-- 
		update member
		set member_pw = reMemberPw
		where member_pw = memberPw
		and pwcktime is NOT NULL
		and TIMESTAMPDIFF(MINUTE, pwcktime, NOW()) < 11  
	-->
</body>
</html>