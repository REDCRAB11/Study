<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 수정</title>
</head>
<body>
<div align="center">
	<h1>방명록 수정</h1>
		<form action= "edit" method="post">
			<input name = "no" required value="${dto.no}" type="hidden">
			<input name = "name"  required value="${dto.name}"><br><br>
			<input name="memo"  required value="${dto.memo}"><br><br>
			<button>수정</button>
		</form>
		</div>
</body>
</html>