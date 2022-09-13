<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="/WEB-INF/views/template/header.jsp">
	</jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
	<div align= "center">
		<h1>회원 정보 수정</h1>
		<form action = "edit" method="post">
			<input type="text" name = "memberNick" required value="${dto.meberNick}"><br><br>
			<input type="date" name = "memberBirth" required value="${dto.memberBirth}"><br><br>
			<input type="text" name = "memberTel" required value="${dto.meberTel}"><br><br>
			<input type="text" name = "memberEmail" required value="${dto.meberEmail}"><br><br>
			<input type="text" name = "memberGrade" required value="${dto.meberGrade}"><br><br>
			<input type="number" name = "memberPoint" required value="${dto.meberPoint}"><br><br>
			<input type="text" name = "memberPost" required value="${dto.meberPost}"><br><br>
			<input type="text" name = "memberBaseAddress" required value="${dto.meberBaseAddress}"><br><br>
			<input type="text" name = "memberDetailAddress" required value="${dto.meberDetailAddress}"><br><br>
			<button>수정</button>
		</form>
	</div>

</body>
</html>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>