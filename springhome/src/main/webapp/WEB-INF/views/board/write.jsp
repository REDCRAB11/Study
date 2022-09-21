<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="자유 게시판" name="title"/>
</jsp:include>
<c:set var="isReply" value="${param.boardParent != null}"></c:set>
<c:choose>
	<c:when test="${isReply}">
		<h1>답글 작성</h1>
	</c:when>
	<c:otherwise>
		<h1>게시글 작성</h1>
	</c:otherwise>
</c:choose>



<form action="write" method="post">
<%-- 답글이라면 부모글번호를 추가로 전송하도록 처리 --%>
<c:if test="${isReply}">
	<input type="hidden" name="boardParent" 
									value="${param.boardParent}">
</c:if>

<table border="1" width="500">
	<tbody>
		<tr>
			<th>말머리</th>
			<td>
				<select name="boardHead">
					<option value="">선택</option>
					<option>정보</option>
					<option>유머</option>
					
					<c:if test="${mg == '관리자'}">
					<option>공지</option>
					</c:if>
				</select>
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="boardTitle" required>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<!-- 
					여러 줄 입력이 가능한 도구
					- rows 는 기본 표시 줄 수
					- cols 는 기본 표시 칸 수 
				-->
				<textarea name="boardContent" rows="10" cols="50" required></textarea>
			</td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td align="right" colspan="2">
				<a href="list">목록으로</a>
				<button type="submit">등록하기</button>
			</td>
		</tr>
	</tfoot>
</table>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>