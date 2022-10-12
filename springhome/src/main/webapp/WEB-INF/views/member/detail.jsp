<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
	.btn-small {
		padding:0.25em !important;
	}
</style>

<%-- 관리자 메뉴일 경우와 아닐 경우 다른 헤더를 설정 --%>
<c:choose>
	<c:when test="${mg == '관리자'}">
		<jsp:include page="/WEB-INF/views/template/adminHeader.jsp">
			<jsp:param value="${memberDto.memberId} 회원 정보" name="title"/>
		</jsp:include>
	</c:when>
	<c:otherwise>
		<jsp:include page="/WEB-INF/views/template/header.jsp">
			<jsp:param value="${memberDto.memberId} 회원 정보" name="title"/>
		</jsp:include>
	</c:otherwise>
</c:choose>
   
<div class="container-600 mt-40 mb-40">
	<div class="row left">
		<h1 style="padding-left:20px">${memberDto.memberId} 회원 정보</h1>
	</div>
	
	<div class="row center">
		<table class="table">
			<tbody>
				<!-- 프로필 이미지를 출력 -->
				<tr>
					<th width="30%" valign="top" class="center">
						<table class="table">
							<tbody class="center">
								<tr><td>
									<img class="image image-circle image-shadow" src="download?memberId=${memberDto.memberId}" width="100" height="100">
								</td></tr>
								<c:choose>
									<c:when test="${mg == '관리자'}">
										<!-- 관리자용 메뉴 -->
										<tr><td>
											<a class="btn btn-neutral btn-small" href="list">목록 보기</a>
										</td></tr>
										<tr><td>
											<a class="btn btn-neutral btn-small" href="change?memberId=${memberDto.memberId}">정보 변경</a>
										</td></tr>
										<tr><td>
											<a class="btn btn-neutral btn-small" href="exit?memberId=${memberDto.memberId}">회원 탈퇴</a>
										</td></tr>
									</c:when>
									<c:otherwise>
										<!-- 회원용 메뉴 -->
										<tr><td>
										<a class="btn btn-neutral btn-small" href="password">비밀번호 변경</a>
										</td></tr>
										<tr><td>
										<a class="btn btn-neutral btn-small" href="information">개인정보 변경</a>
										</td></tr>
										<tr><td>
										<a class="btn btn-neutral btn-small" href="goodbye">회원 탈퇴</a>
										</td></tr>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
					</th>
					<td>
						<table class="table table-border">
							<tr>
								<th width="25%">아이디</th>
								<td>${memberDto.memberId}</td>
							</tr>
							<tr>
								<th>닉네임</th>
								<td>${memberDto.memberNick}</td>
							</tr>
							<tr>
								<th>생년월일</th>
								<td>${memberDto.memberBirth}</td>
							</tr>
							<tr>
								<th>전화번호</th>
								<td>${memberDto.memberTel}</td>
							</tr>
							<tr>
								<th>이메일</th>
								<td>${memberDto.memberEmail}</td>
							</tr>
							<tr>
								<th>주소</th>
								<td>
									<c:if test="${memberDto.memberPost != null}">
									[${memberDto.memberPost}]
									${memberDto.memberBaseAddress}
									${memberDto.memberDetailAddress}
									</c:if>
								</td>
							</tr>
							<tr>
								<th>포인트</th>
								<td>
									<fmt:formatNumber value="${memberDto.memberPoint}" pattern="#,##0"/> point
								</td>
							</tr>
							<tr>
								<th>권한</th>
								<td>
									${memberDto.memberGrade}
								</td>
							</tr>
							<tr>
								<th>가입일시</th>
								<td>
									<fmt:formatDate value="${memberDto.memberJoin}" pattern="y년 M월 d일 E a h시 m분 s초"/>
								</td>
							</tr>
							<tr>
								<th>로그인일시</th>
								<td>
									<fmt:formatDate value="${memberDto.memberLogin}" pattern="y년 M월 d일 E a h시 m분 s초"/>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<div class="row left">
		<h1 style="padding-left:20px">내가 작성한 게시글</h1>
	</div>
	
	<div class="row left">
		<c:choose>
			<c:when test="${writeBoardList.isEmpty()}">
				<h4 style="padding-left:20px">
					작성한 게시글이 없습니다
				</h4>
			</c:when>
			<c:otherwise>
				<table class="table table-border">
					<thead>
						<tr>
							<th width="60%">제목</th>
							<th>작성일</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody align="center">
						<c:forEach var="boardDto" items="${writeBoardList}">
						<tr>
							<td align="left">
								<c:if test="${boardDto.boardHead}">
									[${boardDto.boardHead}]
								</c:if>
								<a href="/board/detail?boardNo=${boardDto.boardNo}">
									${boardDto.boardTitle}
								</a>
							</td>
							<td>${boardDto.boardWritetime}</td>
							<td>${boardDto.boardRead}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>	
	</div>
	
	<div class="row left">
		<h1 style="padding-left:20px">좋아요를 누른 게시글</h1>
	</div>
	<div class="row left">
		<c:choose>
			<c:when test="${likeBoardList.isEmpty()}">
				<h4 style="padding-left:20px">
					좋아요를 누른 게시글이 없습니다
				</h4>
			</c:when>
			<c:otherwise>
				<table class="table table-border">
					<thead>
						<tr>
							<th width="60%">제목</th>
							<th>작성자</th>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody align="center">
						<c:forEach var="boardDto" items="${likeBoardList}">
						<tr>
							<td align="left">
								<c:if test="${boardDto.boardHead}">
									[${boardDto.boardHead}]
								</c:if>
								<a href="/board/detail?boardNo=${boardDto.boardNo}">
									${boardDto.boardTitle}
								</a>
							</td>
							<td>${boardDto.boardWriter}</td>
							<td>${boardDto.boardWritetime}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
</div>
	
<c:choose>
	<c:when test="${mg == '관리자'}">
		<jsp:include page="/WEB-INF/views/template/adminFooter.jsp"></jsp:include>
	</c:when>
	<c:otherwise>
		<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
	</c:otherwise>
</c:choose>


