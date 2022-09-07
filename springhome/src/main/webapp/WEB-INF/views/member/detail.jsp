<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${dto.memberId}회원 정보 </title>
</head>
<body>
	<div align = "center">
		<h1>회원 정보 조회</h1>
			<table border="1" width="400">
				<tbody>
					<tr>
						<th width="25%">아이디</th>
						<td>${dto.memberId}</td>
					</tr>	
						<tr>
						<th width="25%">닉네임</th>
						<td>${dto.memberNick}</td>
					</tr>	
						<tr>
						<th width="25%">생일</th>
						<td>${dto.memberBirth}</td>
					</tr>	
						<tr>
						<th width="25%">전화번호</th>
						<td>${dto.memberTel}</td>
					</tr>	
						<tr>
						<th width="25%">우편번호</th>
						<td>${dto.memberPost}</td>
					</tr>	
						<tr>
						<th width="25%">기본주소</th>
						<td>${dto.memberBaseAddress}</td>
					</tr>	
						<tr>
						<th width="25%">상세주소</th>
						<td>${dto.memberDetailAddress}</td>
					</tr>	
						<tr>
						<th width="25%">포인트</th>
						<td>${dto.memberPoint}</td>
					</tr>	
						<tr>
						<th width="25%">등급</th>
						<td>${dto.memberGrade}</td>
					</tr>	
						<tr>
						<th width="25%">접속기록</th>
						<td>${dto.memberLogin}</td>
					</tr>	
				</tbody>
			</table>
	
	</div>

</body>
</html>