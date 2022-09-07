<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${dto.no}번 방명록</title>
</head>
<body>
		<div align = "left">
			<h1>방명록 상세 정보</h1>
				<table border="1" width="400">
					<tbody>
						<tr>
							<th width=25%">작성자</th>
							<td>${dto.name}</td>
						</tr>
						<tr height="250" valign="top">
							<th>내용</th>
							<td>${dto.memo}</td>
					<h3><a href = "list" > 목록으로 돌아가기</a></h3>	
					<h3><a href = "insert">등록으로 돌아가기</a></h3>
		</tbody>
		</table>
		</div>
</body>
</html>