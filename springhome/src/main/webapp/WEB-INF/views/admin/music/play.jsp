<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include  page="/WEB-INF/views/template/adminHeader.jsp">
	<jsp:param value="음원 ${list.size()}" name="title"/>
</jsp:include>
	<h1>TOP ${list.size()} </h1>
	
	<a href= "/admin/music/play/3">TOP 3</a>
	<a href= "/admin/music/play/5">TOP 5</a>
	<a href= "/admin/music/play/10">TOP 10</a>
	<table border="1" width="600">
		<thead>
			<tr>
				<th>순위</th>
				<th>타이틀</th>
				<th>아티스트</th>
				<th>앨범</th>
				<th>재생수</th>
			</tr>
		</thead>
		<tbody align="center">
			<c:forEach var="vo" items="${list}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${dto.musicTitle}</td>
				<td>${dto.musicArtist}</td>
				<td>${dto.musicAlbum}</td>
				<td>${dto.musicPlay}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
<jsp:include page="/WEB-INF/views/template/adminFooter.jsp"></jsp:include>