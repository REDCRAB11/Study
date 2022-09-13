<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 변경</title>
</head>
<body>
	<div align="center">
		<h1>회원 정보 변경</h1>
		
		<form action="change" method="post">
			<input type="hidden" name="memberId" value="${memberDto.memberId}">
<%-- 			<input type="password" name="memberPw" value="${memberDto.memberPw}"><br><br> --%>
			닉네임 : <input type="text" name="memberNick" value="${memberDto.memberNick}" required><br><br>
			생년월일 : <input type="date" name="memberBirth" value="${memberDto.memberBirth}" required><br><br>
			전화번호 : <input type="tel" name="memberTel" value="${memberDto.memberTel}"><br><br>
			이메일 : <input type="email" name="memberEmail" value="${memberDto.memberEmail}"><br><br>
			주소 : <input type="text" name="memberPost" value="${memberDto.memberPost}" placeholder="우편번호" size="6" maxlength="6"><br><br>
			<input type="text" name="memberBaseAddress" value="${memberDto.memberBaseAddress}" placeholder="기본주소"><br><br>
			<input type="text" name="memberDetailAddress" value="${memberDto.memberDetailAddress}" placeholder="상세주소"><br><br>
			포인트 : <input type="number" name="memberPoint" value="${memberDto.memberPoint}"><br><br>
			등급 : 
			<c:choose>
				<c:when test="${memberDto.memberGrade == '일반'}">
					<input type="radio" name="memberGrade" value="일반" checked> 일반
				</c:when>
				<c:otherwise>
					<input type="radio" name="memberGrade" value="일반"> 일반
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${memberDto.memberGrade == 'VIP'}">
					<input type="radio" name="memberGrade" value="VIP" checked> VIP
				</c:when>
				<c:otherwise>
					<input type="radio" name="memberGrade" value="VIP"> VIP	
				</c:otherwise>
			</c:choose>
			<br><br>
			<button type="submit">수정</button>
		</form>
	</div>
</body>
</html>
