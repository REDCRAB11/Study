<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include  page="/WEB-INF/views/template/adminHeader.jsp">
	<jsp:param value="음원 Top10" name="title"/>
</jsp:include>
	<h1>TOP 10 + 발매일</h1>
	<br>
	<table border="1" width="300">
		<thead>
			<tr>
				<th>타이틀</th>
				<th>아티스트</th>
				<th>앨범</th>
				<th>재생수</th>
				<th>발매일</th>
			</tr>
		</thead>
		<tbody align="center">
			<c:forEach var="dto" items="${play}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${dto.musicTitle}</td>
				<td>${dto.musicArtist}</td>
				<td>${dto.musicAlbum}</td>
				<td>${dto.musicPlay}</td>
				<td>${dto.releaseTime}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
<jsp:include page="/WEB-INF/views/template/adminFooter.jsp"></jsp:include>