<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="방명록 수정" name="title"/>
</jsp:include>

<form action="edit" method="post">
<input type="hidden" name="no" required value="${dto.no}">

<div class="container-500 mt-40">
	<div class="row center">
		<h1>방명록 수정</h1>
	</div>
	
	<div class="row left">
		<label>작성자</label>
		<input class="input w-100" type="text" name="name" required value="${dto.name}" autocomplete="off">
	</div>
	
	<div class="row left">
		<label>메모</label>
		<textarea name="memo" class="input w-100" rows="10" required>${dto.memo}</textarea>
	</div>
	
	<div class="row right">
		<a href="list" class="btn btn-neutral">목록</a>
		<button class="btn btn-negative" type="submit">수정</button>
	</div>
</div>

</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>    
 