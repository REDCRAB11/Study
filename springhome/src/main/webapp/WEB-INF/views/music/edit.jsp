<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="음악 정보" name="title"/>
	</jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음악 정보 수정</title>
</head>
<body>
	<div align = "center">
		<h1>음악 정보 수정</h1>
			<form action="edit" method="post">
				<input name = "musicNo" value = "${dto.musicNo}" type = "hidden">
				<input name = "musicTitle"  value="${dto.musicTitle }"><br><br>
				<input name = "musicArtist"  value="${dto.musicArtist }"><br><br>
				<input name = "musicAlbum"  value="${dto.musicAlbum }"><br><br>
				<input name = "musicPlay" value="${dto.musicPlay }"><br><br>
				<input type="date" name = "releaseTime"  value="${dto.releaseTime }"><br><br>
				<button>수정</button>
			</form>
	</div>
</body>
</html>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
