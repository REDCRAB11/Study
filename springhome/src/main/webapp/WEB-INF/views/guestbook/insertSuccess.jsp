
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="방명록 작성 완료" name="title"/>
</jsp:include>

<h1>방명록 작성이 완료되었습니다</h1>
<h2><a href="/">메인페이지로 이동</a></h2>
<h2><a href="list">방명록 보러가기</a></h2>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>