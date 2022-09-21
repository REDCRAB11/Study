<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="댓글 작성" name="title"/>
</jsp:include>

<h1>댓글 등록</h1>
		<!-- 원글에 댓글을 작성할 수 있는 폼 -->
			<form action="insert" method="post"> 
			<!-- 댓글의 그룹번호는 원글의 글번호가 된다. -->
				<input type="hidden" name="reply_no" value="${replyDto.replyNo}"/>
			<!-- 댓글의 대상자는 원글의 작성자가 된다. -->
				<input type="hidden" name="reply_writer" value="${replyDto.replyWriter }"/>
				<textarea rows="content"><c:if test="${loginId == null}">로그인이 필요합니다.</c:if></textarea>
				<button type="submit">등록</button>
            </form>




<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>