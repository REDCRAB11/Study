<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="게시글 목록" name="title"/>
</jsp:include>

    
<div align="center">
	
	<h1>게시글 목록</h1>
	
	<form action="list" method="get">
		<select name="type" required>
			<option value="board_writer">작성자</option>
			<option value="board_title">제목</option>
			<option value="board_content">내용</option>
		</select>
		<input type="search" name="keyword" placeholder="검색어" required>
		<button>검색</button>
	</form>
	
	<hr>
	
	<table border="1" width="700">
		<thead>
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>말머리</th>
				<th>제목</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>좋아요</th>
				<th>내용</th>
				<th>수정일</th>
			</tr>
		</thead>
		<tbody align="center">
			<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.boardNo}</td>
				<td>
					<a href="detail?boardNo=${dto.boardNo}">
						${dto.boardWriter}
					</a>
				</td>
				<td>${dto.boardHead}</td>
				<td>${dto.boardTitle}</td>
				<td>${dto.boardWriteTime}</td>
				<td>${dto.boardRead}</td>
				<td>${dto.boardLike}</td>
				<td>${dto.boardContent}</td>
				<td>${dto.boardUpdateTime}</td>
			</tr>
			</c:forEach>
		</tbody>
		
		<%-- 관리지만 등록 버튼 출력 --%>
		<c:if test="${mg == '관리자'}">
		<tfoot align="right">
			<tr>
				<td colspan="10">
					<a href="insert">등록</a>
				</td>
			</tr>
		</tfoot>
		</c:if>
	</table>
	
</div>
	

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>