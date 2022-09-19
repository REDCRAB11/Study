<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="등록" name="title"/>
</jsp:include>
<h1>글 작성 등록하기</h1>
	<form action="write" method="post">
		<label for ="boardHead"></label>
		<select id="boardHead">
		<option value="">--------말머리 선택--------</option>
		<option value="공지">공지</option>
		<option value="유머">유머</option>
		<option value="정보">정보</option>
		</select>
	<br><br>
		<input name = "boardWriter" placeholder="작성자" type="text" required><br><br>
		<input name = "boardTitle" placeholder="제목" type="text" required><br><br>
		<input name = "boardContent" placeholder="내용" type="text" required><br><br>
		<button>등록</button>
	</form>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>