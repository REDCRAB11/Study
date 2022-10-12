<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="자유 게시판" name="title"/>
</jsp:include>

<form action="edit" method="post">
<!-- input[type=hidden]은 form 안에 위치해야 한다 -->
<input type="hidden" name="boardNo" value="${boardDto.boardNo}">

<div class="container-800 mt-40">
	<div class="row center">
		<h1>게시글 수정</h1>
	</div>
	
	<div class="row left">
		<label>말머리</label>
		<select class="input w-100" name="boardHead">
			<option value="">선택</option>
			<option <c:if test="${boardDto.boardHead == '정보'}">selected</c:if>>정보</option>
			<option <c:if test="${boardDto.boardHead == '유머'}">selected</c:if>>유머</option>
			
			<c:if test="${mg == '관리자'}">
			<option <c:if test="${boardDto.boardHead == '공지'}">selected</c:if>>공지</option>
			</c:if>
		</select>
	</div>
	
	<div class="row left">
		<label>제목</label>
		<input class="input w-100" type="text" name="boardTitle" required value="${boardDto.boardTitle}" autocomplete="off">
	</div>
	
	<div class="row left">
		<label>내용</label>
		<!-- 
			textarea는 value 속성이 없고 시작태그와 종료태그 사이에 작성
			(주의) pre 태그와 동일하므로 엔터나 띄어쓰기 조심
		-->
		<textarea class="input w-100" name="boardContent" rows="10" 
				required>${boardDto.boardContent}</textarea>
	</div>
	
	<div class="row right">
		<a class="btn btn-neutral" href="list">목록으로</a>
		<button class="btn btn-positive" type="submit">수정하기</button>
	</div>
</div>

</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>