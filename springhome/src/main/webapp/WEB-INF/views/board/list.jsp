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

<style>
	.table a {
		text-decoration: none;
		color:black;
	}
	.table a:hover {
		color:red;
	}
</style>

<div class="container-900 mt-40 mb-40">
	<div class="row center">
		<h1>자유 게시판</h1>
	</div>
	
	<%-- 관리자일 경우만 form을 추가 --%>
	<c:if test="${mg == '관리자'}">
	<form action="delete_admin" method="get">
	</c:if>
	
	<c:if test="${loginId != null}">
	<div class="row right">
		
		<%-- 관리자일 경우만 삭제버튼을 추가 --%>
		<c:if test="${mg == '관리자'}">
			<button type="submit" class="btn btn-negative">삭제</button>
		</c:if>
		
		<a class="btn btn-neutral" href="write">글쓰기</a>
	</div>
	</c:if>
	
	<div class="row center">
		<table class="table table-border table-hover">
			<thead>
				<tr>
					<%-- 관리자일 경우만 체크박스란을 추가 --%>
					<c:if test="${mg == '관리자'}">
					<th>
						<input type="checkbox" class="check-all">
					</th>
					</c:if>
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
					<%-- 관리자일 경우만 체크박스란을 추가 --%>
					<c:if test="${mg == '관리자'}">
					<td>
						<input type="checkbox" class="check-item"
								name="boardNo" value="${boardDto.boardNo}">
					</td>
					</c:if>
				
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
						
						<!-- 좋아요 개수 출력 -->
						<c:if test="${boardDto.boardLike > 0}">
							♥ ${boardDto.boardLike}
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
 		</table>
	</div>
	
	<c:if test="${loginId != null}">
	<div class="row right">
		<%-- 관리자일 경우만 삭제버튼을 추가 --%>
		<c:if test="${mg == '관리자'}">
			<button type="submit" class="btn btn-negative">삭제</button>
		</c:if>
		<a class="btn btn-neutral" href="write">글쓰기</a>
	</div>
	</c:if>
	
	<%-- 관리자일 경우만 form을 추가 --%>
	<c:if test="${mg == '관리자'}">
	</form>
	</c:if>
	
	<div class="row center">
		<ul class="pagination">
			<!-- 이전 -->
			<c:choose>
				<c:when test="${not vo.isFirst()}">
					<li><a href="list?p=${vo.firstBlock()}&${vo.parameter()}">&laquo;</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="#">&laquo;</a></li>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${vo.hasPrev()}">
					<li><a href="list?p=${vo.prevBlock()}&${vo.parameter()}">&lt;</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="#">&lt;</a></li>
				</c:otherwise>
			</c:choose>
			
			<!-- 숫자 -->
			<c:forEach var="i" begin="${vo.startBlock()}" end="${vo.endBlock()}" step="1">
				<c:choose>
					<c:when test="${vo.p == i}">
						<li class="on"><a href="#">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="list?p=${i}&${vo.parameter()}">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<!-- 다음을 누르면 다음 구간의 첫 페이지로 안내 -->
			<c:choose>
				<c:when test="${vo.hasNext()}">
					<li><a href="list?p=${vo.nextBlock()}&${vo.parameter()}">&gt;</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="#">&gt;</a></li>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${not vo.isLast()}">
					<li><a href="list?p=${vo.lastBlock()}&${vo.parameter()}">&raquo;</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="#">&raquo;</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
	
	<!-- 검색창 -->
	<div class="row center">
		<form action="list" method="get">
			<input type="hidden" name="size" value="${vo.size}">
			<select class="input" name="type" required>
				<option value="board_title" <c:if test="${vo.type == 'board_title'}">selected</c:if>>제목</option>
				<option value="board_writer" <c:if test="${vo.type == 'board_writer'}">selected</c:if>>작성자</option>
			</select>
			
			<input class="input" type="search" name="keyword" placeholder="검색어" required value="${vo.keyword}">
			
			<button class="btn btn-positive" type="submit">검색</button>
		</form>
	</div>
</div>




<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
