<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="자유 게시판" name="title"/>
</jsp:include>

<style>
	.heart {
		text-decoration: none;
		color:red;
	}
	.attachment-list {
		margin:0;
		padding:0;
		list-style:none;
	}
</style>

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(function(){
		//목표 : 
		//1. edit-btn을 누르면 view를 숨기고 editor를 보여준다
		//2. cancel-btn을 누르면 editor를 숨기고 view를 보여준다
		//3. 처음에는 view만 보여준다
		//1
		$(".edit-btn").click(function(){
			$(this).parents(".view").hide();
			$(this).parents(".view").next(".editor").show();
		});
		//2
		$(".cancel-btn").click(function(){
			$(this).parents(".editor").hide();
			$(this).parents(".editor").prev(".view").show();
		});
		//3
		$(".editor").hide();
	});
</script>

<div class="container-800 mt-40 mb-40">
	<div class="row center">
		<h1>게시글 보기</h1>
	</div>
	
	<div class="row center">
		<table class="table table-border">
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
					<td>
						${boardDto.boardTitle}
						
						<!-- 좋아요 하트 -->
						<c:if test="${isLike == null}">
							<a class="heart">♥</a>
						</c:if>
						<c:if test="${isLike == true}">
							<a class="heart" href="like?boardNo=${boardDto.boardNo}">♥</a>
						</c:if>
						<c:if test="${isLike == false}">
							<a class="heart" href="like?boardNo=${boardDto.boardNo}">♡</a>
						</c:if>
						
						<!-- 좋아요 개수 -->
						${likeCount}, ${boardDto.boardLike}		
		
					</td>
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
				
				<c:if test="${attachmentList != null}">
				<tr>
					<th>첨부파일</th>
					<td>
						<ul class="attachment-list">
							<c:forEach var="attachmentDto" items="${attachmentList}">
							<li>
								${attachmentDto.attachmentName} 
								(${attachmentDto.attachmentSize} bytes) 
								- 
								[${attachmentDto.attachmentType}]
								<a href="/attachment/download/${attachmentDto.attachmentNo}"><img src="/image/download.png" width="15" height="15"></a>
							</li>
							</c:forEach>
						</ul>
					</td>
				</tr>
				</c:if>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2" align="right">
						
						<c:if test="${loginId != null}">
						<a class="btn btn-positive" href="write">글쓰기</a>
						<a class="btn btn-positive" href="write?boardParent=${boardDto.boardNo}">답글쓰기</a>
						</c:if>
						
						<%--
							관리자는 삭제만, 회원은 자신의 글만 수정/삭제 가능하도록 처리
						 --%>
						<c:set var="owner" value="${loginId == boardDto.boardWriter}"></c:set>
						<c:set var="admin" value="${mg == '관리자'}"></c:set>
						
						<c:if test="${owner}">
						<a class="btn btn-negative" href="edit?boardNo=${boardDto.boardNo}">수정하기</a>
						<a class="btn btn-negative" href="delete?boardNo=${boardDto.boardNo}">삭제하기</a>
						</c:if>
						
						<c:if test="${admin}">
						<a class="btn btn-negative" href="delete?boardNo=${boardDto.boardNo}">삭제하기</a>
						</c:if>
						
						<a class="btn btn-neutral" href="list">목록으로</a>
					</td>
				</tr>
			</tfoot>
		</table>	
	</div>
	
	<div class="row center">
		<table class="table table-slit table-hover">
			<!-- 댓글 목록 -->
			<thead>
				<tr>
					<td colspan="2">
						총 ${replyList.size()}개의 댓글이 있습니다.
					</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="replyDto" items="${replyList}">
				
				<!-- 사용자에게 보여주는 화면 -->
				<tr class="view">
					<td width="90%">
						<!-- 작성자 -->
						${replyDto.memberNick}
						(${replyDto.replyWriter})
						<c:if test="${boardDto.boardWriter ==  replyDto.replyWriter}">
						(작성자)
						</c:if>
						
						(${replyDto.memberGrade}) 
						<br>
						
						<!-- 블라인드 여부에 따라 다르게 표시 -->
						<c:choose>
							<c:when test="${replyDto.replyBlind}">
								<pre>블라인드 처리된 게시물입니다</pre>
							</c:when>
							<c:otherwise>
								<pre>${replyDto.replyContent}</pre>
							</c:otherwise>
						</c:choose>
						
						<br><br>
						<fmt:formatDate value="${replyDto.replyWritetime}" 
													pattern="yyyy-MM-dd HH:mm"/>
					</td>
					<th>
						<!-- 수정과 삭제는 현재 사용자가 남긴 댓글에만 표시 -->
						<c:if test="${loginId == replyDto.replyWriter}">
							<a style="display:block; margin:10px 0px;" class="edit-btn"><img src="/image/edit.png" width="20" height="20"></a>
							<a style="display:block; margin:10px 0px;" href="reply/delete?replyNo=${replyDto.replyNo}&replyOrigin=${replyDto.replyOrigin}"><img src="/image/delete.png" width="20" height="20"></a>
						</c:if>
						
						<c:if test="${admin}">
							<!-- 블라인드 여부에 따라 다르게 표시 -->
							<c:choose>
								<c:when test="${replyDto.replyBlind}">
									<a style="display:block; margin:10px 0px;" href="reply/blind?replyNo=${replyDto.replyNo}&replyOrigin=${replyDto.replyOrigin}"><img src="/image/blind2.png" width="20" height="20"></a>
								</c:when>
								<c:otherwise>
									<a style="display:block; margin:10px 0px;" href="reply/blind?replyNo=${replyDto.replyNo}&replyOrigin=${replyDto.replyOrigin}"><img src="/image/blind.png" width="20" height="20"></a>
								</c:otherwise>
							</c:choose>
							
						</c:if>
					</th>
				</tr>
				
				<c:if test="${loginId ==  replyDto.replyWriter}">
				<!-- 수정하기 위한 화면 : 댓글 작성자 본인에게만 출력 -->
				<tr class="editor">
					<th colspan="2">
						<form action="reply/edit" method="post">
							<input type="hidden" name="replyNo" 
														value="${replyDto.replyNo}">
							<input type="hidden" name="replyOrigin"
														value="${replyDto.replyOrigin}">
							<textarea name="replyContent" rows="5" cols="50" 
									required>${replyDto.replyContent}</textarea>
							<button type="submit">변경</button>
							<a class="cancel-btn">취소</a>
						</form>
					</th>
				</tr>
				</c:if>
				
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="row center">
		<%-- 회원일 경우와 아닐 경우 댓글 작성창이 다르게 보이도록 처리 --%>
		<c:choose>
			<c:when test="${loginId != null}">
				<!-- 댓글 작성 -->
				<form action="reply/write" method="post">
				<input type="hidden" name="replyOrigin" value="${boardDto.boardNo}">
				<table class="table">
					<tbody>
						<tr>
							<th>
								<textarea class="input w-100 fix-size" name="replyContent" rows="5" cols="55" 
												placeholder="댓글 작성.." required></textarea>
							</th>
							<th valign="bottom">
								<button class="btn btn-positive" type="submit">등록</button>
							</th>
						</tr>
					</tbody>
				</table>
				</form>
			</c:when>
			<c:otherwise>
				<table class="table">
					<tbody>
						<tr>
							<th>
								<textarea name="replyContent" rows="5" cols="55" 
									placeholder="로그인 후 댓글 작성이 가능합니다" disabled></textarea>
							</th>
							<th>
								<button type="submit" disabled>등록</button>
							</th>
						</tr>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
</div>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>