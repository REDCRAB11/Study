<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>가입 정보 입력</h1>
	<form action="join" method="post">
		<input name="memberId" placeholder="Id" type="text" required> <br><br>
		<input name="memberPw"  placeholder="Pw" type="password" required> <br><br>
		<input name="memberNick"  placeholder="닉네임" type="text" required> <br><br>
		<input name="memberBirth" type="date" required> <br><br>
		<input name="memberTel"  placeholder="전화번호" type="tel"> <br><br>
		<input name="memberEmail"  placeholder="이메일"  type="email"> <br><br>
		<input name="memberPost"  placeholder="우편번호"  type="text" maxlength="6" size="6"> <br><br>
		<input name="memberBaseAddress"  placeholder="주소" type="text"> <br><br>
		<input name="memberDetailAddress"  placeholder="상세주소"  type="text"> <br><br>
		<button>가입하기</button>
	</form>
</body>
</html>