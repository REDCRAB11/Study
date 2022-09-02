<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
</head>
<body bgcolor="#F8DAE2">
		<h1>방명록</h1>
		<img src="/image/a.jpg" width="200">
		<form action = "insert" method="post">
		<input type = "text" name = "name" placeholder="이름" required> <br><br>
		<input type = "text" name="memo"  placeholder="메모 작성" required> <br><br>
		<button>등록</button>	
	<p>	<img src="/image/b.png" width="500" align="bottom"></p>
		</form>
</body>
</html>