<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:include page="/WEB-INF/views/template/adminHeader.jsp">
	<jsp:param value="포켓몬 현황" name="title"/>
</jsp:include>

<h1>포켓몬 현황</h1>

<ol>
	<c:forEach var="vo" items="${list}">
	<li>${vo.type} - ${vo.cnt} 마리</li>
	</c:forEach>
</ol>

<table border="1" width="300">
	<thead>
		<tr>
			<th>순위</th>
			<th>속성</th>
			<th>개체수</th>
		</tr>
	</thead>
	<tbody align="center">
		<%--
			varStatus를 사용하면 반복문의 상태를 알 수 있다.
			- count : 출력중인 데이터의 개수(순서)
			- index : 출력중인 데이터의 위치(인덱스)
			- first : 처음인지 아닌지 반환
			- last : 마지막인지 아닌지 반환
		 --%>
		<c:forEach var="vo" items="${list}" varStatus="status">
		<tr>
			<td>${status.count}</td>
			<td>${vo.type}</td>
			<td>${vo.cnt}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/template/adminFooter.jsp"></jsp:include>
