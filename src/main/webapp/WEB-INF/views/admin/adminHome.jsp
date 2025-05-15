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
	<h1>${loginMember.memberId} 관리자</h1>
	<div><a href="/logout">로그아웃</a></div>
	
	<h2>멤버리스트</h2>
	<table border="1">
	<!--
		회원가입 - AJax API 아이디 중복검사 후
		memberRole 수정
	 -->
	 	<tr>
			<th>ID</th>
			<th>Role</th>
			<th>변경</th>
		</tr>
	 
		<c:forEach var="member" items="${memberList}">
			<tr>
				<td>${member.memberId}</td>
				<td>${member.memberRole}</td>
				<td>
					<a href="/admin/changeRole?memberId=${member.memberId}">변경</a>
				</td>
			</tr>
		</c:forEach>
		
	 </table>
</body>
</html>