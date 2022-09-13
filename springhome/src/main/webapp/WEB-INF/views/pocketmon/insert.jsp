
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="포켓몬 등록" name="title"/>
</jsp:include>

<h1>포켓몬 등록</h1>
<form action="insert" method="post">
	<input type="number" name="no" required> <br><br>
	<input type="text" name="name" required> <br><br>
	<input type="text" name="type" required> <br><br>
	<button>등록</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>