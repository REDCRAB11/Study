<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="포켓몬 상세 정보" name="title"/>
</jsp:include>

<div align="left">
	
	<h1>몬스터 상세 정보</h1>
	
	<!-- list 태그 -->
	<ul>
		<li>번호 : ${dto.no}</li>
		<li>이름 : ${dto.name}</li>
		<li>속성 : ${dto.type}</li>
	</ul>
	
	<h2><a href="list">목록</a></h2>
	<h2><a href="insert">등록</a></h2>
	<h2><a href="edit?no=${dto.no}">수정</a></h2>
	<h2><a href="delete?no=${dto.no}">삭제</a></h2>
	
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>