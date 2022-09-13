<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="음원 정보 수정" name="title"/>
</jsp:include>

<div align="center">
	<h1>음원 정보 수정</h1>
	<form action="edit" method="post">
		<input type="hidden" name="musicNo" value="${dto.musicNo}">
		<input type="text" name="musicTitle" value="${dto.musicTitle}"><br><br>
		<input type="text" name="musicArtist" value="${dto.musicArtist}"><br><br>
		<input type="text" name="musicAlbum" value="${dto.musicAlbum}"><br><br>
<%-- 			<input type="number" name="musicPlay" value="${dto.musicPlay}"><br><br> --%>
		<input type="date" name="releaseTime" value="${dto.releaseTime}"><br><br>
		<button type="submit">변경</button>
	</form>
</div>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>