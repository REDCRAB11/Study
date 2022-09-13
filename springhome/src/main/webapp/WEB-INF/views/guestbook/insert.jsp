<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="방명록 작성" name="title"/>
</jsp:include>

<h1>방명록 작성</h1>
<form action="insert" method="post">
	<input name="name" placeholder="이름" required type="text"><br><br>
	<input name="memo" placeholder="내용" required type="text"><br><br>
	<button>작성</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>