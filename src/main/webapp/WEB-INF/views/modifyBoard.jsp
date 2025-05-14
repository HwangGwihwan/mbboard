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
			if ($('#boardTitle').val().length < 1) {
				alert('제목을 입력하세요');
				return;
			}
			
			if ($('#boardContent').val().length < 1) {
				alert('내용을 입력하세요');
				return;
			}
			
			if ($('#boardUser').val().length < 1) {
				alert('사용자를 입력하세요');
				return;
			}
			
			$('#modifyForm').submit();
		});
	});
</script>
</head>
<body>
<h1>modifyBoard</h1>
	<form id="modifyForm" action="/modifyBoard" method="post">
		<table border="1">
			<tr>
				<th>번호</th>
				<td>
					<input type="text" name="boardNo" value="${board.boardNo}" readonly="readonly">
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" id="boardTitle" name="boardTitle" value="${board.boardTitle}">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="5" cols="50" id="boardContent" name="boardContent">${board.boardContent}</textarea>
				</td>
			</tr>
			<tr>
				<th>사용자</th>
				<td>
					<input type="text" id="boardUser" name="boardUser" value="${board.boardUser}">
				</td>
			</tr>
		</table>
		<button type="button" id="btn">수정</button>
	</form>
</body>
</html>