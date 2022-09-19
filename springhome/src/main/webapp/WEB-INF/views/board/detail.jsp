<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="게시글 정보" name="title"/>
</jsp:include>


<div align="center">
	<h1>게시글 정보</h1>
	<table border="1" width="400">
		<tbody>
			<tr>
				<th width="25%">번호</th>
				<td>${boardDto.boardNo}</td>
			</tr>
			<tr>
				<th width="25%">작성자</th>
				<td>${boardDto.boardWriter}</td>
			</tr>
			<tr>
				<th width="25%">제목</th>
				<td>${boardDto.boardTitle}</td>
			</tr>
			<tr>
				<th width="25%">내용</th>
				<td>${boardDto.boardContent}</td>
			</tr>
			<tr>
				<th width="25%">작성일</th>
				<td>
				<fmt:formatDate value="${boardDto.boardWriteTime}" pattern="y년 M월 d일 E요일"/>
				</td>
			</tr>
			<tr>
				<th width="25%">수정일</th>
				<td>
					<fmt:formatDate value="${boardDto.boardUpdateTime}" pattern="y년 M월 d일 E요일"/>
				</td>
			</tr>
			<tr>
				<th width="25%">조회수</th>
				<td>${boardDto.boardRead}</td>
			</tr>
			<tr>
				<th width="25%">좋아요</th>
				<td>${boardDto.boardLike}</td>
			</tr>
			<tr>
				<th width="25%">말머리</th>
				<td>${boardDto.boardHead}</td>
			</tr>
		</tbody>
	</table>
	
	<h2><a href="list">목록보기</a></h2>
	<h2><a href="edit?boardNo=${boardDto.boardNo}">수정하기</a></h2>
	<h2><a href="delete?boardNo=${boardDto.boardNo}">삭제하기</a></h2>
	
</div>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>