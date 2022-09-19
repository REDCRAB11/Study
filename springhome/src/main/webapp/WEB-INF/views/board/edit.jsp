<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="게시글 수정" name="title"/>
</jsp:include>

<div align="center">
	<h1>게시글 수정</h1>
	<form action="edit" method="post">
	<label for ="boardHead"></label>
		<select id="boardHead">
		<option vlaue="">--------말머리 선택--------</option>
		<option vlaue="공지">공지</option>
		<option vlaue="유머">유머</option>
		<option vlaue="정보">정보</option>
		</select>
		<br><br>
		<input type="text" name="boardTitle" value="${dto.boardTitle}" placeholder="제목"><br><br>
		<input type="text" name="boardContent" value="${dto.boardContent}"placeholder="내용"><br><br>
		<button type="submit">변경</button>
	</form>
</div>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>