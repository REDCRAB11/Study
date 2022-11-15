<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>웹 소켓 예제 모음</h1>

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


<!-- 모든 예제로 이동할 수 있는 링크 -->
<h2><a href="basic">기본연결</a></h2>
<h2><a href="multiple">다중사용자</a></h2>
<h2><a href="message">텍스트메세지</a></h2>
<h2><a href="json">JSON메세지</a></h2>
<h2><a href="sockjs">SockJS</a></h2>
<h2><a href="member">회원전용</a></h2>
<h2><a href="">그룹채팅</a></h2>