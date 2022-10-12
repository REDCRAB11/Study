<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/adminHeader.jsp">
	<jsp:param value="인기 음원 Top ${list.size()}" name="title"/>
</jsp:include>

<div class="container-400">
	<div class="row center">
		<h1>연도별 발매현황</h1>
	</div>
	<div class="row center">
		<table class="table table-border">
			<thead>
				<tr>
					<th>순위</th>
					<th>연도</th>
					<th>개수</th>
				</tr>	
			</thead>
			<tbody align="center">
				<c:forEach var="vo" items="${list}">
				<tr>
					<td>${vo.rank}</td>
					<td>${vo.year}</td>
					<td>${vo.cnt}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<jsp:include page="/WEB-INF/views/template/adminFooter.jsp"></jsp:include>
