<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="포켓몬 목록" name="title"/>
</jsp:include>

<div align="center">
	<h1>포켓몬 목록</h1>
	
	<table border="1" width="300">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>속성</th>
			</tr>
		</thead>
		<tbody align="center">
			<%-- for(PocketMonsterDto dto : list){} --%>
			<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.no}</td>
				<td>
					<a href="detail?no=${dto.no}">${dto.name}</a>
				</td>
				<td>${dto.type}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>