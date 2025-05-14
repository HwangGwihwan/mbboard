<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>boardOne</h1>
	<table border="1">
		<tr>
			<th>번호</th>
			<td>${board.boardNo}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${board.boardTitle}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${board.boardContent}</td>
		</tr>
		<tr>
			<th>사용자</th>
			<td>${board.boardUser}</td>
		</tr>
		<tr>
			<th>수정날짜</th>
			<td>${board.updatedate}</td>
		</tr>
		<tr>
			<th>생성날짜</th>
			<td>${board.createdate}</td>
		</tr>
	</table>
	
	<div>
		<a href="/modifyBoard?boardNo=${board.boardNo}">수정</a>
		<a href="/deleteBoard?boardNo=${board.boardNo}">삭제</a>
	</div>
</body>
</html>