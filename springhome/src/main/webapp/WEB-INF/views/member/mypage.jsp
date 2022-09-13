<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div align="center">
		<h1>${loginId}의 마이페이지</h1>
			<table border="1" width="500" height="50">
				<tr height="20%">
					<th width="20%"><a href="/member/edit" >회원 정보 수정</a></th>
					<th width="20%"><a href="/member/detail" >회원 상세 보기</a></th>
					<th width="20%"><a href="delete?memberId=${loginId}" >회원 탈퇴</a></th>
					<th width="20%"><a href="/" >메인페이지</a></th>
			</table>
	</div>
</body>
</html>
