<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>

<!-- 테이블  헤드나 풋은 없어도 되나 바디는 꼭 있어야한다! -->
<!-- < 옵션 value =" 전송할 값" > 보여줄 값 </옵션> -->


	<div align="center">
		<!-- 제목 -->
		<h1>회원 조회</h1>
		
		<!-- 검색창 -->
		<form action="list" method="get">
		
			<%-- 
				c:if는 단일 조건을, c:choose는 그룹 조건을 구현할 수 있다
				- el에서는 모든 데이터가 비교 연산으로 비교가 가능하다
				- 따옴표 1개와 2개를 구분하지 않는다 
			--%>
			<c:choose>
				<c:when test="${param.type == 'member_nick'}">
					<select name="type" required>
						<option value="member_id">아이디</option>
						<option value="member_nick" selected>닉네임</option>
						<option value="member_tel">전화번호</option>
						<option value="member_email">이메일</option>
						<option value="member_grade">등급</option>
					</select>
				</c:when>
				<c:when test="${param.type == 'member_tel'}">
					<select name="type" required>
						<option value="member_id">아이디</option>
						<option value="member_nick">닉네임</option>
						<option value="member_tel" selected>전화번호</option>
						<option value="member_email">이메일</option>
						<option value="member_grade">등급</option>
					</select>
				</c:when>
				<c:when test="${param.type == 'member_email'}">
					<select name="type" required>
						<option value="member_id">아이디</option>
						<option value="member_nick">닉네임</option>
						<option value="member_tel">전화번호</option>
						<option value="member_email" selected>이메일</option>
						<option value="member_grade">등급</option>
					</select>
				</c:when>
				<c:when test="${param.type == 'member_grade'}">
					<select name="type" required>
						<option value="member_id">아이디</option>
						<option value="member_nick">닉네임</option>
						<option value="member_tel">전화번호</option>
						<option value="member_email">이메일</option>
						<option value="member_grade" selected>등급</option>
					</select>
				</c:when>
				<c:otherwise>
					<select name="type" required>
						<option value="member_id" selected>아이디</option>
						<option value="member_nick">닉네임</option>
						<option value="member_tel">전화번호</option>
						<option value="member_email">이메일</option>
						<option value="member_grade">등급</option>
					</select>
				</c:otherwise>
			</c:choose>
			
			<!--파라미터에 접근할 경우 param 키워드를 사용한다 -->
			<input type="search" name="keyword" required value="${param.keyword}">
			
			<!-- 
				button은 type을 submit(전송용버튼), 
				button(일반버튼)으로 설정할 수 있다 
			-->
			<button type="submit">검색</button>
		</form>
		
		<br><br>
		
		<!-- 테이블 -->
		<table border="1" width="900">
			<thead>
				<tr>
					<th>아이디</th>
					<th>닉네임</th>
					<th>생년월일</th>
					<th>전화번호</th>
					<th>이메일</th>
					<th>등급</th>
					<th>포인트</th>
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach var="memberDto" items="${list}">
				<tr>
					<td>${memberDto.memberId}</td>
					<td>${memberDto.memberNick}</td>
					<td>${memberDto.memberBirth}</td>
					<td>${memberDto.memberTel}</td>
					<td>${memberDto.memberEmail}</td>
					<td>${memberDto.memberGrade}</td>
					<td>
					<a href = "detail?memberPoint=${dto.memberPoint}"></a>
					${memberDto.memberPoint}</td>
				</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6" align="right">
						총 ${list.size()}개의 결과
					</td>				
				</tr>
			</tfoot>
		</table>
		
		<h2><a href="/">메인 페이지로 돌아가기</a></h2>
		
	</div>
</body>
</html>