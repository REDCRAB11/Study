<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="자유 게시판" name="title"/>
</jsp:include>

<h1>게시글 수정</h1>

<form action="edit" method="post">
<!-- input[type=hidden]은 form 안에 위치해야 한다 -->
<input type="hidden" name="boardNo" value="${boardDto.boardNo}">

<table border="1" width="500">
	<tbody>
		<tr>
			<th>말머리</th>
			<td>
				<select name="boardHead">
					<option value="">선택</option>
					<option <c:if test="${boardDto.boardHead == '정보'}">selected</c:if>>정보</option>
					<option <c:if test="${boardDto.boardHead == '유머'}">selected</c:if>>유머</option>
					
					<c:if test="${mg == '관리자'}">
					<option <c:if test="${boardDto.boardHead == '공지'}">selected</c:if>>공지</option>
					</c:if>
				</select>
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="boardTitle" required value="${boardDto.boardTitle}">
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<!-- 
					textarea는 value 속성이 없고 시작태그와 종료태그 사이에 작성
					(주의) pre 태그와 동일하므로 엔터나 띄어쓰기 조심
				-->
				<textarea name="boardContent" rows="10" cols="50" 
						required>${boardDto.boardContent}</textarea>
			</td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td align="right" colspan="2">
				<a href="list">목록으로</a>
				<button type="submit">수정하기</button>
			</td>
		</tr>
	</tfoot>
</table>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
