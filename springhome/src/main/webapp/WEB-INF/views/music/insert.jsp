<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="음원 등록" name="title"/>
</jsp:include>

<form action="insert" method="post">
<div class="container-500 mt-40">
	<div class="row center">
		<h1>음원 정보 입력</h1>
	</div>
	<div class="row left">
		<label>제목</label>
		<input class="input w-100" name="musicTitle" type="text" required autocomplete="off">
	</div>
	<div class="row left">
		<label>가수</label>
		<input class="input w-100" name="musicArtist" type="text" required>
	</div>
	<div class="row left">
		<label>앨범</label>
		<input class="input w-100" name="musicAlbum" type="text" required autocomplete="off">
	</div>
	<div class="row left">
		<label>발매일</label>
		<input class="input w-100" name="releaseTime" type="date" required autocomplete="off">
	</div>
	<div class="row right">
		<a class="btn btn-neutral" href="list">목록</a>
		<button class="btn btn-positive" type="submit">등록</button>
	</div>
</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>