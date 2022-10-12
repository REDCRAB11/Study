<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="회원 가입" name="title"/>
</jsp:include>

<form action="join" method="post" enctype="multipart/form-data">
<div class="container-600 mt-40">
	<div class="row center">
		<h1>가입 정보 입력</h1>
	</div>
	
	<div class="row left">
		<label>ID</label>
		<input class="input w-100" name="memberId" type="text" required autocomplete="off">
	</div>	
	
	<div class="row left">
		<label>Password</label>
		<input class="input w-100" name="memberPw" type="password" required>
	</div>
	
	<div class="row left">
		<label>Nickname</label>
		<input class="input w-100" name="memberNick" type="text" required autocomplete="off">
	</div>
	
	<div class="row left">
		<label>Birth</label>
		<input class="input w-100" name="memberBirth" type="date" required autocomplete="off">
	</div>
	
	<div class="row left">
		<label>Phone No.</label>
		<input class="input w-100" name="memberTel" type="tel" autocomplete="off">
	</div>
	
	<div class="row left">
		<label>E-mail</label>	
		<input class="input w-100" name="memberEmail" type="email" autocomplete="off">
	</div>
	
	<div class="row left">
		<label>Address</label>
		<br>
		<input class="input" name="memberPost" type="text" maxlength="6" size="6" placeholder="우편번호" autocomplete="off">
		<button class="btn btn-neutral">검색</button>
	</div>
	
	<div class="row left">
		<input class="input w-100" placeholder="기본주소" name="memberBaseAddress" type="text" autocomplete="off">
	</div>
	<div class="row left">
		<input class="input w-100" placeholder="상세주소" name="memberDetailAddress" type="text" autocomplete="off">
	</div>
	
	<div class="row left">
		<label>Profile image</label>
		<input class="input w-100" type="file" name="memberProfile" accept=".png, .jpg">
	</div>
	
	<div class="row left">
		<button class="btn btn-positive w-100">가입하기</button>
	</div>
</div>

</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>