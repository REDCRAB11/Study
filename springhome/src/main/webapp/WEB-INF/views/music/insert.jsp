<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="음원 등록" name="title"/>
</jsp:include>

<h1>음원 정보 입력</h1>
<form action="insert" method="post">
	제목 <input name="musicTitle" type="text" required> <br><br>
	가수 <input name="musicArtist" type="text" required> <br><br>
	앨범 <input name="musicAlbum" type="text" required> <br><br>
	발매일 <input name="releaseTime" type="date" required> <br><br>
	<button>등록</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>