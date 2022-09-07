<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포켓몬 등록</title>
</head>
<body>
		<h1>포켓몬 등록</h1>
		<form action = "insert" method="post">
		<input type = "number" placeholder="번호" name="no" required> <br><br>
		<input type="text" placeholder="이름"  name = "name" required> <br><br>
		<input type="text"  placeholder="속성" name="type" required> <br><br>
		<button>등록</button>
		
		</form>
</body>
</html>