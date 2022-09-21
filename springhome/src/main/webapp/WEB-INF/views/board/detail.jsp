<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="자유 게시판" name="title"/>
</jsp:include>

<h1>게시글 보기</h1>

<table border="1" width="500">
	<tbody>
		<tr>
			<th width="25%">번호</th>
			<td>${boardDto.boardNo}</td>
		</tr>
		<tr>
			<th>말머리</th>
			<td>${boardDto.boardHead}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${boardDto.boardTitle}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${boardDto.boardWriter}</td>
		</tr>
		<tr height="200" valign="top">
			<th>내용</th>
			<td>
				<!-- pre 태그는 엔터, 띄어쓰기, 탭키 등을 있는 그대로 표시하는 영역 -->
				<pre>${boardDto.boardContent}</pre>
			</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${boardDto.boardRead}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>
				<fmt:formatDate value="${boardDto.boardWritetime}" pattern="y년 M월 d일 E요일 a h시 m분 s초"/>
			</td>
		</tr>
		<c:if test="${boardDto.boardUpdatetime != null}">
		<tr>
			<th>수정일</th>
			<td>
				<fmt:formatDate value="${boardDto.boardUpdatetime}" pattern="y년 M월 d일 E요일 a h시 m분 s초"/>
			</td>
		</tr>
		</c:if>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="2" align="right">
				
				<c:if test="${loginId != null}">
				<a href="write">글쓰기</a>
				<a href="write?boardParent=${boardDto.boardNo}">답글쓰기</a>
				<a href ="/board/reply/write">댓글쓰기</a>
				</c:if>
				
				<%--
					관리자는 삭제만, 회원은 자신의 글만 수정/삭제 가능하도록 처리
				 --%>
				<c:set var="owner" value="${loginId == boardDto.boardWriter}"></c:set>
				<c:set var="admin" value="${mg == '관리자'}"></c:set>
				
				<c:if test="${owner}">
				<a href="edit?boardNo=${boardDto.boardNo}">수정하기</a>
				<a href="delete?boardNo=${boardDto.boardNo}">삭제하기</a>
				<a href = "/board/reply/edit?replyNo=${replyDto.replyNo}">댓글 수정</a>
				</c:if>
				
				<c:if test="${admin}">
				<a href="delete?boardNo=${boardDto.boardNo}">삭제하기</a>
				</c:if>
				
				<a href="list">목록으로</a>
			</td>
		</tr>
	</tfoot>
</table>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>