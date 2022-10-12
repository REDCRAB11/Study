<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
 
<jsp:include page="/WEB-INF/views/template/adminHeader.jsp">
	<jsp:param value="회원 목록" name="title"/>
</jsp:include>
    
<div class="container-900 mt-40 mb-40">

	<!-- 제목 -->
	<div class="row center">
		<h1>회원 조회</h1>
	</div>
	
	<!-- 검색창 -->
	<div class="row center">
	<form action="list" method="get">
	
		<%-- 
			c:if는 단일 조건을, c:choose는 그룹 조건을 구현할 수 있다
			- el에서는 모든 데이터가 비교 연산으로 비교가 가능하다
			- 따옴표 1개와 2개를 구분하지 않는다 
		--%>
		<c:choose>
			<c:when test="${param.type == 'member_nick'}">
				<select class="input" name="type" required>
					<option value="member_id">아이디</option>
					<option value="member_nick" selected>닉네임</option>
					<option value="member_tel">전화번호</option>
					<option value="member_email">이메일</option>
					<option value="member_grade">등급</option>
				</select>
			</c:when>
			<c:when test="${param.type == 'member_tel'}">
				<select class="input" name="type" required>
					<option value="member_id">아이디</option>
					<option value="member_nick">닉네임</option>
					<option value="member_tel" selected>전화번호</option>
					<option value="member_email">이메일</option>
					<option value="member_grade">등급</option>
				</select>
			</c:when>
			<c:when test="${param.type == 'member_email'}">
				<select class="input" name="type" required>
					<option value="member_id">아이디</option>
					<option value="member_nick">닉네임</option>
					<option value="member_tel">전화번호</option>
					<option value="member_email" selected>이메일</option>
					<option value="member_grade">등급</option>
				</select>
			</c:when>
			<c:when test="${param.type == 'member_grade'}">
				<select class="input" name="type" required>
					<option value="member_id">아이디</option>
					<option value="member_nick">닉네임</option>
					<option value="member_tel">전화번호</option>
					<option value="member_email">이메일</option>
					<option value="member_grade" selected>등급</option>
				</select>
			</c:when>
			<c:otherwise>
				<select class="input" name="type" required>
					<option value="member_id" selected>아이디</option>
					<option value="member_nick">닉네임</option>
					<option value="member_tel">전화번호</option>
					<option value="member_email">이메일</option>
					<option value="member_grade">등급</option>
				</select>
			</c:otherwise>
		</c:choose>
		
		<!--파라미터에 접근할 경우 param 키워드를 사용한다 -->
		<input class="input" type="search" name="keyword" required value="${param.keyword}">
		
		<!-- 
			button은 type을 submit(전송용버튼), 
			button(일반버튼)으로 설정할 수 있다 
		-->
		<button class="btn btn-positive" type="submit">검색</button>
	</form>
	</div>
	
	<!-- 테이블 -->
	<div class="row">
	<table class="table table-border table-stripe">
		<thead>
			<tr>
				<th>아이디</th>
				<th>닉네임</th>
				<th>생년월일</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>등급</th>
				<th>메뉴</th>
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
					<a class="btn btn-neutral" style="padding:5px;" href="detail?memberId=${memberDto.memberId}">상세</a>
					<a class="btn btn-neutral" style="padding:5px;" href="change?memberId=${memberDto.memberId}">수정</a>
					<a class="btn btn-neutral" style="padding:5px;" href="exit?memberId=${memberDto.memberId}">탈퇴</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="7" align="right">
					총 ${list.size()}개의 결과
				</td>				
			</tr>
		</tfoot>
	</table>
	</div>
	
	<div class="row center">
		<ul class="pagination">
			<li><a href="#">&laquo;</a></li>
			<li><a href="#">&lt;</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">6</a></li>
			<li><a href="#">7</a></li>
			<li><a href="#">8</a></li>
			<li><a href="#">9</a></li>
			<li><a href="#">10</a></li>
			<li><a href="#">&gt;</a></li>
			<li><a href="#">&raquo;</a></li>
		</ul>
	</div>
	
	<div class="row">
		<a href="/" class="btn btn-neutral">메인 페이지로 돌아가기</a>
	</div>
	
</div>

<jsp:include page="/WEB-INF/views/template/adminFooter.jsp"></jsp:include>

