<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="${dto.no}번 방명록" name="title"/>
</jsp:include>

<div class="container-500">
	<div class="row center">
		<h1>${dto.no}번 방명록 보기</h1>
	</div>
	<div class="row center">
		<table class="table table-border">
			<tbody>
				<tr>
					<th width="25%">작성자</th>
					<td>${dto.name}</td>
				</tr>
				<tr height="250" valign="top">
					<th>내용</th>
					<td>${dto.memo}</td>
				</tr>
			</tbody>
		</table>		
	</div>
	
	<div class="row center">
		<a class="btn btn-neutral" href="list">목록 보기</a>
	</div>
	<div class="row center">
		<a class="btn btn-positive" href="insert">새로 작성하기</a>
	</div>
	<div class="row center">
		<a class="btn btn-negative" href="edit?no=${dto.no}">수정하기</a>
	</div>
	<div class="row center">
		<a class="btn btn-negative" href="delete?no=${dto.no}">삭제하기</a>
	</div>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>    
 