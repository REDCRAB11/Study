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
		<input name="memberId" type="text" required> <br><br>
		<input name="memberPw" type="password" required> <br><br>
		<input name="memberNick" type="text" required> <br><br>
		<input name="memberBirth" type="date" required> <br><br>
		<input name="memberTel" type="tel"> <br><br>
		<input name="memberEmail" type="email"> <br><br>
		<input name="memberPost" type="text" maxlength="6" size="6"> <br><br>
		<input name="memberBaseAddress" type="text"> <br><br>
		<input name="memberDetailAddress" type="text"> <br><br>
		<button>가입하기</button>
	</form>
</body>
</html>