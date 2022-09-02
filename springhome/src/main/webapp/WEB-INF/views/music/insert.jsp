<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>음원 정보</h1>
		<form action = "insert" method ="post">
			<input type = "text" name = "musicTitle" placeholder="타이틀" required> <br><br>
			<input type = "text" name = "musicArtist" placeholder="가수명" required> <br><br>
			<input type = "text" name = "musicAlbum" placeholder="앨범명" required> <br><br>
			<input type = "date" name = "releaseTime" placeholder="발매일" required> <br><br>
		<button>등록</button>
		
		</form>
</body>
</html>