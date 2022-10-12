<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/adminHeader.jsp">
	<jsp:param value="회원 정보 변경" name="title"/>
</jsp:include>

<form action="change" method="post">
<input type="hidden" name="memberId" value="${memberDto.memberId}">

<div class="container-600 mt-40">
	<div class="row center">
		<h1>회원 정보 변경</h1>
	</div>
	
	<div class="row left">
		<label>Nickname</label>
		<input class="input w-100" type="text" name="memberNick" value="${memberDto.memberNick}" required autocomplete="off">
	</div>
	
	<div class="row left">	
		<label>Birth</label>
		<input class="input w-100" type="date" name="memberBirth" value="${memberDto.memberBirth}" required autocomplete="off">
	</div>
	
	<div class="row left">
		<label>Phone No.</label>
		<input class="input w-100" type="tel" name="memberTel" value="${memberDto.memberTel}" autocomplete="off">
	</div>
	
	<div class="row left">
		<label>E-mail</label>
		<input class="input w-100" type="email" name="memberEmail" value="${memberDto.memberEmail}" autocomplete="off">
	</div>
	
	<div class="row left">
		<label>Address</label><br>
		<input type="text" name="memberPost" value="${memberDto.memberPost}" placeholder="우편번호" size="6" maxlength="6" autocomplete="off">
	</div>
	
	<div class="row left">
		<input class="input w-100" type="text" name="memberBaseAddress" value="${memberDto.memberBaseAddress}" placeholder="기본주소" autocomplete="off">
	</div>
	<div class="row left">
		<input class="input w-100" type="text" name="memberDetailAddress" value="${memberDto.memberDetailAddress}" placeholder="상세주소" autocomplete="off">
	</div>
	
	<div class="row left">
		<label>Point</label>
		<input class="input w-100" type="number" name="memberPoint" value="${memberDto.memberPoint}" autocomplete="off">
	</div>
	
	<div class="row left">
		<label>등급</label>
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
	</div>
	
	<div class="row center">
		<button class="btn btn-negative w-100" type="submit">수정</button>
	</div>
</div>

</form>

<jsp:include page="/WEB-INF/views/template/adminFooter.jsp"></jsp:include>
