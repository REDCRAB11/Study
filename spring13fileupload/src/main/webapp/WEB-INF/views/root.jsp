<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>파일 업로드 테스트</h1>

<!-- 
	파일 업로드 화면을 구현할 때 알아야 할 점
	- 기존 방식(GET/POST 무관)으로는 파일명만 전송
	- form에 post방식 + enctype="multipart/form-data"로 설정
	- 절취선이 생기면서 파일의 여러 정보가 하나의 구역에 담겨 전송
 -->

<h1>DB없이 업로드</h1>

<!-- <form action="/" method="get"> -->
<!-- <form action="/" method="post"> -->
<form action="/" method="post" enctype="multipart/form-data">
	
	<input type="text" name="uploader">
	<br><br>
	<input type="file" name="attachment">
	<br><br>
	<button type="submit">업로드</button>
	
</form>

<h1>DB 사용하는 업로드</h1>

<form action="/upload" method="post" enctype="multipart/form-data">
	<input type="file" name="attachment">
	<button type="submit">등록</button>
</form>

<h1><a href="list">파일 목록 보기</a></h1>
