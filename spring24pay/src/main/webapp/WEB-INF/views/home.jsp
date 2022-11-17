<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>결제 테스트</h1>

<!-- 로그인/로그아웃 화면 -->
<c:choose>
	<c:when test="${loginId == null}">
		<form action="login" method="post">
			<input type="text" name="memberId">
			<input type="password" name="memberPw">
			<button type="submit">로그인</button>
		</form>
	</c:when>
	<c:otherwise>
		<h2><a href="logout">로그아웃</a></h2>
	</c:otherwise>
</c:choose>

<!-- 상태 판정 출력 -->
<h2>아이디 : ${loginId}</h2>
<h2>닉네임 : ${loginNick}</h2>
<h2>권한 : ${loginAuth}</h2>

<hr>

<h2><a href="pay1">1번 방식 결제</a></h2>
<h2><a href="pay2">2번 방식 결제</a></h2>

