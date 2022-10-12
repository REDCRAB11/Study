<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="회원 가입 완료" name="title"/>
</jsp:include>

<div class="container-600 mt-40">
	<div class="row center">
		<h1>회원 가입이 완료되었습니다</h1>
	</div>
	<div class="row center">
		<a href="/" class="btn btn-neutral w-100">메인페이지</a>
	</div>
	<div class="row center">
		<a href="login" class="btn btn-neutral w-100">로그인 하러가기</a>
	</div>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>