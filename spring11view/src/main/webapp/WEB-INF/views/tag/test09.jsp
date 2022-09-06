<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테이블 예제 </title>
</head>
<body>
		<!--  
		 	table 태그: 
		 	- 화면에 표를 출력하기 위한 태그 
		 	- 잘못된 방식으로 사용하면 글자가 외부로 빠진다.
		 	- 내부에 여러 태그들을 조합하여 사용할 수 있다.
		 	- thead, tbody, tfoot, tr, th,td와 같은 태그들이 등장한다. 
		 	- thead: 테이블 헤더(제목)
		 	- tbody: 테이블 내용
		 	- tfoot: 테이블 하단 도구 
		 	- tr: 테이블 행 
		 	- th: 테이블 컬럼
		 	- td: 테이블 컬럼 
		 	- (주의) 테이블 내부에 글자는 반드시 th/td에만 작성 가능하다. 
		 	- border: 테두리 
		 	- width: 폭(비추천)
		 --> 
		 <table border="1" width="300">
		 	<thead>
		 		<tr>
		 			<th>순위</th>
		 			<th>국가</th>
		 			<th>포인트</th>
		 		</tr>
		 	<tbody>
		 		<tr>
		 			<td>1</td>
		 			<td>브라질</td>
		 			<td>1850.5</td>
		 		</tr>
		 		<tr>
		 			<td>2</td>
		 			<td>아르헨티나</td>
		 			<td>1724.5</td>
		 		</tr>
		 	</tbody>
		</table>
</body>
</html>