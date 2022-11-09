<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <h1>[나나드림] 이메일 인증</h1>
<form action="test3" method="get">
	<input type="hidden" name="who" value="${who}">
	인증번호: <input type="text" name="serial" required placeholder="인증번호 6자리를 입력해주세요.">
	<button type="submit">확인</button>
</form>
