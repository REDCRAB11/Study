<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="회원 탈퇴" name="title"/>
</jsp:include>
<body>
<h1>탈퇴하시겠습니까?</h1>
<form action = "goodbye" method="post">
	비밀번호 확인 : <input type="password" name="memberPw" required><br><br>
	<button type="submit">변경하기</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>