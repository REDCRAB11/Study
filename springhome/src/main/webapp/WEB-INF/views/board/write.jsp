<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 현재 시간 구하기 -->
<jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
<c:set var="today">
	<fmt:formatDate value="${now}" pattern="yyyy-MM-dd"/>
</c:set>

<!-- 테스트용 데이터 출력 -->
<%-- <h3>${vo}</h3> --%>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="자유 게시판" name="title"/>
</jsp:include>

<h1>자유 게시판</h1>

<table border="1" width="800">
	<thead>
		<c:if test="${loginId != null}">
		<tr>
			<td align="right" colspan="8">
				<a href="write">글쓰기</a>
			</td>
		</tr>
		</c:if>
		<tr>
			<th>번호</th>
			<th width="45%">제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>그룹</th>
			<th>부모</th>
			<th>차수</th>
		</tr>
	</thead>
	<tbody align="center">
		<c:forEach var="boardDto" items="${list}">
		<tr>
			<td>${boardDto.boardNo}</td>
			<td align="left">
				<!-- 차수만큼 띄어쓰기를 반복 -->
				<c:forEach var="i" begin="1" end="${boardDto.boardDepth}" step="1">
					&nbsp;&nbsp;
				</c:forEach>
				
				<!-- 말머리 출력(있을 경우에만) -->
				<c:if test="${boardDto.boardHead != null}">
					[${boardDto.boardHead}]
				</c:if>
				
				<!-- 제목을 누르면 상세 페이지로 이동하도록 처리 -->
				<a href="detail?boardNo=${boardDto.boardNo}">
					${boardDto.boardTitle}
				</a>
				
				<!-- 댓글 개수 출력 -->
				<c:if test="${boardDto.replyCount > 0}">
					[${boardDto.replyCount}]
				</c:if>
				
			</td>
			<td>${boardDto.boardWriter}</td>
			<td>
				<c:set var="current">
					<fmt:formatDate value="${boardDto.boardWritetime}" pattern="yyyy-MM-dd"/>
				</c:set>
				<c:choose>
					<c:when test="${today == current}">
						<fmt:formatDate value="${boardDto.boardWritetime}" 
													pattern="HH:mm"/>
					</c:when>
					<c:otherwise>
						<fmt:formatDate value="${boardDto.boardWritetime}" 
													pattern="yyyy-MM-dd"/>
					</c:otherwise>
				</c:choose>
			</td>
			<td>${boardDto.boardRead}</td>
			<td>${boardDto.boardGroup}</td>
			<td>${boardDto.boardParent}</td>
			<td>${boardDto.boardDepth}</td>
		</tr>
		</c:forEach>
	</tbody>
	<c:if test="${loginId != null}">
	<tfoot>
		<tr>
			<td align="right" colspan="8">
				<a href="write">글쓰기</a>
			</td>
		</tr>
	</tfoot>
	</c:if>
</table>

<!-- 페이지 네비게이터 -->
<h3> 

<c:choose>
	<c:when test="${not vo.isFirst()}">
		<a href="list?p=${vo.firstBlock()}&${vo.parameter()}">&laquo;</a>
	</c:when>
	<c:otherwise>
		<a href="#">&laquo;</a>
	</c:otherwise>
</c:choose>

<!-- 이전을 누르면 이전 구간의 마지막 페이지로 안내 -->
<c:choose>
	<c:when test="${vo.hasPrev()}">
		<a href="list?p=${vo.prevBlock()}&${vo.parameter()}">&lt;</a>
	</c:when>
	<c:otherwise>
		<a href="#">&lt;</a>
	</c:otherwise>
</c:choose>
 
<c:forEach var="i" begin="${vo.startBlock()}" end="${vo.endBlock()}" step="1">
	<a href="list?p=${i}&${vo.parameter()}">${i}</a>
</c:forEach>

<!-- 다음을 누르면 다음 구간의 첫 페이지로 안내 -->
<c:choose>
	<c:when test="${vo.hasNext()}">
		<a href="list?p=${vo.nextBlock()}&${vo.parameter()}">&gt;</a>
	</c:when>
	<c:otherwise>
		<a href="#">&gt;</a>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${not vo.isLast()}">
		<a href="list?p=${vo.lastBlock()}&${vo.parameter()}">&raquo;</a>
	</c:when>
	<c:otherwise>
		<a href="#">&raquo;</a>
	</c:otherwise>
</c:choose>

</h3>

<!-- 검색창 -->
<form action="list" method="get">
	<input type="hidden" name="size" value="${vo.size}">
	<select name="type" required>
		<option value="board_title" <c:if test="${vo.type == 'board_title'}">selected</c:if>>제목</option>
		<option value="board_writer" <c:if test="${vo.type == 'board_writer'}">selected</c:if>>작성자</option>
	</select>
	
	<input type="search" name="keyword" placeholder="검색어" required value="${vo.keyword}">
	
	<button type="submit">검색</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
