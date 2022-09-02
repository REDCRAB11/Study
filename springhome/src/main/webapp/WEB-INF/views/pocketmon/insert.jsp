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
		<input type = "number" name="no" required> <br><br>
		<input type="text" name = "name" required> <br><br>
		<input type="text" name="type" required> <br><br>
		<button>등록</button>
		
		</form>
</body>
</html>