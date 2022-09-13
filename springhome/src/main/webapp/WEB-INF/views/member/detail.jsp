<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${memberDto.memberId} 회원 정보</title>
</head>
<body>
	<div align="center">
		<h1>${memberDto.memberId} 회원 정보</h1>
		<table border="1" width="400">
			<tbody>
				<tr>
					<th width="25%">아이디</th>
					<td>${memberDto.memberId}</td>
				</tr>
				<tr>
					<th>닉네임</th>
					<td>${memberDto.memberNick}</td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td>${memberDto.memberBirth}</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>${memberDto.memberTel}</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>${memberDto.memberEmail}</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>
						<c:if test="${memberDto.memberPost != null}">
						[${memberDto.memberPost}]
						${memberDto.memberBaseAddress}
						${memberDto.memberDetailAddress}
						</c:if>
					</td>
				</tr>
				<tr>
					<th>포인트</th>
					<td>
						<fmt:formatNumber value="${memberDto.memberPoint}" pattern="#,##0"/> point
					</td>
				</tr>
				<tr>
					<th>권한</th>
					<td>
						${memberDto.memberGrade}
					</td>
				</tr>
				<tr>
					<th>가입일시</th>
					<td>
						<fmt:formatDate value="${memberDto.memberJoin}" pattern="y년 M월 d일 E a h시 m분 s초"/>
					</td>
				</tr>
				<tr>
					<th>로그인일시</th>
					<td>
						<fmt:formatDate value="${memberDto.memberLogin}" pattern="y년 M월 d일 E a h시 m분 s초"/>
					</td>
				</tr>
			</tbody>
		</table>
		
		<h2><a href="list">목록 보기</a></h2>
		<h2><a href="change?memberId=${memberDto.memberId}">정보 변경</a></h2>
		<h2><a href="exit?memberId=${memberDto.memberId}">회원 탈퇴</a></h2>
	</div>
</body>
</html>
