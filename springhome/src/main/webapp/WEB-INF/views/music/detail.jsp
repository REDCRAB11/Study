<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음원 상세정보</title>
</head>
<body>
	<div align="center">
		<h1>음원 상세정보</h1>
		<table border="1" width="400">
			<tbody>
				<tr>
					<th width="25%">번호</th>
					<td>${dto.musicNo}</td>
				</tr>
				<tr>
					<th width="25%">제목</th>
					<td>${dto.musicTitle}</td>
				</tr>
				<tr>
					<th width="25%">가수</th>
					<td>${dto.musicArtist}</td>
				</tr>
				<tr>
					<th width="25%">앨범</th>
					<td>${dto.musicAlbum}</td>
				</tr>
				<tr>
					<th width="25%">재생수</th>
					<td>${dto.musicPlay}</td>
				</tr>
				<tr>
					<th width="25%">발매일</th>
<%-- 			<td>${musicDto.releaseTime}</td> --%>
					<td>
						<fmt:formatDate value="${dto.releaseTime}" pattern="y년 M월 d일 E요일"/>
					</td>
				</tr>
			</tbody>
		</table>
		
		<h2><a href="list">목록보기</a></h2>
	</div>
</body>
</html>