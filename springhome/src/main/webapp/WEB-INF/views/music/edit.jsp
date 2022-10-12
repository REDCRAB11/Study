<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="음원 정보 수정" name="title"/>
</jsp:include>

<form action="edit" method="post">
<input type="hidden" name="musicNo" value="${musicDto.musicNo}">

<div class="container-500 mt-40">
	<div class="row center">
		<h1>음원 정보 수정</h1>
	</div>
	
	<div class="row center">
		<label>제목</label>
		<input class="input w-100" type="text" name="musicTitle" value="${musicDto.musicTitle}" autocomplete="off">
	</div>
	
	<div class="row left">
		<label>가수</label>
		<input class="input w-100" type="text" name="musicArtist" value="${musicDto.musicArtist}" autocomplete="off">
	</div>
	
	<div class="row left">
		<label>앨범</label>	
		<input class="input w-100" type="text" name="musicAlbum" value="${musicDto.musicAlbum}" autocomplete="off">
	</div>
	
	<div class="row left">
		<label>발매일</label>	
		<input class="input w-100" type="date" name="releaseTime" value="${musicDto.releaseTime}" autocomplete="off">
	</div>
	
	<div class="row right">
		<a class="btn btn-neutral" href="list">목록</a>
		<button class="btn btn-positive" type="submit">변경</button>
	</div>
</div>

</form>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>