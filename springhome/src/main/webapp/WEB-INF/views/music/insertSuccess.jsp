<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="음원 등록 완료" name="title"/>
</jsp:include>

<div class="container-600 mt-40">
	<div class="row center">
		<h1>음원 등록 완료</h1>
	</div>
	<div class="row-center">
		<a href="/" class="btn btn-neutral">메인페이지</a>
		<a href="list" class="btn btn-neutral">목록보기</a>
	</div>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>