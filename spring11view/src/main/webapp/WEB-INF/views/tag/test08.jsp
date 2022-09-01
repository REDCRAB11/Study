<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음악정보</title>
</head>
<body>

<!--  
		input 태그에 type 속성을 설정하면 입력창의 형태를 정할 수 있다. 
			- 설정하지 않는다면 기본 설정이 text로 작성된다.
			
			- number: 숫자 전용 입력
			- text: 일반 글자
			- date: 날짜
			- file: 파일 선택 
 -->

<h1>음원 페이지 등록</h1>

<form action="/music/insert">
노래 제목: <input name = "musicTitle"  type="text" required>  <br><br>
가수명: <input name = "musicArtist"  type="text" required>	<br><br>
앨범명: <input name = "musicAlbum" type="text" required>	<br><br>
발매일: <input name = "releaseTime"  type="date" required>	<br><br>
<button>등록</button>
</form>
</body>
</html>