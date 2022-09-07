<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
						<th width="25%">주소</th>
						<td>
						<c:if test="${dto.memberPost != null }">
						[${dto.memberPost}]
						${dto.memberDetailAddress}
						${dto.memberBaseAddress}
						</c:if>
						</td>
					</tr>	
						<tr>
						<th width="25%">포인트</th>
						<td>
						<fmt:formatNumber value="${dto.memberPoint}" pattern="#,##0"/> point
					</td>
					</tr>	
						<tr>
						<th width="25%">등급</th>
						<td>${dto.memberGrade}</td>
					</tr>	
						<tr>
						<th width="25%">가입일</th>
						<td>
						<fmt:formatDate value="${dto.memberJoin}" pattern="y년 M월 d일 E a h시 m분 s초 "/>
						</td>
					</tr>	
						<tr>
						<th width="25%">접속기록</th>
						<td>
						<fmt:formatDate value="${dto.memberLogin}" pattern="y년 M월 d일 E a h시 m분 s초"/>
						</td>
					</tr>	
				</tbody>
			</table>
	
	</div>

</body>
</html>