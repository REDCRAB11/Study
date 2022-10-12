<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="음원 목록" name="title"/>
</jsp:include>

<div class="container-800 mt-40 mb-40">
	<!-- 제목 -->
	<div class="row center">
		<h1>음원 목록</h1>
	</div>
	
	<!-- 검색창 -->
	<form action="list" method="get">
	<div class="row center">
		<!-- 항목 -->
		<select class="input" name="type" required>
			<!-- 
				보여지는 글자와 전송할 글자를 분리하여 작성
				value - 전송되는 값 
			-->
			<option value="music_title">제목</option>
			<option value="music_artist">가수</option>
			<option value="music_album">앨범</option>
		</select>
		
		<!-- 키워드 -->
		<input class="input" type="search" name="keyword" placeholder="검색어" required>
		
		<button class="btn btn-positive">검색</button>
	</div>
	</form>
	
	<!-- 목록 출력 -->
	<div class="row">
		<table class="table table-hover table-slit">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>가수</th>
					<th>앨범</th>
					<th>재생수</th>
					<th>발매일</th>
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach var="dto" items="${list}">
				<tr>
					<td>${dto.musicNo}</td>
					<td>
						<a href="detail?musicNo=${dto.musicNo}">
							${dto.musicTitle}
						</a>
						
						<c:if test="${dto.musicPlay >= 5}">
							<img src="/image/hot.png" width="20" height="20">
						</c:if>
					</td>
					<td>${dto.musicArtist}</td>
					<td>${dto.musicAlbum}</td>
					<td>${dto.musicPlay}</td>
					<td>${dto.releaseTime}</td>
				</tr>
				</c:forEach>
			</tbody>
			
			<%-- 관리자만 등록 버튼 출력 --%>
			<c:if test="${mg == '관리자'}">
			<tfoot align="right">
				<tr>
					<td colspan="6">
						<a href="insert">등록</a>
					</td>
				</tr>
			</tfoot>
			</c:if>
			
		</table>
	</div>

	<div class="row">
		<ul class="pagination pagination-small">
			<li><a href="#">&laquo;</a></li>
			<li><a href="#">&lt;</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">6</a></li>
			<li><a href="#">7</a></li>
			<li><a href="#">8</a></li>
			<li><a href="#">9</a></li>
			<li><a href="#">10</a></li>
			<li><a href="#">&gt;</a></li>
			<li><a href="#">&raquo;</a></li>
		</ul>
	</div>
	
</div>
    
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>