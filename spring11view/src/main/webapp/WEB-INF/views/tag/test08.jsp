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
 
 <!--  *중요* form은 전송방식(GET/POST)을 선택할 수 있다.
 			- method라는 속성에 값을 설정한다.  
 			
 			GET방식 
 			- 주소만으로 요청하는 방식
 			- 데이터도 주소에 첨부해야 한다. 
 			- 주소에 첨부하면 데이터가 쉽게 노출되며, 주소는 256byte 제한이 있다. 
 			- 모든 서버에 접근이 가능하다. 
 			
 			POST방식
 			- 주소와 데이터를 따로 요청하는 방식 
 			- 데이터는 별도의 영역에 보관되어 전송된다. 
 			- 데이터가 주소에 노출되지 않으며, 무제한 전송이 가능하다. 
 			- 데이터 전송에 특화된 방식 
  -->

<h1>음원 페이지 등록</h1>

<form action="/music/insert" method="post">
노래 제목: <input name = "musicTitle"  type="text" required>  <br><br>
가수명: <input name = "musicArtist"  type="text" required>	<br><br>
앨범명: <input name = "musicAlbum" type="text" required>	<br><br>
발매일: <input name = "releaseTime"  type="date" required>	<br><br>
<button>등록</button>
</form> 
</body>
</html>