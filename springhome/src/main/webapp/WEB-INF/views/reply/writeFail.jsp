<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="댓글 작성" name="title"/>
</jsp:include>

<form action="insert" method="post">
				<!-- 덧글 그룹 -->
				<input type="hidden" name="replyWriter" value="${replyDto.replyWriter}" />
				<!-- 덧글 대상 -->
				<input type="hidden" name="replyWriter" value="${replyDto.replyWriter}" />
				<input type="hidden" name="comment_group" value="${tmp.comment_group }" />
				<textarea name="content"><c:if test="${empty id }">로그인이 필요합니다.</c:if></textarea>
				<button type="submit">등록</button>
</form>	


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>