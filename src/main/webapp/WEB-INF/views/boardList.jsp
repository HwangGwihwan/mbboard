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
		$('#searchBtn').click(function() {
			$('#searchForm').submit();
		});
	});
</script>
</head>
<body>
	<h1>boardList</h1>
	<div>
		<a href="/insertBoard">추가</a>
	</div>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
		</tr>
		<c:forEach var="list" items="${boardList}"> 
			<tr>
				<td>${list.boardNo}</td>
				<td>
					<a href="/boardOne?boardNo=${list.boardNo}">${list.boardTitle}</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<div>
		<a href="/boardList?currentPage=1&searchWord=${page.searchWord}">처음</a>
		
		<c:if test="${page.currentPage > 1}">
			<a href="/boardList?currentPage=${page.currentPage - 1}&searchWord=${page.searchWord}">이전</a>
		</c:if>
		
		<span>${page.currentPage} / ${page.lastPage}</span>
		
		<c:if test="${page.currentPage < page.lastPage}">
			<a href="/boardList?currentPage=${page.currentPage + 1}&searchWord=${page.searchWord}">다음</a>
		</c:if>
		
		<a href="/boardList?currentPage=${page.lastPage}&searchWord=${page.searchWord}">마지막</a>
	</div>
	
	<div>
		<form id="searchForm" action="/boardList" method="get">
			<input type="text" id="searchWord" name="searchWord" value="${page.searchWord}">
			<button type="button" id="searchBtn">검색</button>
		</form>
	</div>
</body>
</html>