<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSTL 사용 선언 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="방명록" name="title"/>
</jsp:include>

	<div align="center">
		
		<h1>
			방명록
			<a href="insert">작성하기</a>
		</h1>
		
		<!-- 
			검색을 위한 검색창
			- <select>는 주어진 <option>중에서만 선택이 가능하도록 하는 태그 
		-->
		<form action="list" method="get">
			<select name="type" required>
				<option>name</option>
				<option>memo</option>
				<option>no</option>
			</select>
			<input name="keyword" required>
			<button>검색</button>
		</form>
		
		<br><br>
		
		<table border="1" width="400">
			<tbody>
				<c:forEach var="dto" items="${list}">
				<tr>
					<th>${dto.no}</th>
					<td>${dto.name}</td>
					<td>
<!-- 						<a href="/guestbook/detail?no=번호"> -->
						<a href="detail?no=${dto.no}">
							<img src="/image/go.png" width="20" height="20">
						</a>
					</td>
				</tr>
<!-- 				<tr height="80" valign="top"> -->
<%-- 					<td colspan="2">${dto.memo}</td>		 --%>
<!-- 				</tr> -->
				</c:forEach>
			</tbody>
		</table>
		
	</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>