<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="비밀번호 변경" name="title"/>
</jsp:include>

<form action="password" method="post">

<div class="container-400 mt-40">
	<div class="row center">
		<h1>비밀번호 변경</h1>
	</div>
	
	<div class="row left">
		<label>기존 비밀번호</label>
		<input class="input w-100" type="password" name="beforePw" required>	
	</div>
	
	<div class="row left">
		<label>변경할 비밀번호</label>
		<input class="input w-100" type="password" name="afterPw" required>
	</div>
	
	<div class="row right">
		<a href="mypage" class="btn btn-neutral">마이페이지</a>
		<button class="btn btn-negative" type="submit">변경하기</button>
	</div>
</div>


	
</form>

<c:if test="${param.error != null}">
	<h2 style="color:red;">비밀번호가 잘못 작성되었습니다</h2>
</c:if>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>