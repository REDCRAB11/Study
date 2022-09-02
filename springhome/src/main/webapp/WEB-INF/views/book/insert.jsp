<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>도서 정보 입력</h1>
		<form action="insert" method="post">
			<input name="name" placeholder="책 제목" required type="text">
			<input name = "writer" placeholder="작가" required  type="text">
			<input name = "publisher" placeholder="출판사" required type="text">
			<input name= "price" placeholder="가격" required type="number">
			<input name ="genre" placeholder="장르" required type="text">
			<input name = "creationTime" placeholder="출간일" required type="date">
		<button>등록</button>
		</form>

</body>
</html>