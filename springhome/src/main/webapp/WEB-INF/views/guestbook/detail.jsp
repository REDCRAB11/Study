<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${dto.no}번 방명록</title>
</head>
<body>

	<div align="center">
		<h1>${dto.no}번 방명록 보기</h1>
		
		<table border="1" width="400">
			<tbody>
				<tr>
					<th width="25%">작성자</th>
					<td>${dto.name}</td>
				</tr>
				<tr height="250" valign="top">
					<th>내용</th>
					<td>${dto.memo}</td>
				</tr>
			</tbody>
		</table>		
	</div>
</body>
</html>
