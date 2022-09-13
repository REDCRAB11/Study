<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="방명록 수정" name="title"/>
</jsp:include>

<div align="center">
	<h1>방명록 수정</h1>
	
	<form action="edit" method="post">
		<input type="hidden" name="no" required value="${dto.no}">
		작성자 : <input type="text" name="name" required value="${dto.name}"> <br><br>
		메모 : <input type="text" name="memo" required value="${dto.memo}"> <br><br>
		<button type="submit">수정하기</button>
	</form>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include> 