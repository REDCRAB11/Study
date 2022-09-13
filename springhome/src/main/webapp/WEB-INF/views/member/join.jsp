<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="회원 가입" name="title"/>
</jsp:include>


<h1>가입 정보 입력</h1>
<form action="join" method="post">
	ID : <input name="memberId" type="text" required> <br><br>
	Password : <input name="memberPw" type="password" required> <br><br>
	Nickname : <input name="memberNick" type="text" required> <br><br>
	생년월일 : <input name="memberBirth" type="date" required> <br><br>
	전화번호 : <input name="memberTel" type="tel"> <br><br>
	이메일 : <input name="memberEmail" type="email"> <br><br>
	우편번호 : <input name="memberPost" type="text" maxlength="6" size="6"> <br><br>
	기본주소 : <input name="memberBaseAddress" type="text"> <br><br>
	상세주소 : <input name="memberDetailAddress" type="text"> <br><br>
	<button>가입하기</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
